package cu.edu.cujae.pwebjsf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.cujae.pwebjsf.services.dto.BrandDto;
import cu.edu.cujae.pwebjsf.services.dto.CarStatusDto;
import cu.edu.cujae.pwebjsf.services.repository.BrandRepository;
import cu.edu.cujae.pwebjsf.services.repository.StatusRepository;

@Service
public class CarStatusService {
	
	@Autowired
	private StatusRepository carStatusRepository;
	
	public List<CarStatusDto> getAll() {
	    return carStatusRepository.getAll();
	  }

	  public CarStatusDto getById(int statusId) {
	    return carStatusRepository.getStatusById(statusId);
	  }

	  public void createStatus(CarStatusDto statusId) {
		  carStatusRepository.createStatus(statusId);
	  }

	  public void updateStatus(CarStatusDto statusId) {
		  carStatusRepository.updateStatus(statusId);
	  }

	  public void deleteStatus(int statusId) {
		  carStatusRepository.deleteStatus(statusId);
	  }

}
