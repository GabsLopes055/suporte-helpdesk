package br.com.sicoob.helpdesk.dto.request;

import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryOfManualRequest {

    @NotBlank(message = "O campo id não pode ser vazio")
    private Long cdCategory;

    @NotBlank(message = "O campo categoria não pode ser vazio")
    private String category;



}
