package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.RoleServices;
import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  @Autowired
  private UserServices userServices;

  @Autowired
  private RoleServices roleServices;

  @GetMapping("/all")
  public ResponseEntity<List<UserDto>> getAll() {
    return new ResponseEntity<>(userServices.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{code}")
  public ResponseEntity<UserDto> getById(@PathVariable("code") int code) {
    return new ResponseEntity<>(userServices.getById(code), HttpStatus.OK);
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<UserDto> getByUsername(
    @PathVariable("username") String username
  ) {
    return new ResponseEntity<>(
      userServices.getUserByUsername(username),
      HttpStatus.OK
    );
  }

  @PostMapping("/")
  public ResponseEntity<UserDto> insert(@RequestBody UserDto user) {
    userServices.save(user);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PutMapping("/")
  public ResponseEntity<UserDto> update(@RequestBody UserDto user) {
    userServices.save(user);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{code}")
  public ResponseEntity<UserDto> delete(@PathVariable("code") int code) {
    if(userServices.getById(code).containRoleAdministrator()){
      return ResponseEntity.badRequest().build();
    }
    userServices.delete(code);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/isUser")
  public ResponseEntity<UserDto> isUser(@RequestBody UserDto userDto) {
    return new ResponseEntity<UserDto>(
      userServices.isUser(userDto),
      HttpStatus.OK
    );
  }
}
