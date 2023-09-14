package br.com.sicoob.helpdesk.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_automations")
public class Automations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdAutomation;

    private String docName;


    private String docType;

    @Lob
    private byte[] data;

}
