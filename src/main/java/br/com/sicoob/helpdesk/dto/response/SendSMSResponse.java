package br.com.sicoob.helpdesk.dto.response;

import br.com.sicoob.helpdesk.entities.SendSMS;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SendSMSResponse {

    private Long cdSMS;

    private String username;

    private String phone;

    private String textsms;

    public static SendSMSResponse SMSResponse(SendSMS sms){
        var response = new SendSMSResponse();
        response.setCdSMS(sms.getCdSMS());
        response.setUsername(sms.getUsername());
        response.setPhone(sms.getPhone());
        response.setTextsms(sms.getTextsms());

        return response;
    }

}
