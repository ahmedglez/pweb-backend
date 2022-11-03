package cu.edu.cujae.pwebjsf.data;

import cu.edu.cujae.pwebjsf.data.crud.DriverCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Driver;
import cu.edu.cujae.pwebjsf.data.mapper.DriverMapper;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import cu.edu.cujae.pwebjsf.services.repository.DriverDtoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DriverRepository implements DriverDtoRepository {

  @Autowired
  private DriverCrudRepository driverCrudRepository;

  @Autowired
  private DriverMapper mapper;

  @Override
  public List<DriverDto> getAll() {
    List<Driver> drivers = (List<Driver>) driverCrudRepository.findAll();
    return mapper.toDriverDtoList(drivers);
  }

  @Override
  public Optional<List<DriverDto>> getByCategory(int codeCategory) {
    return Optional.empty();
  }

  @Override
  public Optional<DriverDto> getDriver(int driverId) {
    return Optional.empty();
  }

  @Override
  public DriverDto save(DriverDto driver) {
    return null;
  }

  @Override
  public void delete(int driverId) {}
}
