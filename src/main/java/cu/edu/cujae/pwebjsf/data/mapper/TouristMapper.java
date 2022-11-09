package cu.edu.cujae.pwebjsf.data.mapper;


import cu.edu.cujae.pwebjsf.data.entity.Tourist;

import cu.edu.cujae.pwebjsf.services.dto.TouristDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TouristMapper {
    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "code", target = "code"),
                    @org.mapstruct.Mapping(source = "idPassport", target = "idPassport"),
                    @org.mapstruct.Mapping(source = "name", target = "name"),
                    @org.mapstruct.Mapping(source = "lastName", target = "lastName"),
                    @org.mapstruct.Mapping(source = "age", target = "age"),
                    @org.mapstruct.Mapping(source = "sex", target = "sex"),
                    @org.mapstruct.Mapping(source = "telephoneNumber", target = "telephoneNumber"),
                    @org.mapstruct.Mapping(source = "country", target = "country"),
                    @org.mapstruct.Mapping(target = "contracts", ignore = true)
            }
    )
    Tourist toTourist(TouristDto touristDto);

    List<Tourist> toTouristList(List<TouristDto> touristDtos);

    @InheritInverseConfiguration
    TouristDto toTouristDto(Tourist tourist);

    List<TouristDto> toTouristDtoList(List<Tourist> tourist);
}
