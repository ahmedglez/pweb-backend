package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.BrandDto;
import cu.edu.cujae.pwebjsf.services.repository.BrandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarBrandServices {

  @Autowired
  private BrandRepository carBrandRepository;

  public List<BrandDto> getAll() {
    return carBrandRepository.getAll();
  }

  public BrandDto getCarBrandById(int carBrandId) {
    return carBrandRepository.getBrandById(carBrandId);
  }

  public void createCarBrand(BrandDto BrandDto) {
    carBrandRepository.createBrand(BrandDto);
  }

  public void updateCarBrand(BrandDto BrandDto) {
    carBrandRepository.updateBrand(BrandDto);
  }

  public void deleteCarBrand(int carBrandId) {
    carBrandRepository.deleteBrand(carBrandId);
  }
}
