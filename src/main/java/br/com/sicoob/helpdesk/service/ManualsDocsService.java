package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.response.ManualDocResponse;
import br.com.sicoob.helpdesk.entities.ManualsDocs;
import br.com.sicoob.helpdesk.repository.ManualsDocsRepository;
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
    public ManualDocResponse saveNewManual(MultipartFile file) throws IOException {

            ManualsDocs doc = new ManualsDocs();

            doc.setDocName(file.getOriginalFilename());
            doc.setDocType(file.getContentType());
            doc.setData(file.getBytes());

            return ManualDocResponse.ManualDocResponse(repository.save(doc));

    }

    //metodo para listar todos os arquivos
    public List<ManualDocResponse> listAllManuals() {

        List<ManualsDocs> listManuals = repository.findAll();

        List<ManualDocResponse> listDTO = listManuals.stream().map(list -> ManualDocResponse.ManualDocResponse(list)).collect(Collectors.toList());

        return listDTO;

    }

}
