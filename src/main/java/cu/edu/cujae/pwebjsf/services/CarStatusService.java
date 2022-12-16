package cu.edu.cujae.pwebjsf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.cujae.pwebjsf.services.dto.CarStatusDto;
import cu.edu.cujae.pwebjsf.services.repository.StatusRepository;

@Service
public class CarStatusService {
	
	@Autowired
	private StatusRepository carStatusRepository;
	
	public List<CarStatusDto> getAll() {
	    return carStatusRepository.getAll();
	  }

	  public CarStatusDto getById(int statusId) {
	    return carStatusRepository.getByCode(statusId);
	  }

	  public void save(CarStatusDto status) {
		  carStatusRepository.save(status);
	  }

	  public void delete(int statusId) {
		  carStatusRepository.delete(statusId);
	  }

}
