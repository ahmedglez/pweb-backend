package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User,Integer> {

    List<User> findAll();

    User save(User user);
}
