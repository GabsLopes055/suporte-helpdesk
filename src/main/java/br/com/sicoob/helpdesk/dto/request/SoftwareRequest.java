package br.com.sicoob.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SoftwareRequest {

    @Positive(message = "O id deve ser um número positivo.")
    private Long cdsoftware;

    @NotBlank(message = "O titulo não pode ser vazio")
    private String title;

    @NotBlank(message = "O link não pode ser vazio")
    private String link;

}
