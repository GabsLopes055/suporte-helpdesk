package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.EquipmentsRequest;
import br.com.sicoob.helpdesk.dto.response.EquipmentResponse;
import br.com.sicoob.helpdesk.entities.EquipmentEntity;
import br.com.sicoob.helpdesk.repository.EquipmentRepository;
import br.com.sicoob.helpdesk.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
        entity.setStatus(request.isStatus());

        return EquipmentResponse.responseEquipment(repository.save(entity));

    }

    /*
     *Metodo para listar todos os equipamentos
     **/
    public List<EquipmentResponse> listAllEquipments() {

        List<EquipmentEntity> response = repository.findByStatus();

        return response.stream().map(e -> EquipmentResponse.responseEquipment(e)).collect(Collectors.toList());

    }

    /*
    * Metodo para reservar um equipamento, o status mudará para FALSO
    * */
    public void reserveEquipment(String nameEquipment) {

        Optional<EquipmentEntity> equipment = Optional.ofNullable(repository.findBynameEquipment(nameEquipment));

        equipment.get().setStatus(false);

        repository.save(equipment.get());

    }
    /*
     * Metodo para devolver um equipamento, o status mudará para VERDADEIRO
     * */
    public void returnEquipment(String nameEquipment) {

        Optional<EquipmentEntity> equipment = Optional.ofNullable(repository.findBynameEquipment(nameEquipment));

        equipment.get().setStatus(true);

        repository.save(equipment.get());
    }
}
