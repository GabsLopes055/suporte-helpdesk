package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.InformationRequest;
import br.com.sicoob.helpdesk.dto.response.InformationResponse;
import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.service.InformationService;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/api/sat/information")
@RestController
public class InformationController {

    @Autowired
    private InformationService service;

    /*metodo para salvar um novo informativo*/
    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<InformationResponse> saveInformation(@RequestParam(value = "file", required = false) MultipartFile file,
                                                               @RequestParam("title") @Valid String title,
                                                               @RequestParam("description") @Valid String description,
                                                               @RequestParam("content") @Valid String content) throws IOException {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveInformation(file, title, description, content));
    }

    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<InformationResponse>> listAllInformation() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllInformations());
    }

    @GetMapping(value = "{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<InformationResponse> findInformation(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findInformation(id));
    }

    @DeleteMapping(value = "{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<Boolean> deleteInformation(@PathVariable(value = "id") Long id) {

        if(!service.deleteInformation(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
    }

}
