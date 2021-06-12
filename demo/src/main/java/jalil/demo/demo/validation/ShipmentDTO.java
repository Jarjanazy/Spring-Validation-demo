package jalil.demo.demo.validation;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class ShipmentDTO {
  @NotBlank(message = "Product code can't be null")
  String productCode;
  @Min(1)
  int count;

  @Size(min = 1, message = "Component product code can't be empty")
  @NotNull(message = "Component product code can't be null")
  @Valid
  List<ShipmentComponentDTO> shipmentComponents;
}
