package cu.edu.cujae.pwebjsf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cu.edu.cujae.pwebjsf.services.dto.CarDto;
import cu.edu.cujae.pwebjsf.services.dto.TouristDto;
import cu.edu.cujae.pwebjsf.services.repository.CarRepository;

@Service
public class CarServices {
	
	@Autowired
	private CarRepository carRepository;

	public List<CarDto> getAll() {
		return carRepository.getAll();
	  }
	 public CarDto getById(int code){ return carRepository.getById(code).get();}

	 public void delete(int code){carRepository.delete(code);}

	 public void save(CarDto carDto){carRepository.save(carDto);}
	

}
