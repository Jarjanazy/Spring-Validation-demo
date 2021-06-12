package jalil.demo.demo.validation;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentWithValidationController {
  @PostMapping(value = "/validation/shipment/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity<String> addShipment(@RequestBody @Validated ShipmentDTO shipmentDTO) {
    return ResponseEntity.ok(":)");
  }
}
