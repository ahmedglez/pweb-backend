package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Car;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CarCrudRepository extends CrudRepository<Car, Integer> {
  List<Car> findAll();

  List<Car> findByModelCode(int code);

  List<Car> findByStatusCode(int code);

  Car findById(int carId);
}
