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

  public BillDto getByCode(int billId) {
    return billRepository.getByCode(billId);
  }

  public void save(BillDto billDto) {
    billRepository.save(billDto);
  }

  public void delete(int billId) {
    billRepository.delete(billId);
  }
}
