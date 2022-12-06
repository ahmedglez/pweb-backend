package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.CarBrandCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Car_Brand;
import cu.edu.cujae.pwebjsf.data.mapper.CarBrandMapper;
import cu.edu.cujae.pwebjsf.services.dto.BrandDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BrandRepository {

  @Autowired
  private CarBrandCrudRepository brandCrudRepository;

  @Autowired
  private CarBrandMapper mapper;

  public List<BrandDto> getAll() {
    List<Car_Brand> brands = (List<Car_Brand>) brandCrudRepository.findAll();
    return mapper.toCarBrandDtoList(brands);
  }

  public BrandDto getByCode(int brandId) {
    Car_Brand brand = brandCrudRepository.findById(brandId);
    return mapper.toCarBrandDto(brand);
  }

  public void save(BrandDto brandDto) {
    Car_Brand brand = mapper.toCarBrand(brandDto);
    brandCrudRepository.save(brand);
  }

  public void delete(int brandId) {
    brandCrudRepository.deleteById(brandId);
  }
}
