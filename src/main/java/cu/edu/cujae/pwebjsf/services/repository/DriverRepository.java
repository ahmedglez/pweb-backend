package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.DriverCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Driver;
import cu.edu.cujae.pwebjsf.data.mapper.DriverMapper;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DriverRepository {

  @Autowired
  private DriverCrudRepository driverCrudRepository;

  @Autowired
  private DriverMapper mapper;

  public List<DriverDto> getAll() {
    List<Driver> drivers = (List<Driver>) driverCrudRepository.findAll();
    return mapper.toDriverDtoList(drivers);
  }

  public Optional<List<DriverDto>> getByCategory(int codeCategory) {
    List<Driver> drivers = driverCrudRepository.findByCategoryCode(
      codeCategory
    );
    List<DriverDto> driverDtos = mapper.toDriverDtoList(drivers);
    return Optional.ofNullable(driverDtos);
  }

  public Optional<DriverDto> getDriver(int driverId) {
    return Optional.empty();
  }

  public DriverDto save(DriverDto driver) {
    return null;
  }

  public void delete(int driverId) {}

  public DriverDto update(DriverDto driver, int driverId) {
    return null;
  }
}
