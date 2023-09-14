package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.response.AutomationsResponse;
import br.com.sicoob.helpdesk.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

}