package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.EquipmentEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EquipmentResponse {

    private Long cdEquipment;

    private String nameEquipment;

    private boolean status;

    public static EquipmentResponse responseEquipment(EquipmentEntity entity) {

        var response = new EquipmentResponse();

        response.setCdEquipment(entity.getCdEquipment());
        response.setNameEquipment(entity.getNameEquipment());
        response.setStatus(entity.isStatus());

        return response;

    }

}
