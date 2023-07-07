package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.SoftwareRequest;
import br.com.sicoob.helpdesk.dto.response.SoftwareResponse;
import br.com.sicoob.helpdesk.service.SoftwaresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sat/softwares")
public class SoftwaresController {

    @Autowired
    private SoftwaresService service;


    //metodo para salvar um novo softwares
    @CrossOrigin(value = "*")
    @PostMapping
    public ResponseEntity<SoftwareResponse> createNewSoftware(@RequestBody @Valid SoftwareRequest request) {

        if(request == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewSoftware(request));

    }

    //metodo para listar todos os softwares
    @CrossOrigin(value = "*")
    @GetMapping
    public ResponseEntity<List<SoftwareResponse>> listAllSoftwares(){

        return ResponseEntity.status(HttpStatus.OK).body(service.listAllSoftwares());

    }

    //metodo para editar um software
    @CrossOrigin(value = "*")
    @PutMapping(value = "{id}")
    public ResponseEntity<SoftwareResponse> editSoftware(@Valid @RequestBody SoftwareRequest software, @PathVariable(value = "id") Long id) {
        if (software == null || id == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(service.editSoftware(software, id));

    }

    //metodo para excluir um software
    @CrossOrigin(value = "*")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteSoftware(@PathVariable Long id) {
        service.deleteSoftware(id);
        return ResponseEntity.ok("Software deletado !");
    }


}
