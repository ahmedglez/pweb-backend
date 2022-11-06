package cu.edu.cujae.pwebjsf.data.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cu.edu.cujae.pwebjsf.data.entity.Car;

public interface CarCrudRepository extends CrudRepository<Car, Integer>{
	List<Car> findAll();

	

	Car findById(int carId);
}
