package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.entities.ManualsDocs;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManualDocResponse {


    private Integer id;

    private String docName;

    private String docType;

    private byte[] data;

    private CategoryOfManuals category;

    @Transactional
    public static ManualDocResponse ManualDocResponse(ManualsDocs doc) {

        var response = new ManualDocResponse();

        response.setId(doc.getId());
        response.setDocName(doc.getDocName());
        response.setDocType(doc.getDocType());
        response.setData(doc.getData());
        response.setCategory(doc.getCategory());


        return response;

    }
}
