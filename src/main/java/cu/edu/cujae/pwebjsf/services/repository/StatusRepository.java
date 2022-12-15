package cu.edu.cujae.pwebjsf.services.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cu.edu.cujae.pwebjsf.data.crud.StatusCrudRepository;
import cu.edu.cujae.pwebjsf.data.mapper.CarStatusMapper;
import cu.edu.cujae.pwebjsf.services.dto.CarStatusDto;

@Repository
public class StatusRepository {

	 @Autowired
	    private StatusCrudRepository statusCrudRepository;

	    @Autowired
	    private CarStatusMapper carStatusMapper;

	    public List<CarStatusDto> getAll(){
	        List<CarStatusDto> status = carStatusMapper.toCarStatusDtoList(statusCrudRepository.findAll());
	        return status;
	    }

	    public CarStatusDto getByCode(int code){
	    	return carStatusMapper.toCarStatusDto(statusCrudRepository.getByCode(code));
		}

		public void delete(int code){ statusCrudRepository.deleteById(code);}

		public void save(CarStatusDto carStatusDto){statusCrudRepository.save(carStatusMapper.toCarStatus(carStatusDto));}


	
}
