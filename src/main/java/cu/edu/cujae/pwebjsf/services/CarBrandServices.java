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

  public BrandDto getByCode(int carBrandId) {
    return carBrandRepository.getByCode(carBrandId);
  }

  public void save(BrandDto BrandDto) {
    carBrandRepository.save(BrandDto);
  }


  public void delete(int carBrandId) {
    carBrandRepository.delete(carBrandId);
  }
}
