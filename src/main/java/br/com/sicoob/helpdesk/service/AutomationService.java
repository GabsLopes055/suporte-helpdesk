package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.response.AutomationsResponse;
import br.com.sicoob.helpdesk.entities.Automations;
import br.com.sicoob.helpdesk.repository.AutomationsRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

}
