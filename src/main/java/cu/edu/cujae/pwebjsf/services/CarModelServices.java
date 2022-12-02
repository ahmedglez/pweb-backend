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

  public CarModelDto getModelById(int modelId) {
    return carModelRepository.getModelById(modelId);
  }

  public void createModel(CarModelDto modelDto) {
    carModelRepository.createModel(modelDto);
  }

  public void updateModel(CarModelDto modelDto) {
    carModelRepository.updateModel(modelDto);
  }

  public void deleteModel(int modelId) {
    carModelRepository.deleteModel(modelId);
  }
}
