package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.CarCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Car;
import cu.edu.cujae.pwebjsf.data.mapper.CarMapper;
import cu.edu.cujae.pwebjsf.services.dto.CarDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

  @Autowired
  private CarCrudRepository carCrudRepository;

  @Autowired
  private CarMapper mapper;

  public List<CarDto> getAll() {
    List<Car> cars = (List<Car>) carCrudRepository.findAll();
    return mapper.toCarDtoList(cars);
  }

  public Optional<CarDto> getByCode(int code) {
    Car car = carCrudRepository.findById(code);
    return Optional.ofNullable(mapper.toCarDto(car));
  }

  public void delete(Integer code) {
    carCrudRepository.deleteById(code);
  }

  public void save(CarDto carDto) {
    Car car = mapper.toCar(carDto);
    carCrudRepository.save(car);
  }

  public List<CarDto> getByModel(int code) {
    List<Car> cars = carCrudRepository.findByModelCode(code);
    return mapper.toCarDtoList(cars);
  }

  public List<CarDto> getByStatus(int code) {
    List<Car> cars = carCrudRepository.findByStatusCode(code);
    return mapper.toCarDtoList(cars);
  }

}
