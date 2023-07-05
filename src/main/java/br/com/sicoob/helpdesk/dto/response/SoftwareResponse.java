package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.SoftwareEntities;
import lombok.Data;

@Data
public class SoftwareResponse {

    private Long cdsoftware;

    private String title;

    private String link;

    public static SoftwareResponse softwareResponseDTO(SoftwareEntities software){
        var response = new SoftwareResponse();

        response.setCdsoftware(software.getCdsoftware());
        response.setTitle(software.getTitle());
        response.setLink(software.getLink());

        return  response;

    }

}
