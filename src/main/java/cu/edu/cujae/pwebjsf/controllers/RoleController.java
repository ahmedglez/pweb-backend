package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.RoleServices;
import cu.edu.cujae.pwebjsf.services.dto.RoleDto;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleServices roleService;

    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> getAall(){
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<RoleDto> getById(@PathVariable("code") int code){
        return new ResponseEntity<>(roleService.getById(code),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> insert(@RequestBody RoleDto role){
        roleService.save(role);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<UserDto> update(@RequestBody RoleDto role){
        roleService.save(role);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<UserDto> delete(@PathVariable("code") int code){
        roleService.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
