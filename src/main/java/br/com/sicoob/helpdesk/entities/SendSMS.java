package br.com.sicoob.helpdesk.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_sms")
public class SendSMS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdSMS;

    private String username;

    private String phone;

    private String textsms;


}
