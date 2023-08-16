package br.com.sicoob.helpdesk.dto.request;

import br.com.sicoob.helpdesk.dto.response.ManualDocResponse;
import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import br.com.sicoob.helpdesk.entities.ManualsDocs;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryOfManualRequest {

    @NotBlank(message = "O campo id não pode ser vazio")
    private Long cdCategory;

    @NotBlank(message = "O campo categoria não pode ser vazio")
    private String category;

}
