package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.response.AutomationsResponse;
import br.com.sicoob.helpdesk.entities.Automations;
import br.com.sicoob.helpdesk.repository.AutomationsRepository;
import br.com.sicoob.helpdesk.service.exceptions.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutomationService {

    @Autowired
    private AutomationsRepository repository;

    //metodo para salvar uma nova padronizacao
    public AutomationsResponse createdAutomation(@NotNull MultipartFile file) throws IOException {

        Automations automation = new Automations();

        automation.setDocName(file.getOriginalFilename());
        automation.setDocType(file.getContentType());
        automation.setData(file.getBytes());

        return AutomationsResponse.automationsResponse(repository.save(automation));

    }

    //metodo para listar todas as bats
    public List<AutomationsResponse> listAllAutomations() {
        List<Automations> listAll = repository.findAll();

        return listAll.stream().map(AutomationsResponse::automationsResponse).collect(Collectors.toList());
    }

    //metodo para listar uma bat por id
    public AutomationsResponse findOneAutomation(Long id) {

       Optional<Automations> findAutomation = Optional.ofNullable(repository.findById(id).orElseThrow(
               () -> new EntityNotFoundException("id não encontrado")
       ));

       var automation = findAutomation.get();

       AutomationsResponse response = new AutomationsResponse();

       response.setId(automation.getCdAutomation());
       response.setDocName(automation.getDocName());
       response.setDocType(automation.getDocType());
       response.setData(automation.getData());

       return response;

    }

    /*metodo para excluir */
    public boolean deleteAutomation(Long id) {

        if(id == null) {
            return false;
        }

        Optional<Automations> findAutomation = Optional.ofNullable(repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("id não encontrado")
        ));

        repository.deleteById(id);
        return true;

    }

}
