package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Bill;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BillCrudRepository extends CrudRepository<Bill, Integer> {
  List<Bill> findAll();

  Bill findById(int billId);


}
