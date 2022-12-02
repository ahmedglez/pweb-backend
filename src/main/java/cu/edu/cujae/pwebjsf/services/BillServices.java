package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.BillDto;
import cu.edu.cujae.pwebjsf.services.repository.BillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServices {

  @Autowired
  private BillRepository billRepository;

  public List<BillDto> getAll() {
    return billRepository.getAll();
  }

  public BillDto getBillById(int billId) {
    return billRepository.getBillById(billId);
  }

  public void createBill(BillDto billDto) {
    billRepository.createBill(billDto);
  }

  public void updateBill(BillDto billDto) {
    billRepository.updateBill(billDto);
  }

  public void deleteBill(int billId) {
    billRepository.deleteBill(billId);
  }
}
