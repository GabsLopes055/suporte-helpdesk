package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.response.ManualDocResponse;
import br.com.sicoob.helpdesk.service.ManualsDocsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sat/manual")
public class ManualsDocController {

    @Autowired
    private ManualsDocsService service;

    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<ManualDocResponse> uploadMultipleFiles(@RequestBody @Valid MultipartFile file) throws IOException {

        if(file == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewManual(file));

    }

    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<ManualDocResponse>> listAllManuals() {

        return ResponseEntity.status(HttpStatus.OK).body(service.listAllManuals());

    }

}
