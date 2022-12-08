package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired
  private UserServices userServices;

  @PostMapping("/login")
  public ResponseEntity<UserDto> login(@RequestBody UserDto user) {
    UserDto userDto = userServices.login(user);
    if (userDto != null) {
      return ResponseEntity.ok(userDto);
    } else {
      return ResponseEntity.badRequest().build();
    }
  }

  @PostMapping("/checkRecoveryCode")
  public ResponseEntity<UserDto> checkRecoveryCode(@RequestBody UserDto user) {
    UserDto userDto = userServices.getUserByEmail(user.getEmail());
    if (userDto != null) {
      if (userDto.getRecoverCode().equals(user.getRecoverCode())) {
        return ResponseEntity.ok(userDto);
      } else {
        return ResponseEntity.badRequest().build();
      }
    } else {
      return ResponseEntity.badRequest().build() ;
    }
  }

  @PostMapping("/changePassword")
  public ResponseEntity<String> changePassword(@RequestBody UserDto user) {
    UserDto userDto = userServices.getUserByEmail(user.getEmail());
    if (userDto != null) {
      userDto.setPassword(user.getPassword());
      userServices.save(userDto);
      return ResponseEntity.ok("Contraseña cambiada");
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
