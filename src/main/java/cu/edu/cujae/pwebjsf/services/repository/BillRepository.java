package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.BillCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Bill;
import cu.edu.cujae.pwebjsf.data.mapper.BillMapper;
import cu.edu.cujae.pwebjsf.services.dto.BillDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BillRepository {

  @Autowired
  private BillCrudRepository billCrudRepository;

  @Autowired
  private BillMapper mapper;

  public List<BillDto> getAll() {
    List<Bill> bills = (List<Bill>) billCrudRepository.findAll();
    return mapper.toBillDtoList(bills);
  }

  public BillDto getByCode(int billId) {
    Bill bill = billCrudRepository.findById(billId);
    return mapper.toBillDto(bill);
  }

  public void save(BillDto billDto) {
    Bill bill = mapper.toBill(billDto);
    billCrudRepository.save(bill);
  }

  public void delete(int billId) {
    billCrudRepository.deleteById(billId);
  }
}
