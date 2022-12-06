package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.CarBrandServices;
import cu.edu.cujae.pwebjsf.services.CarModelServices;
import cu.edu.cujae.pwebjsf.services.CarServices;
import cu.edu.cujae.pwebjsf.services.CarStatusService;
import cu.edu.cujae.pwebjsf.services.dto.BrandDto;
import cu.edu.cujae.pwebjsf.services.dto.CarDto;
import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;
import cu.edu.cujae.pwebjsf.services.dto.CarStatusDto;

import java.util.List;
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

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

  @Autowired
  private CarServices carServices;
  
  @Autowired
  private CarModelServices modelServices;
  
  @Autowired
  private CarBrandServices brandServices;
  
  @Autowired
  private CarStatusService statusServices;

  @GetMapping("/all")
  public ResponseEntity<List<CarDto>> getAll() {
    return new ResponseEntity<>(carServices.getAll(), HttpStatus.OK);
  }

  //Get all models
  @GetMapping("/models/all")
  public ResponseEntity<List<CarModelDto>> getAllModels() {
    return ResponseEntity.ok(modelServices.getAll());
  }

  //Get all status
  @GetMapping("/status/all")
  public ResponseEntity<List<CarStatusDto>> getAllStatus() {
    return ResponseEntity.ok(statusServices.getAll());
  }
  

  //Get All Brands
  @GetMapping("/brands/all")
  public ResponseEntity<List<BrandDto>> getAllBrands() {
    return ResponseEntity.ok(brandServices.getAll());
  }

  @GetMapping("/{code}")
  public ResponseEntity<CarDto> getById(@PathVariable("code") int code) {
    return new ResponseEntity<>(carServices.getById(code), HttpStatus.OK);
  }

  //Get Cars by Model
  @GetMapping("/getByModel/{code}")
  public ResponseEntity<List<CarDto>> getByModel(
    @PathVariable("code") int code
  ) {
    return new ResponseEntity<>(carServices.getByModel(code), HttpStatus.OK);
  }

  //Get Cars by Status
  @GetMapping("/getByStatus/{code}")
  public ResponseEntity<List<CarDto>> getByStatus(
    @PathVariable("code") int code
  ) {
    return new ResponseEntity<>(carServices.getByStatus(code), HttpStatus.OK);
  }

  
  @PostMapping("/")
  public ResponseEntity<String> insert(@RequestBody CarDto carDto) {
    carServices.save(carDto);
    return ResponseEntity.ok("Car inserted");
  }

  @PutMapping("/")
  public ResponseEntity<String> update(@RequestBody CarDto carDto) {
    carServices.save(carDto);
    return ResponseEntity.ok("Car updated");
  }

  @DeleteMapping("/{code}")
  public ResponseEntity<String> delete(@PathVariable("code") Integer code) {
    carServices.delete(code);
    return ResponseEntity.ok("Car deleted");
  }
  
  //Model Endpoints
  @GetMapping("/models/{code}")
  public ResponseEntity<CarModelDto> getModelById(@PathVariable("code") int code) {
    return new ResponseEntity<>(modelServices.getByCode(code), HttpStatus.OK);
  }
  @PostMapping("/models/")
  public ResponseEntity<String> insertModel(@RequestBody CarModelDto modelDto) {
    modelServices.save(modelDto);
    return ResponseEntity.ok("Model inserted");
  }
  @PutMapping("/models/")
  public ResponseEntity<String> updateModel(@RequestBody CarModelDto modelDto) {
	  modelServices.save(modelDto);
    return ResponseEntity.ok("Model updated");
  }

  @DeleteMapping("/models/{code}")
  public ResponseEntity<String> deleteModel(@PathVariable("code") Integer code) {
	 modelServices.delete(code);
    return ResponseEntity.ok("Model deleted");
  }
  
//Brand Endpoints
  @GetMapping("/brands/{code}")
  public ResponseEntity<BrandDto> getBrandById(@PathVariable("code") int code) {
    return new ResponseEntity<>(brandServices.getByCode(code), HttpStatus.OK);
  }
  @PostMapping("/brands/")
  public ResponseEntity<String> insertBrand(@RequestBody BrandDto brandDto) {
    brandServices.save(brandDto);
    return ResponseEntity.ok("Brand inserted");
  }
  @PutMapping("/brands/")
  public ResponseEntity<String> updateBrand(@RequestBody BrandDto brandDto) {
	  brandServices.save(brandDto);
    return ResponseEntity.ok("Brand updated");
  }

  @DeleteMapping("/brands/{code}")
  public ResponseEntity<String> deleteBrand(@PathVariable("code") Integer code) {
	  brandServices.delete(code);
    return ResponseEntity.ok("Brand deleted");
  }
  
//Status Endpoints
  @GetMapping("/status/{code}")
  public ResponseEntity<CarStatusDto> getStatusById(@PathVariable("code") int code) {
    return new ResponseEntity<>(statusServices.getById(code), HttpStatus.OK);
  }
  @PostMapping("/status/")
  public ResponseEntity<String> insertStatus(@RequestBody CarStatusDto brandDto) {
	  statusServices.save(brandDto);
    return ResponseEntity.ok("Status inserted");
  }
  @PutMapping("/status/")
  public ResponseEntity<String> updateStatus(@RequestBody CarStatusDto brandDto) {
	  statusServices.save(brandDto);
    return ResponseEntity.ok("Status updated");
  }

  @DeleteMapping("/status/{code}")
  public ResponseEntity<String> deletestatus(@PathVariable("code") Integer code) {
	  statusServices.delete(code);
    return ResponseEntity.ok("Status deleted");
  }
  
}
