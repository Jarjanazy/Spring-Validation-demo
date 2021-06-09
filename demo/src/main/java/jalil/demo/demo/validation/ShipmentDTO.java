package jalil.demo.demo.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RequiredArgsConstructor @Getter
public class ShipmentDTO {
    @NotBlank(message = "Product code can't be null")
    private final String productCode;
    @Min(1)
    private final int count;

    @Size(min = 1, message = "Component product code can't be empty")
    @NotNull(message = "Component product code can't be null")
    @Valid
    private final List<ShipmentComponentDTO> shipmentComponentDTOs;
}
