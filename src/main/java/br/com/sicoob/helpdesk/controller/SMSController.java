package br.com.sicoob.helpdesk.controller;

import br.com.sicoob.helpdesk.dto.request.SendSMSRequest;
import br.com.sicoob.helpdesk.dto.response.SendSMSResponse;
import br.com.sicoob.helpdesk.service.SendSMSService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sat/sendsms")
public class SMSController {

    @Autowired
    private SendSMSService service;

    //metodo para salvar um sms enviado
    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<SendSMSResponse> createNewSms(@RequestBody @Valid SendSMSRequest sms) {
            if(sms == null) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(service.createSMS(sms));
    }

    //metodo para listar todas os sms
    @GetMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<List<SendSMSResponse>> listAllSms() {

        return ResponseEntity.ok().body(service.SendSMSResponse());

    }

}
