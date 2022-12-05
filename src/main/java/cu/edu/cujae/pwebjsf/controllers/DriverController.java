package cu.edu.cujae.pwebjsf.controllers;

import java.util.List;

import cu.edu.cujae.pwebjsf.services.DriverCategoryServices;
import cu.edu.cujae.pwebjsf.services.dto.DriversCategoriesDto;
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

import cu.edu.cujae.pwebjsf.services.DriverServices;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;

@RestController
@RequestMapping("/drivers")
public class DriverController {

  @Autowired
  private DriverServices driverServices;

  @Autowired
  private DriverCategoryServices driverCategoryServices;

  @GetMapping("/all") //Get All Drivers
  public ResponseEntity<List<DriverDto>> getAll() {
    return new ResponseEntity<>(driverServices.getAll(), HttpStatus.OK);
  }

  @GetMapping("/categories/all") //Get All Drivers
  public ResponseEntity<List<DriversCategoriesDto>> getAllCategories() {
    return new ResponseEntity<>(driverCategoryServices.getAll(), HttpStatus.OK);
  }

  @GetMapping("/getByCategory/{codeCategory}") // Get Drivers by Category
  public ResponseEntity<List<DriverDto>> getByCategory(
    @PathVariable("codeCategory") int codeCategory
  ) {
    System.out.println("codeCategory: " + codeCategory);
    return new ResponseEntity<>(
      driverServices.getByCategory(codeCategory),
      HttpStatus.OK
    );
  }

  @GetMapping(value = "/categories/{code}") // Get Categories by code
  public ResponseEntity<DriversCategoriesDto> getCategoryByCode(@PathVariable("code") int code) {
    return new ResponseEntity<>(driverCategoryServices.getByCode(code), HttpStatus.OK);
  }

  @GetMapping(value = "/{code}") // Get Driver by ID
  public ResponseEntity<DriverDto> getDriver(@PathVariable("code") int id) {
    DriverDto driver = driverServices.getDriver(id);
    return new ResponseEntity<>(driver, HttpStatus.OK);
  }

  @GetMapping(value = "/ci/{ci}") // Get Driver by CI
  public ResponseEntity<DriverDto> getDriverByCI(
    @PathVariable("ci") String ci
  ) {
    DriverDto driver = driverServices.getDriverByCi(ci);
    return new ResponseEntity<>(driver, HttpStatus.OK);
  }

  @PostMapping("/") // Create Driver
  public ResponseEntity<DriverDto> save(@RequestBody DriverDto driverDto) {
    driverServices.save(driverDto);
    return new ResponseEntity<>(driverDto, HttpStatus.CREATED);
  }

  @PutMapping("/") // Update Driver
  public ResponseEntity<DriverDto> update(
    @RequestBody DriverDto driverDto
  ) {
    driverServices.update(driverDto);
    return new ResponseEntity<>(driverDto, HttpStatus.OK);
  }
 

  @DeleteMapping("/{code}") //Delete Driver
  public ResponseEntity<DriverDto> delete(@PathVariable("code") int id) {
    driverServices.delete(id);
    return new ResponseEntity<DriverDto>(HttpStatus.OK);
  }
  

}
