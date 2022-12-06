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

  public BrandDto getBrandById(int brandId) {
    Car_Brand brand = brandCrudRepository.findById(brandId);
    return mapper.toCarBrandDto(brand);
  }

  public void createBrand(BrandDto brandDto) {
    Car_Brand brand = mapper.toCarBrand(brandDto);
    brandCrudRepository.save(brand);
  }

  public void updateBrand(BrandDto brandDto) {
    Car_Brand brand = mapper.toCarBrand(brandDto);
    brandCrudRepository.save(brand);
  }

  public void deleteBrand(int brandId) {
    brandCrudRepository.deleteById(brandId);
  }
}
