package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.Contract;
import cu.edu.cujae.pwebjsf.services.dto.ContractDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    @Mappings(
            {
                    @org.mapstruct.Mapping(source = "code", target = "code"),
                    @org.mapstruct.Mapping(source = "tourist.code", target = "touristCode"),
                    @org.mapstruct.Mapping(source = "tourist", target = "tourist"),
                    @org.mapstruct.Mapping(source = "car.code", target = "carCode"),
                    @org.mapstruct.Mapping(source = "car", target = "car"),
                    @org.mapstruct.Mapping(source = "driver.code", target = "driverCode"),
                    @org.mapstruct.Mapping(source = "driver", target = "driver"),
                    @org.mapstruct.Mapping(source = "bill.code", target = "billCode"),
                    @org.mapstruct.Mapping(source = "bill", target = "bill"),
                    @org.mapstruct.Mapping(source = "payment.code", target = "paymentCode"),
                    @org.mapstruct.Mapping(source = "payment", target = "payment"),
                    @org.mapstruct.Mapping(source = "extension", target = "extension"),
                    @org.mapstruct.Mapping(source = "startingDate", target = "startingDate"),
                    @org.mapstruct.Mapping(source = "finalDate", target = "finalDate"),
                    @org.mapstruct.Mapping(source = "totalAmount", target = "totalAmount"),
        }
    )
    List<Contract> toListContract(List<ContractDto> contractsDto);
    Contract toContract(ContractDto contractDto);

    @InheritInverseConfiguration

    List<ContractDto> toListContractDto(List<Contract> contracts);

    ContractDto toContractDto(Contract contract);

}
