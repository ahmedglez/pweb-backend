package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Role;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RoleCrudRepository extends CrudRepository<Role, Integer> {
  List<Role> findAll();

  Role save(Role role);

  Role findByCode(Integer code);

  void deleteByCode(Integer code);
}
