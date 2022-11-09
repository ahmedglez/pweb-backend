package cu.edu.cujae.pwebjsf.data.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cu.edu.cujae.pwebjsf.data.entity.Car;
import cu.edu.cujae.pwebjsf.services.dto.CarDto;

@Mapper(componentModel = "spring")
public interface CarMapper {
	@Mappings(
		    {
		      		@org.mapstruct.Mapping(source = "code", target = "code"),
		      		@org.mapstruct.Mapping(source = "carID", target = "carID"),
					@org.mapstruct.Mapping(source = "status", target = "status"),
					@org.mapstruct.Mapping(source = "status.code", target = "statusCode"),
					@org.mapstruct.Mapping(source = "model", target = "model"),
		      		@org.mapstruct.Mapping(source = "model.code", target = "modelCode"),
		      		@org.mapstruct.Mapping(source = "color", target = "color"),
		      		@org.mapstruct.Mapping(source = "mileage", target = "mileage"),
					@org.mapstruct.Mapping(target = "contracts", ignore = true),
		    }
		  )	
	Car toCar(CarDto carDto);

	List<Car> toCarList(List<CarDto> carDtos);
	
	@InheritInverseConfiguration

	CarDto toCarDto(Car car);
	List<CarDto> toCarDtoList(List<Car> cars);
	
		 
}
