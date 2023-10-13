package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.EquipmentOfSecondFloorRequest;
import br.com.sicoob.helpdesk.dto.response.EquipmentOfSecondFloorResponse;
import br.com.sicoob.helpdesk.entities.EquipmentOfSecondFloorEntity;
import br.com.sicoob.helpdesk.repository.EquipmentOfSecondFloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentOfSecondFloorService {

    @Autowired
    private EquipmentOfSecondFloorRepository repository;

    /*Metodo para salvar uma reserva*/
    public EquipmentOfSecondFloorResponse reserveEquipment(EquipmentOfSecondFloorRequest request) {

        EquipmentOfSecondFloorEntity response = new EquipmentOfSecondFloorEntity();

        response.setCdEquipment(request.getCdEquipament());
        response.setNameUser(request.getNameUser());
        response.setNameEquipment(request.getNameEquipment());
        response.setDateOfRemove(request.getDateOfRemove());
        response.setDateOfAdd(request.getDateOfRemove());
        response.setStatus(request.getStatus());

        repository.save(response);

        return EquipmentOfSecondFloorResponse.responseEquipment(response);

    }

}
