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
}
