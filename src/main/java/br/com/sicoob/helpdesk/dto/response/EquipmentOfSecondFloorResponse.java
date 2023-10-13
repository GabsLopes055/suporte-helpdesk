package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.Enums.StatusOfBanq;
import br.com.sicoob.helpdesk.entities.EquipmentOfSecondFloorEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class EquipmentOfSecondFloorResponse {

    private Long cdEquipament;

    private String nameUser;

    private String nameEquipment;

    private LocalDateTime dateOfRemove;

    private LocalDateTime dateOfAdd;

    private StatusOfBanq status;




    public static EquipmentOfSecondFloorResponse responseEquipment(EquipmentOfSecondFloorEntity equipment) {

        var response = new EquipmentOfSecondFloorResponse();

        response.setCdEquipament(equipment.getCdEquipment());
        response.setNameUser(equipment.getNameUser());
        response.setNameEquipment(equipment.getNameEquipment());
        response.setDateOfRemove(equipment.getDateOfRemove());
        response.setDateOfAdd(equipment.getDateOfAdd());
        response.setStatus(equipment.getStatus());

        return response;

    }


}
