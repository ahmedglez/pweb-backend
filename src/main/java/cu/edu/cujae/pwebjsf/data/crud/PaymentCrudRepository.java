package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Payment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PaymentCrudRepository
  extends CrudRepository<Payment, Integer> {
  List<Payment> findAll();

  Payment findById(int id);

  void deleteById(int id);

}
