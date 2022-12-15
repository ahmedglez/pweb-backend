package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {
  List<User> findAll();

  User save(User user);

  User findByCode(Integer code);

  User findByUsername(String username);

  User findByEmail(String email);

  void delete(User user);

  void deleteByCode(Integer code);

  void deleteByUsername(String username);

  void deleteByEmail(String email);

  boolean existsByCode(Integer code);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

  User findByUsernameAndPassword(String username, String password);
}
