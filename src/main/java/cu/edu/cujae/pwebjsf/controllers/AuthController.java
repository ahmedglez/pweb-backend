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
}
