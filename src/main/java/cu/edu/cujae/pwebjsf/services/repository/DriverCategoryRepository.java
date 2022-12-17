package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.DriverCategoryCrudRepository;
import cu.edu.cujae.pwebjsf.data.mapper.DriverCategoryMapper;
import cu.edu.cujae.pwebjsf.services.dto.DriversCategoriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriverCategoryRepository {

    @Autowired
    DriverCategoryMapper driverCategoryMapper;

    @Autowired
    DriverCategoryCrudRepository driverCategoryCrudRepository;

    public List<DriversCategoriesDto> getAll(){return driverCategoryMapper.toDriverCategoryDtoList(driverCategoryCrudRepository.findAll());}

    public DriversCategoriesDto getByCode(int code){return driverCategoryMapper.toDriverCategoryDto(driverCategoryCrudRepository.getByCode(code));}

    public void save(DriversCategoriesDto category){driverCategoryCrudRepository.save(driverCategoryMapper.toDriverCategory(category));}

    public void delete(int code){driverCategoryCrudRepository.deleteById(code);}
}
