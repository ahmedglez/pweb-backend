package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.Driver;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DriverMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "code", target = "codeDriver"),
      @org.mapstruct.Mapping(source = "id", target = "id"),
      @org.mapstruct.Mapping(source = "name", target = "name"),
      @org.mapstruct.Mapping(source = "lastName", target = "last_name"),
      @org.mapstruct.Mapping(source = "address", target = "address"),
      @org.mapstruct.Mapping(source = "category.code", target = "categoryCode"),
      @org.mapstruct.Mapping(source = "category", target = "category"),
    }
  )
  Driver toDriver(DriverDto driverDto);

  List<Driver> toDriverList(List<DriverDto> driverDtos);

  @InheritInverseConfiguration
  @Mapping(target = "category", ignore = false)
  DriverDto toDriverDto(Driver driver);

  List<DriverDto> toDriverDtoList(List<Driver> drivers);
}
