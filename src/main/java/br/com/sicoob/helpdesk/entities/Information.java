package br.com.sicoob.helpdesk.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.TimeZone;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_informations")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdInform")
    private Long cdInform;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Lob
    private String content;

    /*para guardar alguma imagem do informativo (jpeg, png, .pdf*/

    @Column(name = "docName", nullable = true)
    private String docName;

    @Column(name = "docType", nullable = true)
    private String docType;

    @Lob
    @Column(name = "docContent", nullable = true)
    private byte[] data;


}
