package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.Automations;
import jakarta.transaction.Transactional;
import lombok.Data;

import java.io.IOException;

@Data
public class AutomationsResponse {

    private Long id;

    private String docName;

    private String docType;

    private byte[] data;

    @Transactional
    public static AutomationsResponse automationsResponse(Automations automation) {

        AutomationsResponse response = new AutomationsResponse();

        response.setId(automation.getCdAutomation());
        response.setDocName(automation.getDocName());
        response.setDocType(automation.getDocType());
        response.setData(automation.getData());

        return response;
    }

}
