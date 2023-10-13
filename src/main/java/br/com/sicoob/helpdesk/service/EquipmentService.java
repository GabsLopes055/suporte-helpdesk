package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.EquipmentsRequest;
import br.com.sicoob.helpdesk.dto.response.EquipmentResponse;
import br.com.sicoob.helpdesk.entities.EquipmentEntity;
import br.com.sicoob.helpdesk.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    /*
    *Metodo para listar todos os equipamentos
    **/
    public List<EquipmentResponse> listAllEquipments() {

        List<EquipmentEntity> response = repository.findAll();

        return response.stream().map(e -> EquipmentResponse.responseEquipment(e)).collect(Collectors.toList());

    }

}
