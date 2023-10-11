package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.service.EquipmentOfSecondFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/sat/equipments")
public class EquipmentOfSecondFloorController {

    @Autowired
    private EquipmentOfSecondFloorService service;

}
