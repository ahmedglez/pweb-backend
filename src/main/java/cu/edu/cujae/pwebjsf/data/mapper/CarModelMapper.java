package cu.edu.cujae.pwebjsf.data.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import cu.edu.cujae.pwebjsf.data.entity.Car_Model;
import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;

@Mapper(componentModel = "spring")
public interface CarModelMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "model_code", target = "codeModel"),
      @org.mapstruct.Mapping(source = "model", target = "model"),
      @org.mapstruct.Mapping(target = "brand", ignore = true),
    }
  )
  Car_Model toCarModel(CarModelDto carModelDto);

  List<Car_Model> toCarModelList(List<CarModelDto> carModelDtos);

  @InheritInverseConfiguration
  CarModelDto toCarModelDto(Car_Model carModel);

  List<CarModelDto> toCarModelDtoList(List<Car_Model> carModels);
}
