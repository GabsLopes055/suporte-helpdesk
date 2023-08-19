package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.Information;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InformationResponse {

    private Long cdInform;

    private String title;

    private String description;

    private String content;

    private String docName;

    private String docType;

    private byte[] data;

    @Transactional
    public static InformationResponse InformationResponse(Information information) {

        InformationResponse response = new InformationResponse();

        response.setCdInform(information.getCdInform());
        response.setTitle(information.getTitle());
        response.setDescription(information.getDescription());
        response.setContent(information.getContent());
        response.setDocName(information.getDocName());
        response.setDocType(information.getDocType());
        response.setData(information.getData());

        return response;

    }

}
