package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.DriversCategoriesDto;
import cu.edu.cujae.pwebjsf.services.repository.DriverCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverCategoryServices {

    @Autowired
    DriverCategoryRepository driverCategoryRepository;

    public List<DriversCategoriesDto> getAll(){return driverCategoryRepository.getAll();}

    public DriversCategoriesDto getByCode(int code){return driverCategoryRepository.getByCode(code);}

    public void save(DriversCategoriesDto category){driverCategoryRepository.save(category);}

    public void delete(int code){driverCategoryRepository.delete(code);}
}
