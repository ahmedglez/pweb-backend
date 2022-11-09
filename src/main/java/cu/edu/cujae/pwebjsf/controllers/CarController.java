package cu.edu.cujae.pwebjsf.controllers;

import java.util.List;

import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;
import cu.edu.cujae.pwebjsf.services.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	 
	 @GetMapping("/all")
	 public ResponseEntity<List<CarDto>> getAll() {
	    return new ResponseEntity<>(carSevices.getAll(), HttpStatus.OK);
	 }
	 @GetMapping("/models/all")
	 public ResponseEntity<List<CarModelDto>> getAllModels(){return ResponseEntity.ok(modelRepository.getAll());}

}


