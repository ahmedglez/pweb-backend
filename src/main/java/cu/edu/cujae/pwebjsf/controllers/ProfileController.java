package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import cu.edu.cujae.pwebjsf.services.dto.UserForRecoverCode;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/me")
public class ProfileController {

  @Autowired
  private UserServices userServices;

  @GetMapping("/profile")
  public ResponseEntity<UserDto> getProfile(
    @RequestBody UserForRecoverCode user2
  ) {
    try {
      if (user2.getEmail() == null) {
        return ResponseEntity.notFound().build();
      }
      UserDto user = userServices.getUserByEmail(user2.getEmail());
      return ResponseEntity.ok(user);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/update")
  public ResponseEntity<String> updateProfile(@RequestBody UserDto user) {
    try {
      userServices.save(user);
      return ResponseEntity.ok("User updated");
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
