package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.CustomUserDetailsServices;
import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.AuthenticationRequest;
import cu.edu.cujae.pwebjsf.services.dto.AuthenticationResponse;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import cu.edu.cujae.pwebjsf.services.dto.UserForRecoverCode;
import cu.edu.cujae.pwebjsf.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

  @Autowired
  private UserServices userServices;

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
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
          request.getUsername(),
          request.getPassword()
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
}
