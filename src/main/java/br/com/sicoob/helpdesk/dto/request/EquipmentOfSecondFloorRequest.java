package br.com.sicoob.helpdesk.dto.request;

import br.com.sicoob.helpdesk.entities.Enums.StatusOfBanq;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EquipmentOfSecondFloorRequest {

    @Positive
    @NotBlank(message = "O campo não pode ser vazio")
    private Long cdEquipament;

    @NotBlank(message = "O campo não pode ser vazio")
    private String nameUser;

    @NotBlank(message = "O campo não pode ser vazio")
    private String nameEquipment;

    @NotBlank(message = "O campo não pode ser vazio")
    private LocalDateTime dateOfRemove;

    @Nullable
    private LocalDateTime dateOfAdd;

    @NotBlank(message = "O campo não pode ser vazio")
    private StatusOfBanq status;

}
