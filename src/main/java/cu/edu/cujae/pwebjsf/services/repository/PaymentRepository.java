package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.PaymentCrudRepository;
import cu.edu.cujae.pwebjsf.data.mapper.PaymentMapper;
import cu.edu.cujae.pwebjsf.services.dto.PaymentsDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository {

  @Autowired
  private PaymentCrudRepository paymentCrudRepository;

  @Autowired
  private PaymentMapper paymentMapper;

  public List<PaymentsDto> getPayments() {
    return paymentMapper.toPaymentsDtoList(paymentCrudRepository.findAll());
  }

  public PaymentsDto getByCode(int id) {
    return paymentMapper.toPaymentsDto(paymentCrudRepository.findById(id));
  }

  public void delete(int id) {
    paymentCrudRepository.deleteById(id);
  }

  public void save(PaymentsDto payment) {
    paymentCrudRepository.save(paymentMapper.toPayment(payment));
  }

}
