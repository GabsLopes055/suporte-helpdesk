package br.com.sicoob.helpdesk.entities;

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

//    @JsonManagedReference
////    @JoinColumn(name = "id")
//    @OneToMany(mappedBy = "category")
//    private List<ManualsDocs> manuals = new ArrayList<>();

}
