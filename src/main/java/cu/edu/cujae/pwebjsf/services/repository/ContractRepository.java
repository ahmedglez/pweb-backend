package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.ContractCrudRepository;
import cu.edu.cujae.pwebjsf.data.mapper.ContractMapper;
import cu.edu.cujae.pwebjsf.services.dto.ContractDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public void save(ContractDto contractDto){
        contractCrudRepository.save(contractMapper.toContract(contractDto));
    }

    public void delete(int code){
        contractCrudRepository.deleteById(code);
    }

}
