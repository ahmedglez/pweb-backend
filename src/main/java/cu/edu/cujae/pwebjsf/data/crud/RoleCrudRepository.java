package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleCrudRepository extends CrudRepository<Role, Integer> {

    List<Role> findAll();

    Role save(Role role);
}
