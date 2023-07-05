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
    @PostMapping
    public ResponseEntity<SoftwareResponse> createNewSoftware(@RequestBody @Valid SoftwareRequest request) {

        if(request == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewSoftware(request));

    }

    //metodo para listar todos os softwares
    @GetMapping
    public ResponseEntity<List<SoftwareResponse>> listAllSoftwares(){

        return ResponseEntity.status(HttpStatus.OK).body(service.listAllSoftwares());

    }


}
