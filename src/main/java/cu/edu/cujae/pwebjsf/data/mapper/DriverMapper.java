package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.Driver;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DriverMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "code", target = "code"),
      @org.mapstruct.Mapping(source = "ci", target = "ci"),
      @org.mapstruct.Mapping(source = "name", target = "name"),
      @org.mapstruct.Mapping(source = "lastName", target = "lastName"),
      @org.mapstruct.Mapping(source = "address", target = "address"),
      @org.mapstruct.Mapping(source = "category.code", target = "categoryCode"),
      @org.mapstruct.Mapping(source = "category", target = "category"),
            @org.mapstruct.Mapping(target = "contracts", ignore = true)
    }
  )

  Driver toDriver(DriverDto driverDto);

  List<Driver> toDriverList(List<DriverDto> driversDto);

  @InheritInverseConfiguration

  DriverDto toDriverDto(Driver driver);
  List<DriverDto> toDriverDtoList(List<Driver> drivers);
}
