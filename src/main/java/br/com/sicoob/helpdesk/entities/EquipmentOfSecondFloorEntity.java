package br.com.sicoob.helpdesk.entities;

import br.com.sicoob.helpdesk.entities.Enums.StatusOfBanq;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_EquipmentOfSecondFloor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentOfSecondFloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdEquipment;

    @NotBlank
    private String nameUser;

    @NotBlank
    private String nameEquipment;

    @NotBlank
    private LocalDateTime dateOfRemove;

    @Nullable
    private LocalDateTime dateOfAdd;

    @NotBlank
    private StatusOfBanq status;

}
