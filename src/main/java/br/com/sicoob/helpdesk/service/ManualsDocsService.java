package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.CategoryOfManualRequest;
import br.com.sicoob.helpdesk.dto.response.ManualDocResponse;
import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.entities.ManualsDocs;
import br.com.sicoob.helpdesk.entities.SoftwareEntities;
import br.com.sicoob.helpdesk.repository.ManualsDocsRepository;
import br.com.sicoob.helpdesk.service.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManualsDocsService {

    @Autowired
    private ManualsDocsRepository repository;

    //metodo para salvar um novo manual em pdf
    public ManualDocResponse saveNewManual(@NotNull MultipartFile file, CategoryOfManuals cdCategory) throws IOException {

            ManualsDocs doc = new ManualsDocs();

            doc.setDocName(file.getOriginalFilename());
            doc.setDocType(file.getContentType());
            doc.setData(file.getBytes());
            doc.setCategory(cdCategory);

            return ManualDocResponse.ManualDocResponse(repository.save(doc));

    }

    //metodo para listar todos os arquivos
    @Transactional
    public List<ManualDocResponse> listAllManuals() {

        List<ManualsDocs> listManuals = repository.listAllManuals();

        return listManuals.stream().map(ManualDocResponse::ManualDocResponse).collect(Collectors.toList());

    }

    //metodo para excluir um manual
    public boolean deleteManual(Integer cdManual) {

        Optional<ManualsDocs> deleteSoftware = Optional.ofNullable(repository.findById(cdManual).orElseThrow(() ->
                new EntityNotFoundException("Manual não encontrado")));

        if (deleteSoftware.isPresent()) {
            repository.deleteById(cdManual);
            return true;
        }

        return false;

    }

    /*
    * metodo para buscar um manual*/
    public ManualDocResponse findManual(Integer fileId) {

        Optional<ManualsDocs> doc = Optional.ofNullable(repository.findById(fileId).orElseThrow(
                () -> new EntityNotFoundException("Manual Não encontrado !")
        ));

        ManualDocResponse manual = new ManualDocResponse();

        manual.setId(doc.get().getId());
        manual.setCategory(doc.get().getCategory());
        manual.setDocType(doc.get().getDocType());
        manual.setDocName(doc.get().getDocName());
        manual.setData(doc.get().getData());

        return manual;


    }




}
