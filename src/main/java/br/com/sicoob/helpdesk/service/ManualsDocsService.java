package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.CategoryOfManualRequest;
import br.com.sicoob.helpdesk.dto.response.ManualDocResponse;
import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.entities.ManualsDocs;
import br.com.sicoob.helpdesk.repository.ManualsDocsRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
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

}
