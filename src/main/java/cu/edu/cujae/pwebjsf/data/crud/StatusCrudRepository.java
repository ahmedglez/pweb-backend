package cu.edu.cujae.pwebjsf.data.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cu.edu.cujae.pwebjsf.data.entity.Car_Status;

public interface StatusCrudRepository extends CrudRepository<Car_Status, Integer>{

	 List<Car_Status> findAll();
	
}
