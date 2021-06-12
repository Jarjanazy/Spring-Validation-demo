package jalil.demo.demo.validation;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShipmentWithValidationControllerTestIT {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Method: POST, return an ok message")
  public void postShipment() throws Exception {
    // given
    List<ShipmentComponentDTO> components = new ArrayList<>();
    ShipmentComponentDTO component = ShipmentComponentDTO.builder().productCode("wood code 1").build();
    components.add(component);

    ShipmentDTO givenShipment = ShipmentDTO.builder().productCode("wood").count(3).shipmentComponents(components)
        .build();

    // when
    this.mockMvc
        .perform(post("/validation/shipment/add").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(givenShipment)))
        // then
        .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
        .andExpect(content().string(containsString(":)")));
  }

  @Test
  @DisplayName("Method: POST, end with error - missing productCode")
  public void postShipment_missingProductCode() throws Exception {
    // given
    List<ShipmentComponentDTO> components = new ArrayList<>();
    ShipmentComponentDTO component = ShipmentComponentDTO.builder().productCode("wood code 1").build();
    components.add(component);

    ShipmentDTO givenShipment = ShipmentDTO.builder().count(3).shipmentComponents(components).build();

    // when
    this.mockMvc
        .perform(post("/validation/shipment/add").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(givenShipment)))
        // then
        .andExpect(status().isBadRequest()).andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
        .andExpect(content().string(containsString("Product code can't be null")));
  }

}
