package br.com.sicoob.helpdesk.entities;

import br.com.sicoob.helpdesk.entities.Enums.StatusOfBanq;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_EquipamentOfSecondFloor")
@Data
@NoArgsConstructor
public class EquipmentOfSecondFloor {

    private Long cdEquipament;

    private String nameUser;

    private String nameEquipament;

    private LocalDateTime dateOfRemove;

    private LocalDateTime dateOfAdd;

    private StatusOfBanq status;

}
