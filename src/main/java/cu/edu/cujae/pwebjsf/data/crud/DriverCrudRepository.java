package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Driver;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DriverCrudRepository extends CrudRepository<Driver, Integer> {
  List<Driver> findAll();

  List<Driver> findByCategoryCode(int codeCategory);

  Driver findById(int driverId);

  Driver findByCode(int code);

  Driver findByCi(String ci);

  Driver deleteByCi(int code);
}
