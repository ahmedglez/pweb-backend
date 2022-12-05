package cu.edu.cujae.pwebjsf.services.repository;

import cu.edu.cujae.pwebjsf.data.crud.DriverCrudRepository;
import cu.edu.cujae.pwebjsf.data.crud.TouristCrudRepository;
import cu.edu.cujae.pwebjsf.data.entity.Tourist;
import cu.edu.cujae.pwebjsf.data.mapper.TouristMapper;
import cu.edu.cujae.pwebjsf.services.dto.TouristDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TouristRepository {

    @Autowired
    private TouristCrudRepository touristCrudRepository;

    @Autowired
    private TouristMapper mapper;

    public List<TouristDto> getAll(){
        List<Tourist> tourists = touristCrudRepository.findAll();
        return mapper.toTouristDtoList(tourists);
    }

    public Optional<TouristDto> getByCode(int code){
        Tourist tourist = touristCrudRepository.findById(code);
        return Optional.ofNullable(mapper.toTouristDto(tourist));
    }

    public void delete(Integer code){
        touristCrudRepository.deleteById(code);
    }

    public void save(TouristDto touristDto){
        Tourist tourist = mapper.toTourist(touristDto);
        touristCrudRepository.save(tourist);
    }


}
