package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.data.DriverRepository;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
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
}
