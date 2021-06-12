package jalil.demo.demo.nonvalidation;

import java.util.List;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class ShipmentDTO {
  String productCode;
  int count;
  List<ShipmentComponentDTO> shipmentComponents;
}
