package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.ModelCrudRepository;
import cu.edu.cujae.pwebjsf.data.mapper.CarModelMapper;
import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ModelRepository {

    @Autowired
    private ModelCrudRepository modelCrudRepository;

    @Autowired
    private CarModelMapper carModelMapper;

    public List<CarModelDto> getAll(){
        List<CarModelDto> models = carModelMapper.toCarModelDtoList(modelCrudRepository.findAll());
        return models;
    }
}
