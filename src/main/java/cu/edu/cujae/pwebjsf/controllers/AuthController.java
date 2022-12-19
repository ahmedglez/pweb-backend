package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.CustomUserDetailsServices;
import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.AuthenticationRequest;
import cu.edu.cujae.pwebjsf.services.dto.AuthenticationResponse;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import cu.edu.cujae.pwebjsf.services.dto.UserForRecoverCode;
import cu.edu.cujae.pwebjsf.utils.JWTUtil;
import cu.edu.cujae.pwebjsf.utils.PasswordEncoderUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

  @Autowired
  private UserServices userServices;

  private PasswordEncoderUtils passwordEncoderUtils = new PasswordEncoderUtils();

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private CustomUserDetailsServices userDetailsServices;

  @Autowired
  private JWTUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> login(
    @RequestBody AuthenticationRequest request
  ) {
    try {
      if (request.getUsername() == null || request.getPassword() == null) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }

      UserDto user = userServices.findByUserName(request.getUsername());
      if (user == null) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }
      boolean isPasswordValid = passwordEncoderUtils.isPasswordValid(
        request.getPassword(),
        user.getPassword()
      );
      if (isPasswordValid == false) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
      }

      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
          request.getUsername(),
          user.getPassword()
        )
      );

      UserDetails userDetails = userDetailsServices.loadUserByUsername(
        request.getUsername()
      );
      String token = jwtUtil.generateToken(userDetails);
      String refreshToken = jwtUtil.generateRefreshToken(userDetails);
      AuthenticationResponse response = new AuthenticationResponse(
        token,
        refreshToken
      );
      return new ResponseEntity<AuthenticationResponse>(
        response,
        HttpStatus.OK
      );
    } catch (BadCredentialsException e) {
      return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
  }

  @GetMapping("/logout")
  public String logoutPage(
    HttpServletRequest request,
    HttpServletResponse response
  ) {
    try {
      Authentication auth = SecurityContextHolder
        .getContext()
        .getAuthentication();
      if (auth != null) {
        new SecurityContextLogoutHandler().logout(request, response, auth);
      }
      /* set Authentication null for the token */
      return "redirect:/http://localhost:8080/pweb-jsf-0.0.1-SNAPSHOT/";
    } catch (Exception e) {
      return "redirect:/http://localhost:8080/pweb-jsf-0.0.1-SNAPSHOT/";
    }
  }

  @PostMapping("/checkRecoveryCode")
  public ResponseEntity<UserDto> checkRecoveryCode(
    @RequestBody UserForRecoverCode user
  ) {
    UserDto userDto = userServices.getUserByEmail(user.getEmail());
    if (userDto != null) {
      if (userDto.getRecoverCode().equals(user.getRecoveryCode())) {
        return ResponseEntity.ok(userDto);
      } else {
        return ResponseEntity.badRequest().build();
      }
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping("/changePassword")
  public ResponseEntity<String> changePassword(@RequestBody UserDto user) {
    UserDto userDto = userServices.getUserByEmail(user.getEmail());
    if (userDto != null) {
      if (userDto.getRecoverCode().equals(user.getRecoverCode())) {
        userDto.setPassword(user.getPassword());
        userDto.setRecoverCode("");
        userServices.save(userDto);
        return ResponseEntity.ok("Contraseña cambiada");
      } else {
        return ResponseEntity.badRequest().build();
      }
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody UserDto user) {
    UserDto userDto = userServices.getUserByEmail(user.getEmail());
    if (userDto == null) {
      userServices.save(user);
      return ResponseEntity.ok("Usuario registrado");
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping("/checkEmail")
  public ResponseEntity<String> checkEmail(@RequestBody UserDto user) {
    UserDto userDto = userServices.getUserByEmail(user.getEmail());
    if (userDto != null) {
      return ResponseEntity.ok("Correo registrado");
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping("/refreshToken")
  public ResponseEntity<AuthenticationResponse> refreshToken(
    @RequestBody AuthenticationResponse request
  ) {
    String token = request.getJwttoken();
    String refreshToken = request.getRefreshToken();
    UserDetails userDetails = userDetailsServices.loadUserByUsername(
      jwtUtil.extractUsername(token)
    );
    if (
      jwtUtil.validateToken(token, userDetails) &&
      jwtUtil.validateToken(refreshToken, userDetails)
    ) {
      String newToken = jwtUtil.generateTokenFromRefreshToken(refreshToken);
      String newRefreshToken = jwtUtil.generateRefreshTokenFromRefreshToken(
        refreshToken
      );
      AuthenticationResponse response = new AuthenticationResponse(
        newToken,
        newRefreshToken
      );
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
