package br.com.sicoob.helpdesk.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_categoryOfManuals")
public class CategoryOfManuals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdCategory;

    private String category;

    @JsonIgnore
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ManualsDocs> manuais = new ArrayList<>();

}
