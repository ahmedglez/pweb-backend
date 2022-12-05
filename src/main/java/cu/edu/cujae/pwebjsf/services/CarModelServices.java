package cu.edu.cujae.pwebjsf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;
import cu.edu.cujae.pwebjsf.services.repository.ModelRepository;

@Service
public class CarModelServices {

  @Autowired
  private ModelRepository carModelRepository;

  public List<CarModelDto> getAll() {
    return carModelRepository.getAll();
  }

  public CarModelDto getByCode(int modelId) {
    return carModelRepository.getByCode(modelId);
  }

  public void save(CarModelDto modelDto) {
    carModelRepository.save(modelDto);
  }

  public void delete(int modelId) {
    carModelRepository.delete(modelId);
  }
}
