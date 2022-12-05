package cu.edu.cujae.pwebjsf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.cujae.pwebjsf.services.dto.PaymentsDto;
import cu.edu.cujae.pwebjsf.services.repository.PaymentRepository;

@Service
public class PaymentServices {

    @Autowired
    private PaymentRepository paymentRepository;

    public void save(PaymentsDto payment) {
        paymentRepository.save(payment);
    }

    public void delete(int id) {
        paymentRepository.delete(id);
    }

    public PaymentsDto getByCode(int id) {
        return paymentRepository.getByCode(id);
    }

    public List<PaymentsDto> getAll() {
        return paymentRepository.getPayments();
    }

    
    
}
