package cu.edu.cujae.pwebjsf.services;

import cu.edu.cujae.pwebjsf.services.dto.TouristDto;
import cu.edu.cujae.pwebjsf.services.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristServices {

    @Autowired
    TouristRepository touristRepository;

    public List<TouristDto> getAll(){return touristRepository.getAll();}

    public TouristDto getById(int code){ return touristRepository.getByCode(code).get();}

    public void delete(int code){touristRepository.delete(code);}

    public void save(TouristDto touristDto){touristRepository.save(touristDto);}

}
