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
@Table(name = "tbl_reserve_of_second_floor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveOfSecondFloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdReserve;

    private String nameUser;

    private String nameEquipment;

    private LocalDateTime dateOfRemove;

    private LocalDateTime dateOfAdd;

    private boolean status;

    @PrePersist
    public void prePersist() {
        this.setDateOfRemove(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.setDateOfAdd(LocalDateTime.now());
    }

}
