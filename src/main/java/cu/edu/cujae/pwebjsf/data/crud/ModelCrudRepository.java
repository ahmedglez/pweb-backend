package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Car_Model;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ModelCrudRepository
  extends CrudRepository<Car_Model, Integer> {
  List<Car_Model> findAll();

  Car_Model findById(int id);

  Car_Model save(Car_Model model);

  void deleteById(int id);
}
