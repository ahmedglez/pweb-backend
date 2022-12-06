package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.CarBrandServices;
import cu.edu.cujae.pwebjsf.services.CarModelServices;
import cu.edu.cujae.pwebjsf.services.CarServices;
import cu.edu.cujae.pwebjsf.services.CarStatusService;
import cu.edu.cujae.pwebjsf.services.dto.BrandDto;
import cu.edu.cujae.pwebjsf.services.dto.CarDto;
import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;
import cu.edu.cujae.pwebjsf.services.dto.CarStatusDto;
import cu.edu.cujae.pwebjsf.services.repository.BrandRepository;
import cu.edu.cujae.pwebjsf.services.repository.ModelRepository;
import cu.edu.cujae.pwebjsf.services.repository.StatusRepository;
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
  private CarServices carSevices;
  
  @Autowired
  private CarModelServices modelServices;
  
  @Autowired
  private CarBrandServices brandServices;
  
  @Autowired
  private CarStatusService statusServices;

  @Autowired
  private ModelRepository modelRepository;

  @Autowired
  private StatusRepository statusRepository;
  
  @Autowired
  private BrandRepository brandRepository;

  @GetMapping("/all")
  public ResponseEntity<List<CarDto>> getAll() {
    return new ResponseEntity<>(carSevices.getAll(), HttpStatus.OK);
  }

  //Get all models
  @GetMapping("/models/all")
  public ResponseEntity<List<CarModelDto>> getAllModels() {
    return ResponseEntity.ok(modelRepository.getAll());
  }

  //Get all status
  @GetMapping("/status/all")
  public ResponseEntity<List<CarStatusDto>> getAllStatus() {
    return ResponseEntity.ok(statusRepository.getAll());
  }
  

  //Get All Brands
  @GetMapping("/models/brands/all")
  public ResponseEntity<List<BrandDto>> getAllBrands() {
    return ResponseEntity.ok(brandRepository.getAll());
  }

  @GetMapping("/{code}")
  public ResponseEntity<CarDto> getById(@PathVariable("code") int code) {
    return new ResponseEntity<>(carSevices.getById(code), HttpStatus.OK);
  }

  //Get Cars by Model
  @GetMapping("/getByModel/{code}")
  public ResponseEntity<List<CarDto>> getByModel(
    @PathVariable("code") int code
  ) {
    return new ResponseEntity<>(carSevices.getByModel(code), HttpStatus.OK);
  }

  //Get Cars by Status
  @GetMapping("/getByStatus/{code}")
  public ResponseEntity<List<CarDto>> getByStatus(
    @PathVariable("code") int code
  ) {
    return new ResponseEntity<>(carSevices.getByStatus(code), HttpStatus.OK);
  }

  
  @PostMapping("/")
  public ResponseEntity<String> insert(@RequestBody CarDto carDto) {
    carSevices.save(carDto);
    return ResponseEntity.ok("Car inserted");
  }

  @PutMapping("/")
  public ResponseEntity<String> update(@RequestBody CarDto carDto) {
    carSevices.save(carDto);
    return ResponseEntity.ok("Car updated");
  }

  @DeleteMapping("/{code}")
  public ResponseEntity<String> delete(@PathVariable("code") Integer code) {
    carSevices.delete(code);
    return ResponseEntity.ok("Car deleted");
  }
  
  //Model Endpoints
  @GetMapping("/model/{code}")
  public ResponseEntity<CarModelDto> getModelById(@PathVariable("code") int code) {
    return new ResponseEntity<>(modelServices.getModelById(code), HttpStatus.OK);
  }
  @PostMapping("/model/")
  public ResponseEntity<String> insertModel(@RequestBody CarModelDto modelDto) {
    modelServices.createModel(modelDto);
    return ResponseEntity.ok("Model inserted");
  }
  @PutMapping("/model/")
  public ResponseEntity<String> updateModel(@RequestBody CarModelDto modelDto) {
	  modelServices.updateModel(modelDto);
    return ResponseEntity.ok("Model updated");
  }

  @DeleteMapping("/model/{code}")
  public ResponseEntity<String> deleteModel(@PathVariable("code") Integer code) {
	 modelServices.deleteModel(code);
    return ResponseEntity.ok("Model deleted");
  }
  
//Brand Endpoints
  @GetMapping("/brand/{code}")
  public ResponseEntity<BrandDto> getBrandById(@PathVariable("code") int code) {
    return new ResponseEntity<>(brandServices.getCarBrandById(code), HttpStatus.OK);
  }
  @PostMapping("/brand/")
  public ResponseEntity<String> insertBrand(@RequestBody BrandDto brandDto) {
    brandServices.createCarBrand(brandDto);
    return ResponseEntity.ok("Brand inserted");
  }
  @PutMapping("/brand/")
  public ResponseEntity<String> updateBrand(@RequestBody BrandDto brandDto) {
	  brandServices.updateCarBrand(brandDto);
    return ResponseEntity.ok("Brand updated");
  }

  @DeleteMapping("/brand/{code}")
  public ResponseEntity<String> deleteBrand(@PathVariable("code") Integer code) {
	  brandServices.deleteCarBrand(code);
    return ResponseEntity.ok("Brand deleted");
  }
  
//Status Endpoints
  @GetMapping("/status/{code}")
  public ResponseEntity<CarStatusDto> getStatusById(@PathVariable("code") int code) {
    return new ResponseEntity<>(statusServices.getById(code), HttpStatus.OK);
  }
  @PostMapping("/status/")
  public ResponseEntity<String> insertStatus(@RequestBody CarStatusDto brandDto) {
	  statusServices.createStatus(brandDto);
    return ResponseEntity.ok("Status inserted");
  }
  @PutMapping("/status/")
  public ResponseEntity<String> updateStatus(@RequestBody CarStatusDto brandDto) {
	  statusServices.updateStatus(brandDto);
    return ResponseEntity.ok("Status updated");
  }

  @DeleteMapping("/status/{code}")
  public ResponseEntity<String> deletestatus(@PathVariable("code") Integer code) {
	  statusServices.deleteStatus(code);
    return ResponseEntity.ok("Status deleted");
  }
  
}
