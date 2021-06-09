package jalil.demo.demo.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController_Validation {
    @PostMapping("validation/shipment/add")
    public ResponseEntity<String> addShipment(@RequestBody @Validated ShipmentDTO shipmentDTO){
        return ResponseEntity.ok(":)");
    }
}
