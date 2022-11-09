package cu.edu.cujae.pwebjsf.data.crud;

import cu.edu.cujae.pwebjsf.data.entity.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractCrudRepository extends CrudRepository<Contract, Integer> {

    List<Contract> findAll();

    Contract getByCode(Integer code);

    List<Contract> getContractByCodeCar(Integer codeCar);

    List<Contract> getContractByCodeTourist(Integer codeTourist);

}
