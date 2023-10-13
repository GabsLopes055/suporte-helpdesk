package br.com.sicoob.helpdesk.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tbl_equipments")
@NoArgsConstructor
public class EquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdEquipment;

    @NotBlank
    private String nameEquipment;

//    @NotBlank
    private Boolean status;

}
