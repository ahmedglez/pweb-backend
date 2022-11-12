package cu.edu.cujae.pwebjsf.data.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cu.edu.cujae.pwebjsf.data.entity.Car_Model;
import cu.edu.cujae.pwebjsf.data.entity.Car_Status;
import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;
import cu.edu.cujae.pwebjsf.services.dto.CarStatusDto;

@Mapper(componentModel = "spring")
public interface CarStatusMapper {
	  @Mappings(
	    {
	      @org.mapstruct.Mapping(source = "code", target = "code"),
	      @org.mapstruct.Mapping(source = "status", target = "status"),
	      @org.mapstruct.Mapping(target = "cars", ignore = true),
	    }
	  )
	  Car_Status toCarStatus(CarStatusDto carStatusDto);

	  List<Car_Status> toCarStatusList(
	    List<CarStatusDto> carStatusDto
	  );

	  @InheritInverseConfiguration
	  CarStatusDto toCarStatusDto(Car_Status carStatus);
	  
	  List<CarStatusDto> toCarStatusDtoList(List<Car_Status> carStatus);

}
