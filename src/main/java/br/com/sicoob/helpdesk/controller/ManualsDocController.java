package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.CategoryOfManualRequest;
import br.com.sicoob.helpdesk.dto.response.ManualDocResponse;
import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.entities.ManualsDocs;
import br.com.sicoob.helpdesk.service.ManualsDocsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    /*
    /metodo para salvar um novo manual
     */
    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<ManualDocResponse> uploadMultipleFiles(@RequestParam("file") MultipartFile file,
                                                                 @RequestParam("cdCategory") @Valid CategoryOfManuals cdCategory) throws IOException {

        if(file == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewManual(file, cdCategory));

    }

    /*
    /metodo para buscar todos os manuais
    */
    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<ManualDocResponse>> listAllManuals() {

        return ResponseEntity.status(HttpStatus.OK).body(service.listAllManuals());

    }

    /*
    metodo para excluir um manual
     */
    @DeleteMapping(value = "{id}")
    @CrossOrigin(value = "*")
    public ResponseEntity<?> deleteManual(@PathVariable(value = "id") Integer cdManual) {
        if(service.deleteManual(cdManual)) {
            return ResponseEntity.status(HttpStatus.OK).body("Manual Deletado !");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao excluir manual !");
        }
    }

    /*
     * metodo para baixar um manual
     * */
    @GetMapping("/downloadManual/{fileId}")
    @CrossOrigin(value = "*")
    public ResponseEntity<ByteArrayResource> downloadManual(@PathVariable(value = "fileId") Integer fileId) {

        ManualDocResponse manual = service.findManual(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(manual.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\""+manual.getDocName()+ "\"")
                .body(new ByteArrayResource(manual.getData()));
    }

}
