package cu.edu.cujae.pwebjsf.controllers;

import cu.edu.cujae.pwebjsf.data.entity.Driver;
import cu.edu.cujae.pwebjsf.services.DriverServices;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
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

  @GetMapping(value = "/{id}") // Get Driver by ID
  public ResponseEntity<DriverDto> getDriver(@PathVariable("id") int id) {
    DriverDto driver = driverSevices.getDriver(id);
    return new ResponseEntity<>(driver, HttpStatus.OK);
  }

  @GetMapping(value = "ci/{ci}") // Get Driver by CI
  public ResponseEntity<DriverDto> getDriverByCI(
    @PathVariable("ci") String ci
  ) {
    DriverDto driver = driverSevices.getDriverByCI(ci);
    return new ResponseEntity<>(driver, HttpStatus.OK);
  }
}
