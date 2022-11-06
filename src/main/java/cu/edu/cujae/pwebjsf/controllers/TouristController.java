package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.TouristServices;
import cu.edu.cujae.pwebjsf.services.dto.TouristDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist")
public class TouristController {

    @Autowired
    TouristServices touristServices;

    @GetMapping("/all")
    public ResponseEntity<List<TouristDto>> getAll(){return new ResponseEntity<>(touristServices.getAll(), HttpStatus.OK);}

    @GetMapping("/{code}")
    public ResponseEntity<TouristDto> getById(@PathVariable("code") int code){
        return new ResponseEntity<>(touristServices.getById(code),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<TouristDto> save(@RequestBody TouristDto touristDto){
        touristServices.save(touristDto);
        return new ResponseEntity<>(touristDto,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<TouristDto> delete(@PathVariable("code") Integer code){
        touristServices.delete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
