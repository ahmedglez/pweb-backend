package cu.edu.cujae.pwebjsf.data.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cu.edu.cujae.pwebjsf.data.entity.Car;
import cu.edu.cujae.pwebjsf.data.entity.Driver;
import cu.edu.cujae.pwebjsf.services.dto.CarDto;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;

@Mapper(componentModel = "spring")
public interface CarMapper {
	@Mappings(
		    {
		      @org.mapstruct.Mapping(source = "code", target = "codeCar"),
		      @org.mapstruct.Mapping(source = "carID", target = "plate"),
		      @org.mapstruct.Mapping(source = "status.codeStatus", target = "statusCode"),
		      @org.mapstruct.Mapping(source = "status", target = "status"),
		      @org.mapstruct.Mapping(source = "brand.cod_brand", target = "brandCode"),
		      @org.mapstruct.Mapping(source = "brand", target = "brand"),
		      @org.mapstruct.Mapping(source = "color", target = "color"),
		      @org.mapstruct.Mapping(source = "mileage", target = "mileage"),
		    }
		  )
	
	Car toCar(CarDto carDto);

	List<Car> toCarList(List<CarDto> carDtos);
	
	@InheritInverseConfiguration
	@Mapping(target = "brand", ignore = false)
	@Mapping(target = "status", ignore = false)
	CarDto toCarDto(Car car);

	List<CarDto> toCarDtoList(List<Car> cars);
	
		 
}
