package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.Driver;
import cu.edu.cujae.pwebjsf.data.entity.Driver_Category;
import cu.edu.cujae.pwebjsf.services.dto.DriverDto;
import cu.edu.cujae.pwebjsf.services.dto.DriversCategoriesDto;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DriverCategoryMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "code", target = "code"),
      @org.mapstruct.Mapping(source = "category", target = "category"),
    }
  )
  Driver_Category toDriverCategory(DriversCategoriesDto driverCategoryDto);

  List<Driver_Category> toDriverCategoryList(
    List<DriversCategoriesDto> driverCategoryDtos
  );

  @InheritInverseConfiguration
  DriversCategoriesDto toDriverCategoryDto(Driver_Category driverCategory);
}
