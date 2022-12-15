package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.ModelCrudRepository;
import cu.edu.cujae.pwebjsf.data.mapper.CarModelMapper;
import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ModelRepository {

  @Autowired
  private ModelCrudRepository modelCrudRepository;

  @Autowired
  private CarModelMapper carModelMapper;

  public List<CarModelDto> getAll() {
    List<CarModelDto> models = carModelMapper.toCarModelDtoList(
      modelCrudRepository.findAll()
    );
    return models;
  }

  public CarModelDto getByCode(int modelId) {
    CarModelDto model = carModelMapper.toCarModelDto(
      modelCrudRepository.findById(modelId)
    );
    return model;
  }

  public void save(CarModelDto modelDto) {
    modelCrudRepository.save(carModelMapper.toCarModel(modelDto));
  }

  public void delete(int modelId) {
    modelCrudRepository.deleteById(modelId);
  }
}
