package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.ReserveOfSecondFloorRequest;
import br.com.sicoob.helpdesk.dto.response.ReserveOfSecondFloorResponse;
import br.com.sicoob.helpdesk.entities.Enums.StatusOfBanq;
import br.com.sicoob.helpdesk.entities.ReserveOfSecondFloorEntity;
import br.com.sicoob.helpdesk.repository.ReserveOfSecondFloorRepository;
import br.com.sicoob.helpdesk.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReserveOfSecondFloorService {

    @Autowired
    private ReserveOfSecondFloorRepository repository;

    @Autowired
    private EquipmentService serviceEquipment;

    /*Metodo para salvar uma reserva*/
    public ReserveOfSecondFloorResponse reserveEquipment(ReserveOfSecondFloorRequest request) {

        ReserveOfSecondFloorEntity response = new ReserveOfSecondFloorEntity();

        response.setCdReserve(request.getCdReserve());
        response.setNameUser(request.getNameUser());
        response.setNameEquipment(request.getNameEquipment());
        response.setStatus(StatusOfBanq.ACTIVE);

        repository.save(response);
//        serviceEquipment.reserveEquipment(response.getCdReserve());

        return ReserveOfSecondFloorResponse.responseEquipment(response);

    }

    /*
    * Metodo para devolver o equipamento.
    * */
//    public boolean returnEquipment(Long cdReserve) {
//
//        Optional<ReserveOfSecondFloorEntity> reserve = Optional.ofNullable(repository.findById(cdReserve).orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada")));
//
//        reserve.get().setStatus(StatusOfBanq.DISABLED);
//        serviceEquipment.returnEquipment(reserve.get().getNameEquipment());
//
//        repository.save(reserve.get());
//
//        return true;
//
//    }

   /*
   * Metodo para listar todas as reservas
   * */
    public List<ReserveOfSecondFloorResponse> listAllReserves() {

        List<ReserveOfSecondFloorEntity> listResponse = repository.findAll();

        return listResponse.stream().map(e -> ReserveOfSecondFloorResponse.responseEquipment(e)).collect(Collectors.toList());

    }
}
