package br.com.sicoob.helpdesk.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_manuals_docs")
public class ManualsDocs {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String docName;

    
    private String docType;

    @Lob
    private byte[] data;

//    @NotBlank(message = "A Categoria não pode estar vazia")
    @ManyToOne
    @JoinColumn(name = "cdCategory", nullable = false)
    private CategoryOfManuals category;



}
