package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.ContractCrudRepository;
import cu.edu.cujae.pwebjsf.data.mapper.ContractMapper;
import cu.edu.cujae.pwebjsf.data.utils.DateController;
import cu.edu.cujae.pwebjsf.services.dto.ContractDto;
import cu.edu.cujae.pwebjsf.services.dto.ContractStringDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractRepository {

    @Autowired
    private ContractCrudRepository contractCrudRepository;

    @Autowired
    private ContractMapper contractMapper;

    public List<ContractDto> getAll(){
        return contractMapper.toListContractDto(contractCrudRepository.findAll());
    }

    public ContractDto getByCode(int code){
        return contractMapper.toContractDto(contractCrudRepository.getByCode(code));
    }

    public void save(ContractStringDto contractDto) throws ParseException {
        ContractDto contractDto1 = toContractDto(contractDto);
        contractCrudRepository.save(contractMapper.toContract(contractDto1));
    }

    public void delete(int code){
        contractCrudRepository.deleteById(code);
    }

    public ContractDto toContractDto(ContractStringDto contractStringDto) throws ParseException {
        return new ContractDto(contractStringDto.getCode(),
                contractStringDto.getTourist(),contractStringDto.getCar(), DateController.getLocalDateByString(contractStringDto.getStartingDate()),
                DateController.getLocalDateByString(contractStringDto.getFinalDate()),contractStringDto.getExtension(),contractStringDto.getPayment(),
                contractStringDto.getBill(),contractStringDto.getDriver());
    }

}
