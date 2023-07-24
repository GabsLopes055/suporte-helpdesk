package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.entities.ManualsDocs;
import lombok.Data;

import java.util.List;

@Data
public class CategoryOfManualResponse {

    private Long cdCategory;

    private String category;

    private List<ManualDocResponse> manual;

}
