package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.Bill;
import cu.edu.cujae.pwebjsf.services.dto.BillDto;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BillMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "code", target = "code"),
      @org.mapstruct.Mapping(source = "amount", target = "amount"),
      @org.mapstruct.Mapping(source = "specialAmount", target = "specialAmount"),
      @org.mapstruct.Mapping(target = "contracts", ignore = true),
    }
  )
  Bill toBill(BillDto billDto);

  List<Bill> toBillList(List<BillDto> billDtos);

  @InheritConfiguration
  BillDto toBillDto(Bill bill);

  List<BillDto> toBillDtoList(List<Bill> bills);
}
