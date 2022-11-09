package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Car_Model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelCrudRepository extends CrudRepository<Car_Model, Integer> {

    List<Car_Model> findAll();
}
