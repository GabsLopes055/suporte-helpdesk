package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.InformationRequest;
import br.com.sicoob.helpdesk.dto.response.InformationResponse;
import br.com.sicoob.helpdesk.entities.Information;
import br.com.sicoob.helpdesk.repository.InformationRepository;
import br.com.sicoob.helpdesk.service.exceptions.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InformationService {

    @Autowired
    private InformationRepository repository;

    /*metodo para salvar um novo informativo*/
    public InformationResponse saveInformation(
           MultipartFile file,
           String title,
           String description,
           String content    ) throws IOException {

       var response = new Information();

        response.setTitle(title);
        response.setDescription(description);
        response.setContent(content);

        if(file != null) {
            response.setDocName(file.getOriginalFilename());
            response.setDocType(file.getContentType());
            response.setData(file.getBytes());
        }

        return InformationResponse.InformationResponse(repository.save(response));

    }

    /*metodo para listar todos os informativos*/
    public List<InformationResponse> listAllInformations() {

        List<Information> listAll = repository.findAll();

        return listAll.stream().map(e -> InformationResponse.InformationResponse(e)).collect(Collectors.toList());
    }

    /*metodo para buscar um informativo pelo ID*/
    public InformationResponse findInformation(Long id) {

        Optional<Information> findInformation = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Informativo não encontrado")));

        Information response = new Information();

        response.setCdInform(findInformation.get().getCdInform());
        response.setTitle(findInformation.get().getTitle());
        response.setDescription(findInformation.get().getDescription());
        response.setContent(findInformation.get().getContent());
        response.setDocName(findInformation.get().getDocName());
        response.setDocType(findInformation.get().getDocType());
        response.setData(findInformation.get().getData());

        return InformationResponse.InformationResponse(response);
    }


}
