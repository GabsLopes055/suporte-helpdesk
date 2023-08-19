package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.InformationRequest;
import br.com.sicoob.helpdesk.dto.response.InformationResponse;
import br.com.sicoob.helpdesk.entities.Information;
import br.com.sicoob.helpdesk.repository.InformationRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InformationService {

    @Autowired
    private InformationRepository repository;

    /*metodo para salvar um novo informativo*/
    public InformationResponse saveInformation(@NotNull InformationRequest information) {

       var response = new Information();

        response.setCdInform(information.getCdInform());
        response.setTitle(information.getTitle());
        response.setDescription(information.getDescription());
        response.setContent(information.getContent());
        response.setDocName(information.getDocName());
        response.setDocType(information.getDocType());
        response.setData(information.getData());

        return InformationResponse.InformationResponse(repository.save(response));

    }

    /*metodo para listar todos os informativos*/
    public InformationResponse listAllInformations() {

        List<Information> listAll = repository.findAll();

        return (InformationResponse) listAll.stream().map(InformationResponse::InformationResponse).collect(Collectors.toList());
    }


}
