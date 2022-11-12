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

    public void createPayment(PaymentsDto payment) {
        paymentRepository.createPayment(payment);
    }

    public void updatePayment(PaymentsDto payment) {
        paymentRepository.updatePayment(payment);
    }

    public void deletePayment(int id) {
        paymentRepository.deletePayment(id);
    }

    public PaymentsDto getPaymentById(int id) {
        return paymentRepository.getPaymentById(id);
    }

    public List<PaymentsDto> getPayments() {
        return paymentRepository.getPayments();
    }

    
    
}
