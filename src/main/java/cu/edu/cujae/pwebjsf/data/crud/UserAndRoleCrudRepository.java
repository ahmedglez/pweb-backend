package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.UserAndRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAndRoleCrudRepository extends CrudRepository<UserAndRole, Integer> {

    List<UserAndRole> findAll();

    UserAndRole getByCodeUser(Integer code);

    List<UserAndRole> getByCodeRole(Integer code);

    void deleteByUser_Code(Integer code);


}
