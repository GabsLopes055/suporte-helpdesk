package br.com.sicoob.helpdesk.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InformationRequest {


    private Long cdInform;

    @NotBlank(message = "O titulo não pode ser vazio")
    private String title;

    @NotBlank(message = "A descrição não pode ser vazio")
    private String description;

    @NotBlank(message = "Conteudo não pode ser vazio")
    private String content;

    @NotBlank(message = "O nome do arquivo não pode ser vazio")
    private String docName;

    @NotBlank(message = "O tipo do arquivo não pode ser vazio")
    private String docType;

    @NotBlank(message = "Arquivo vazio")
    private byte[] data;



}
