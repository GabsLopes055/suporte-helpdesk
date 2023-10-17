package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.Enums.StatusOfBanq;
import br.com.sicoob.helpdesk.entities.ReserveOfSecondFloorEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ReserveOfSecondFloorResponse {

    private Long cdReserve;

    private String nameUser;

    private String nameEquipment;

    private LocalDateTime dateOfRemove;

    private LocalDateTime dateOfAdd;

    private boolean status;




    public static ReserveOfSecondFloorResponse responseEquipment(ReserveOfSecondFloorEntity equipment) {

        var response = new ReserveOfSecondFloorResponse();

        response.setCdReserve(equipment.getCdReserve());
        response.setNameUser(equipment.getNameUser());
        response.setNameEquipment(equipment.getNameEquipment());
        response.setDateOfRemove(equipment.getDateOfRemove());
        response.setDateOfAdd(equipment.getDateOfAdd());
        response.setStatus(equipment.isStatus());

        return response;

    }


}
