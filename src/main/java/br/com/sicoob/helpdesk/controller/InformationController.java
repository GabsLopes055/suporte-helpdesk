package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.InformationRequest;
import br.com.sicoob.helpdesk.dto.response.InformationResponse;
import br.com.sicoob.helpdesk.service.InformationService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<InformationResponse> saveInformation(InformationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveInformation(request));
    }

    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<InformationResponse>> listAllInformation() {
        return ResponseEntity.status(HttpStatus.OK).body((List<InformationResponse>) service.listAllInformations());
    }

}
