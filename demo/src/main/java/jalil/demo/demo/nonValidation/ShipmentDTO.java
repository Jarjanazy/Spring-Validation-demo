package jalil.demo.demo.nonValidation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor @Getter
public class ShipmentDTO {
    private final String productCode;
    private final int count;
    private final List<ShipmentComponentDTO> shipmentComponentDTOs;
}
