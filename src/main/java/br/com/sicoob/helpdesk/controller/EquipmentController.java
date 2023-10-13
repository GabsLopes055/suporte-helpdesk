package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.EquipmentsRequest;
import br.com.sicoob.helpdesk.dto.response.EquipmentResponse;
import br.com.sicoob.helpdesk.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sat/equipmentOfSecondFloor")
public class EquipmentController {

    @Autowired
    private EquipmentService service;

    /*
    * Metodo para salvar um equipamento do segundo andar
    * */
    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<EquipmentResponse> createEquipment(@RequestBody EquipmentsRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEquipment(request));
    }

    /*
    * Metodo para listar todos os equipamentos
    * */
    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<EquipmentResponse>> listAllEquipments() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllEquipments());
    }


}
