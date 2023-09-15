package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.response.AutomationsResponse;
import br.com.sicoob.helpdesk.service.AutomationService;
import jakarta.persistence.Lob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sat/automation")
public class AutomationController {

    @Autowired
    private AutomationService service;

    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<AutomationsResponse>  saveNewAutomation(@RequestParam(value = "file") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createdAutomation(file));
    }

    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<AutomationsResponse>> listAllAutomation() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllAutomations());
    }

    @GetMapping(value = "{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<AutomationsResponse> findOneAutomation(@PathVariable(value = "id")Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findOneAutomation(id));
    }

}
