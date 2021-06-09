package jalil.demo.demo.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor @Getter
public class ShipmentComponentDTO {
    @NotBlank(message = "Component product code can't be null")
    private final String productCode;

    public ShipmentComponentDTO() {
        this.productCode = "";
    }
}
