package br.com.sicoob.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EquipmentsRequest {

    @Positive
    private Long cdEquipment;

    @NotBlank(message = "O campo não pode ser vazio")
    private String nameEquipment;

//    @NotBlank
    private Boolean status;

}
