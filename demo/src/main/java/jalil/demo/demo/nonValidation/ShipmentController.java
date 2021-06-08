package jalil.demo.demo.nonValidation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {
    @PostMapping("/shipment/add")
    public ResponseEntity<String> addShipment(@RequestBody ShipmentDTO shipmentDTO){
        if (shipmentDTO.getProductCode() == null)
            return ResponseEntity.badRequest().body("Product code can't be null");

        if (shipmentDTO.getCount() <= 0)
            return ResponseEntity.badRequest().body("Count can't be negative or zero");

        if (!allComponentsAreValid(shipmentDTO))
            return ResponseEntity.badRequest().body("Component product code can't be null");

        return ResponseEntity.ok(":)");
    }

    private boolean allComponentsAreValid(ShipmentDTO shipmentDTO) {
        return shipmentDTO.
                getShipmentComponentDTOs().
                stream().
                allMatch(shipmentComponentDTO -> shipmentComponentDTO.getProductCode() != null);
    }
}
