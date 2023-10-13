package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.EquipmentsRequest;
import br.com.sicoob.helpdesk.dto.response.EquipmentResponse;
import br.com.sicoob.helpdesk.entities.EquipmentEntity;
import br.com.sicoob.helpdesk.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    /*
    * Metodo para salvar um equipamento
    * */
    public EquipmentResponse createEquipment(EquipmentsRequest request) {

        EquipmentEntity entity = new EquipmentEntity();

        entity.setNameEquipment(request.getNameEquipment());
        entity.setStatus(request.getStatus());

        return EquipmentResponse.responseEquipment(repository.save(entity));

    }

}
