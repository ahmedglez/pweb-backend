package cu.edu.cujae.pwebjsf.data.mapper;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import cu.edu.cujae.pwebjsf.data.entity.Car_Model;
import cu.edu.cujae.pwebjsf.services.dto.CarModelDto;

@Mapper(componentModel = "spring")
public interface CarModelMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "code", target = "code"),
      @org.mapstruct.Mapping(source = "model", target = "model"),
      @org.mapstruct.Mapping(source = "brand",target = "brand"),
            @org.mapstruct.Mapping(source = "brand.code", target = "codeBrand"),
      @org.mapstruct.Mapping(target = "cars", ignore = true)
    }
  )
  Car_Model toCarModel(CarModelDto carModelDto);

  List<Car_Model> toCarModelList(List<CarModelDto> carModelDtos);

  @InheritInverseConfiguration
  CarModelDto toCarModelDto(Car_Model carModel);

  List<CarModelDto> toCarModelDtoList(List<Car_Model> carModels);
}
