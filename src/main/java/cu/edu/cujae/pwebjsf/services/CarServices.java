package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.CarDto;
import cu.edu.cujae.pwebjsf.services.repository.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServices {

  @Autowired
  private CarRepository carRepository;

  public List<CarDto> getAll() {
    return carRepository.getAll();
  }

  public CarDto getById(int code) {
    return carRepository.getByCode(code).get();
  }

  public void delete(int code) {
    carRepository.delete(code);
  }

  public void save(CarDto carDto) {
    carRepository.save(carDto);
  }

  public List<CarDto> getByModel(int code) {
    return carRepository.getByModel(code);
  }

  public List<CarDto> getByStatus(int code) {
    return carRepository.getByStatus(code);
  }
}
