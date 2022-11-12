package cu.edu.cujae.pwebjsf.controllers;

import java.util.List;

import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;
import cu.edu.cujae.pwebjsf.services.dto.CarStatusDto;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import cu.edu.cujae.pwebjsf.services.dto.TouristDto;
import cu.edu.cujae.pwebjsf.services.repository.ModelRepository;
import cu.edu.cujae.pwebjsf.services.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.cujae.pwebjsf.services.CarServices;
import cu.edu.cujae.pwebjsf.services.dto.CarDto;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	 @Autowired
	 private CarServices carSevices;

	 @Autowired
	 private ModelRepository modelRepository;
	 
	 @Autowired
	 private StatusRepository statusRepository;
	 
	 @GetMapping("/all")
	 public ResponseEntity<List<CarDto>> getAll() {
	    return new ResponseEntity<>(carSevices.getAll(), HttpStatus.OK);
	 }
	 @GetMapping("/models/all")
	 public ResponseEntity<List<CarModelDto>> getAllModels(){return ResponseEntity.ok(modelRepository.getAll());}
	 
	 
	 @GetMapping("/status/all")
	 public ResponseEntity<List<CarStatusDto>> getAllStatus(){return ResponseEntity.ok(statusRepository.getAll());}
	 
	    @GetMapping("/{code}")
	    public ResponseEntity<CarDto> getById(@PathVariable("code") int code){
	        return new ResponseEntity<>(carSevices.getById(code),HttpStatus.OK);
	    }

	    @PostMapping("/")
	    public ResponseEntity<String> insert(@RequestBody CarDto carDto){
	    	carSevices.save(carDto);
	        return ResponseEntity.ok("Car inserted");
	    }

	    @PutMapping("/")
	    public ResponseEntity<String> update(@RequestBody CarDto carDto){
	    	carSevices.save(carDto);
	        return ResponseEntity.ok("Car updated");
	    }

	    @DeleteMapping("/{code}")
	    public ResponseEntity<String> delete(@PathVariable("code") Integer code){
	    	carSevices.delete(code);
	        return ResponseEntity.ok("Car deleted");
	    }
	    

}


