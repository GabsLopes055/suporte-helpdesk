package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.CategoryOfManualRequest;
import br.com.sicoob.helpdesk.dto.response.CategoryOfManualResponse;
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
    @CrossOrigin(value = "*")
    public ResponseEntity<List<CategoryOfManualResponse>> findAllCategory() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllCategory());
    }

    /*
    metodo  para criar uma categoria
     */
    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<CategoryOfManualResponse> createNewCategory(@RequestBody CategoryOfManualRequest category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewCategory(category));
    }

    /*
    * metodo para excluir uma categoria*/
    @DeleteMapping(value = "/{cdCategory}")
    @CrossOrigin(value = "*")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "cdCategory") Long cdCategory) {
        if(service.deleteCategory(cdCategory)) {
            return ResponseEntity.status(HttpStatus.OK).body("Categoria Deletada");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possivel excluir categoria !");
        }
    }

    /*metodo para editar uma categoria*/
    @PutMapping(value = "/{cdCategory}")
    @CrossOrigin(value = "*")
    public ResponseEntity<CategoryOfManualResponse> editCategory(@RequestBody CategoryOfManualRequest category, @PathVariable(value = "cdCategory") Long cdCategory) {

        if(category == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.editCategory(category, cdCategory));
    }

}
