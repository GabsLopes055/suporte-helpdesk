package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.SoftwareRequest;
import br.com.sicoob.helpdesk.dto.response.SoftwareResponse;
import br.com.sicoob.helpdesk.entities.SoftwareEntities;
import br.com.sicoob.helpdesk.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwaresService {

    @Autowired
    private SoftwareRepository repository;

    //metodo para salvar um novo softwares
    public SoftwareResponse createNewSoftware(SoftwareRequest software) {

        SoftwareEntities softwareEntities = new SoftwareEntities(software.getCdsoftware(), software.getTitle(), software.getLink());

        return SoftwareResponse.softwareResponseDTO(repository.save(softwareEntities));

    }

    //metodo para buscar todos os softwares
    public List<SoftwareResponse> listAllSoftwares(){

        List<SoftwareEntities> softwareEntities = repository.findAll();

        List<SoftwareResponse> softwareResponses  = softwareEntities.stream().map(e -> SoftwareResponse.softwareResponseDTO(e)).toList();

        return softwareResponses;

    }


}
