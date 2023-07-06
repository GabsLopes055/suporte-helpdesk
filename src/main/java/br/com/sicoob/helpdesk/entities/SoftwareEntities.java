package br.com.sicoob.helpdesk.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_software")
public class SoftwareEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdsoftware;

    @Column(name = "title")
    private String title;

    @Column(name = "link", length = 1024)
    private String link;

}
