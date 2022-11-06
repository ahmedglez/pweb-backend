package cu.edu.cujae.pwebjsf.services.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cu.edu.cujae.pwebjsf.data.crud.CarCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Car;
import cu.edu.cujae.pwebjsf.data.mapper.CarMapper;
import cu.edu.cujae.pwebjsf.services.dto.CarDto;

@Repository
public class CarRepository {

	@Autowired
	private CarCrudRepository carCrudRepository;

	@Autowired
	private CarMapper mapper;
	
	public List<CarDto> getAll() {
		  List<Car> cars = (List<Car>) carCrudRepository.findAll();
		  return mapper.toCarDtoList(cars);
	}


}
