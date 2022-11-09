package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.ContractDto;
import cu.edu.cujae.pwebjsf.services.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServices {

    @Autowired
    private ContractRepository contractRepository;

    public List<ContractDto> getAll(){
        return contractRepository.getAll();
    }

    public ContractDto getByCode(int code){
        return contractRepository.getByCode(code);
    }

    public void save(ContractDto contractDto){
        contractRepository.save(contractDto);
    }

    public void delete(int code){
        contractRepository.delete(code);
    }
}
