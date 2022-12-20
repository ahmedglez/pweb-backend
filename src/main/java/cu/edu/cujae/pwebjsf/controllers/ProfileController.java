package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

  @Autowired
  private UserServices userServices;

  @GetMapping("/me")
  public ResponseEntity<UserDto> getProfile(HttpServletRequest request) {
    /* get username from bearer token */
    String username = request.getUserPrincipal().getName();

    try {
      if (username == null) {
        return ResponseEntity.notFound().build();
      }
      UserDto userDto = userServices.getUserByUsername(username);
      return ResponseEntity.ok(userDto);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("/")
  public ResponseEntity<String> updateProfile(
    @RequestBody UserDto user,
    HttpServletRequest request
  ) {
    try {
      String username = request.getUserPrincipal().getName();
      int code = userServices.getUserByUsername(username).getCode();
      if (username == null) {
        return new ResponseEntity<>(
          "You must be logged in to update your profile",
          HttpStatus.FORBIDDEN
        );
      }
      if (code != user.getCode()) {
        return new ResponseEntity<>(
          "You can't update other user's profile",
          HttpStatus.FORBIDDEN
        );
      }
      userServices.save(user);
      return new ResponseEntity<>(
        "Profile updated successfully",
        HttpStatus.OK
      );
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
