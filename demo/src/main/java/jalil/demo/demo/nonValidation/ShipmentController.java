package jalil.demo.demo.nonvalidation;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {
  @PostMapping(value = "/shipment/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> addShipment(@RequestBody ShipmentDTO shipmentDTO) {
    if (shipmentDTO.getProductCode() == null)
      return ResponseEntity.badRequest().body("Product code can't be null");

    if (shipmentDTO.getCount() <= 0)
      return ResponseEntity.badRequest().body("Count can't be negative or zero");

    if (!allComponentsAreValid(shipmentDTO))
      return ResponseEntity.badRequest().body("Component product code can't be null");

    return ResponseEntity.ok(":)");
  }

  private boolean allComponentsAreValid(ShipmentDTO shipmentDTO) {
    List<ShipmentComponentDTO> shipmentComponentDTOs = shipmentDTO.getShipmentComponents();

    return shipmentComponentDTOs != null && shipmentComponentDTOs.size() > 0 && shipmentComponentDTOs.stream()
        .allMatch(shipmentComponentDTO -> shipmentComponentDTO.getProductCode() != null);
  }
}
