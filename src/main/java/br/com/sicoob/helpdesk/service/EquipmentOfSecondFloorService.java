package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.repository.EquipmentOfSecondFloor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentOfSecondFloorService {

    @Autowired
    private EquipmentOfSecondFloor repository;
}
