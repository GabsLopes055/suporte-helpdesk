package br.com.sicoob.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EquipmentsRequest {

    @Positive
    private Long cdEquipment;

    @NotBlank(message = "O campo 'nameEquipment' não pode ser vazio")
    private String nameEquipment;

    @NotBlank(message = "O campo 'status' não pode ser vazio")
    private boolean status;

}
