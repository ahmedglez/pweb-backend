package cu.edu.cujae.pwebjsf.data.mapper;

import cu.edu.cujae.pwebjsf.data.entity.Payment;
import cu.edu.cujae.pwebjsf.services.dto.PaymentsDto;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
  @Mappings(
    {
      @org.mapstruct.Mapping(source = "code", target = "code"),
      @org.mapstruct.Mapping(source = "payment", target = "payment"),
      @org.mapstruct.Mapping(target = "contracts", ignore = true),
    }
  )
  Payment toPayment(PaymentsDto paymentsDto);

  List<Payment> toPaymentList(List<PaymentsDto> paymentsDtos);

  @InheritConfiguration
  PaymentsDto toPaymentsDto(Payment payment);

  List<PaymentsDto> toPaymentsDtoList(List<Payment> payments);
}
