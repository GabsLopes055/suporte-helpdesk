package br.com.sicoob.helpdesk.controller.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private List<String> error = new ArrayList<>();
    private String message;
    private String path;

}
