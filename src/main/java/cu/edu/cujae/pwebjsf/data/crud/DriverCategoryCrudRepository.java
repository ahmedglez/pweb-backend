package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Driver_Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DriverCategoryCrudRepository extends CrudRepository<Driver_Category, Integer> {

    List<Driver_Category> findAll();

    Driver_Category getByCode(int code);

}
