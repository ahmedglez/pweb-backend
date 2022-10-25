package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import java.util.List;
import java.util.Optional;

public interface DriverDtoRepository {
  List<DriverDto> getAll();
  Optional<List<DriverDto>> getByCategory(int codeCategory);
  Optional<DriverDto> getDriver(int driverId);
  DriverDto save(DriverDto driver);
  void delete(int driverId);
}
