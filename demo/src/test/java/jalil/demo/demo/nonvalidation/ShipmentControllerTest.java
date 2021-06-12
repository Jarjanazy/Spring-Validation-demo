package jalil.demo.demo.nonvalidation;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jalil.demo.demo.nonvalidation.ShipmentController;
import jalil.demo.demo.nonvalidation.ShipmentDTO;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShipmentControllerTest {

    @Test
    public void detectProductCodeIsInvalid(){
        ShipmentController shipmentController = new ShipmentController();
        ShipmentDTO shipmentDTO = new ShipmentDTO(null, 0, null);
        ResponseEntity<String> responseEntity = shipmentController.addShipment(shipmentDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Product code can't be null", responseEntity.getBody());
    }

    @Test
    public void detectCountIsInvalid(){
        ShipmentController shipmentController = new ShipmentController();
        ShipmentDTO shipmentDTO = new ShipmentDTO("DDD", 0, null);
        ResponseEntity<String> responseEntity = shipmentController.addShipment(shipmentDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Count can't be negative or zero", responseEntity.getBody());
    }

    @Test
    public void detectComponentIsInNull(){
        ShipmentController shipmentController = new ShipmentController();
        ShipmentDTO shipmentDTO = new ShipmentDTO("FFF", 10, null);
        ResponseEntity<String> responseEntity = shipmentController.addShipment(shipmentDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Component product code can't be null", responseEntity.getBody());
    }

    @Test
    public void detectComponentIsEmpty(){
        ShipmentController shipmentController = new ShipmentController();
        ShipmentDTO shipmentDTO = new ShipmentDTO("FFF", 10, new ArrayList<>());
        ResponseEntity<String> responseEntity = shipmentController.addShipment(shipmentDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Component product code can't be null", responseEntity.getBody());
    }

}
