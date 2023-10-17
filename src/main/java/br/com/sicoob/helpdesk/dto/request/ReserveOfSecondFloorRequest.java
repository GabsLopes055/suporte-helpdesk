package br.com.sicoob.helpdesk.dto.request;

import br.com.sicoob.helpdesk.entities.Enums.StatusOfBanq;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReserveOfSecondFloorRequest {

    @Positive
    @NotBlank(message = "O campo não pode ser vazio")
    private Long cdReserve;

    @NotBlank(message = "O campo não pode ser vazio")
    private String nameUser;

    @NotBlank(message = "O campo não pode ser vazio")
    private String nameEquipment;


}
