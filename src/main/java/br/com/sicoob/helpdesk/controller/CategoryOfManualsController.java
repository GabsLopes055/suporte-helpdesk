package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.service.CategoryOfManualsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/sat/category")
@RestController
public class CategoryOfManualsController {

    @Autowired
    private CategoryOfManualsService service;

    /*
    /metodo para listar todas as categorias
     */
    @GetMapping
    public ResponseEntity<List<CategoryOfManuals>> findAllCategory() {
        List<CategoryOfManuals> listCategory = service.listAllCategory();
        return ResponseEntity.status(HttpStatus.OK).body(listCategory);
    }

    /*
    metodo  para criar uma categoria
     */
    @PostMapping
    public CategoryOfManuals createNewCategory(@RequestBody CategoryOfManuals category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewCategory(category)).getBody();
    }


}
