package br.com.sicoob.helpdesk.dto.request;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ManualDocRequest {

    @NotBlank(message = "O campo nome não pode ser vazio")
    private String docName;

    @NotBlank(message = "O campo tipo não pode ser vazio")
    private String docType;

    @NotBlank(message = "O campo data não pode ser vazio")
    private byte[] data;
}
