package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.ReserveOfSecondFloorRequest;
import br.com.sicoob.helpdesk.dto.response.ReserveOfSecondFloorResponse;
import br.com.sicoob.helpdesk.service.ReserveOfSecondFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sat/reserveOfSecondFloor")
public class ReserveOfSecondFloorController {

    @Autowired
    private ReserveOfSecondFloorService service;

    /*
    * Metodo para reservar um equipamento benq
    * */
    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<ReserveOfSecondFloorResponse> reserveEquipment(@RequestBody ReserveOfSecondFloorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.reserveEquipment(request));
    }

    /*
    * Metodo para listar todas as reservas
    * */
    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<ReserveOfSecondFloorResponse>> listAllReserves() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllReserves());
    }

    /*
    * Metodo para devolver um equipamento
    * */
    @PutMapping(value = "/{cdReserve}")
    @CrossOrigin(value = "*")
    public ResponseEntity<ReserveOfSecondFloorResponse> returnEquipment(@PathVariable(value = "cdReserve") Long cdReserve) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.returnEquipment(cdReserve));
    }

}
