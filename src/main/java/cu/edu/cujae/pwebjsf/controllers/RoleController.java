package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.RoleServices;
import cu.edu.cujae.pwebjsf.services.dto.RoleDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

  @Autowired
  private RoleServices roleServices;

  @GetMapping("/all")
  public ResponseEntity<List<RoleDto>> getAll() {
    return new ResponseEntity<>(roleServices.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{code}")
  public ResponseEntity<RoleDto> getById(@PathVariable("code") int code) {
    return new ResponseEntity<>(roleServices.getById(code), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<RoleDto> save(@RequestBody RoleDto role) {
    roleServices.save(role);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{code}")
  public ResponseEntity<RoleDto> delete(@PathVariable("code") int code) {
    roleServices.delete(code);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
