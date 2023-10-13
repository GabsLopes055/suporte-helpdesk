package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.EquipmentOfSecondFloorRequest;
import br.com.sicoob.helpdesk.dto.response.EquipmentOfSecondFloorResponse;
import br.com.sicoob.helpdesk.service.EquipmentOfSecondFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/sat/reserveOfSecondFloor")
public class EquipmentOfSecondFloorController {

    @Autowired
    private EquipmentOfSecondFloorService service;

    /*
    * Metodo para reservar um equipamento benq
    * */
    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<EquipmentOfSecondFloorResponse> reserveEquipment(@RequestBody EquipmentOfSecondFloorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.reserveEquipment(request));
    }

}
