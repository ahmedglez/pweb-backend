package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.services.DriverServices;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
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
@RequestMapping("/api/v1/drivers")
public class DriverController {

  @Autowired
  private DriverServices driverSevices;

  @GetMapping("/all") //Get All Drivers
  public ResponseEntity<List<DriverDto>> getAll() {
    return new ResponseEntity<>(driverSevices.getAll(), HttpStatus.OK);
  }

  @GetMapping("/getByCategory/{codeCategory}") // Get Drivers by Category
  public ResponseEntity<List<DriverDto>> getByCategory(
    @PathVariable("codeCategory") int codeCategory
  ) {
    System.out.println("codeCategory: " + codeCategory);
    return new ResponseEntity<>(
      driverSevices.getByCategory(codeCategory),
      HttpStatus.OK
    );
  }

  @GetMapping(value = "/{code}") // Get Driver by ID
  public ResponseEntity<DriverDto> getDriver(@PathVariable("code") int id) {
    DriverDto driver = driverSevices.getDriver(id);
    return new ResponseEntity<>(driver, HttpStatus.OK);
  }

  @GetMapping(value = "/ci/{ci}") // Get Driver by CI
  public ResponseEntity<DriverDto> getDriverByCI(
    @PathVariable("ci") String ci
  ) {
    DriverDto driver = driverSevices.getDriverByCi(ci);
    return new ResponseEntity<>(driver, HttpStatus.OK);
  }

  @PostMapping("/") // Create Driver
  public ResponseEntity<DriverDto> save(@RequestBody DriverDto driverDto) {
    driverSevices.save(driverDto);
    return new ResponseEntity<>(driverDto, HttpStatus.CREATED);
  }

  @PutMapping("/") // Update Driver
  public ResponseEntity<DriverDto> update(@RequestBody DriverDto driverDto) {
    driverSevices.update(driverDto);
    return new ResponseEntity<>(driverDto, HttpStatus.OK);
  }

  @DeleteMapping("/{code}") //Delete Driver
  public ResponseEntity<DriverDto> delete(@PathVariable("code") String ci) {
    driverSevices.delete(ci);
    return new ResponseEntity<DriverDto>(HttpStatus.OK);
  }
}
