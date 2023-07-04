package br.com.sicoob.helpdesk.service;

import br.com.sicoob.helpdesk.dto.request.SendSMSRequest;
import br.com.sicoob.helpdesk.dto.response.SendSMSResponse;
import br.com.sicoob.helpdesk.entities.SendSMS;
import br.com.sicoob.helpdesk.repository.SmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SendSMSService {

    @Autowired
    private SmsRepository repository;

    //mmetodo para salvar um novo SMS
    public SendSMSResponse createSMS(SendSMSRequest sms) {

        if(sms == null) {
            return null;
        }

        SendSMS newsms = new SendSMS();

        newsms.setUsername(sms.getUsername());
        newsms.setPhone(sms.getPhone());
        newsms.setTextsms(sms.getTextsms());

        try {
            createSMSService.sendSMS(sms.getPhone(), sms.getTextsms());
            //System.out.println(createSMSService.sendSMS("+5561991139141", "teste"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return SendSMSResponse.SMSResponse(repository.save(newsms));

    }

    //metodo para listar todos sms
    public List<SendSMSResponse> SendSMSResponse() {

        List<SendSMS> listSms = repository.findAllByOrderByIdDesc();

        List<SendSMSResponse> listDTO = listSms.stream().map(e -> SendSMSResponse.SMSResponse(e)).collect(Collectors.toList());

        return listDTO;
    }

}
