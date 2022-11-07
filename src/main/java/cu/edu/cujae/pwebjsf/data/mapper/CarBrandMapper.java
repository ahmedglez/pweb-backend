package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.Car_Brand;
import cu.edu.cujae.pwebjsf.services.dto.BrandDto;
import cu.edu.cujae.pwebjsf.services.dto.DriversCategoriesDto;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CarBrandMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "cod_brand", target = "codeBrand"),
      @org.mapstruct.Mapping(source = "brand", target = "brand"),
      @org.mapstruct.Mapping(source = "model.model_code", target = "modelCode"),
      @org.mapstruct.Mapping(target = "models", ignore = true),
      @org.mapstruct.Mapping(target = "cars", ignore = true),
    }
  )
  Car_Brand toCarBrand(BrandDto brandDto);

  List<Car_Brand> toCarBrandList(List<BrandDto> carBrandDtos);

  @InheritInverseConfiguration
  BrandDto toCarBrandDto(Car_Brand carBrand);
}
