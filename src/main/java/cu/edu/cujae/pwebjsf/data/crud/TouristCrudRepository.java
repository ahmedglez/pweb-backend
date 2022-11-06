package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Driver;
import cu.edu.cujae.pwebjsf.data.entity.Tourist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TouristCrudRepository extends CrudRepository<Tourist, Integer> {

    List<Tourist> findAll();

    List<Tourist> findByPassport(String passport);

    Tourist findById(int code);

}
