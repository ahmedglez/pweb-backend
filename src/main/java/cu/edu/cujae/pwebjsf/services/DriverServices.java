package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import cu.edu.cujae.pwebjsf.services.repository.DriverRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServices {

  @Autowired
  private DriverRepository driverRepository;

  public List<DriverDto> getAll() {
    return driverRepository.getAll();
  }

  public List<DriverDto> getByCategory(int codeCategory) {
    return driverRepository.getByCategory(codeCategory).get();
  }

  public DriverDto getDriver(int driverId) {
    return driverRepository.getbyID(driverId).get();
  }

  public DriverDto getDriverByCi(String ci) {
    return driverRepository.getbyCi(ci).get();
  }

  public DriverDto save(DriverDto driver) {
    return driverRepository.save(driver);
  }

  public void delete(int driverId) {
    driverRepository.delete(driverId);
  }

  public DriverDto update(DriverDto driver, int driverId) {
    return driverRepository.update(driver, driverId);
  }
}
