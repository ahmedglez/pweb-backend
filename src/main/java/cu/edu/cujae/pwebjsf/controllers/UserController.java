package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.UserServices;
import cu.edu.cujae.pwebjsf.services.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAall(){
        return new ResponseEntity<>(userServices.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<UserDto> getById(@PathVariable("code") int code){
        return new ResponseEntity<>(userServices.getById(code),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto user){
        userServices.save(user);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<UserDto> delete(@PathVariable("code") int code){
        userServices.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/isUser")
    public ResponseEntity<UserDto> isUser(@RequestBody UserDto userDto){
        return new ResponseEntity<UserDto>(userServices.isUser(userDto),HttpStatus.OK);
    }
}