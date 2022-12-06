package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Car_Brand;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CarBrandCrudRepository
  extends CrudRepository<Car_Brand, Integer> {
  List<Car_Brand> findAll();

  Car_Brand findById(int brandId);

  void deleteById(int brandId);

  Car_Brand save(Car_Brand brand);
}
