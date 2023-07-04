package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.SendSMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmsRepository extends JpaRepository<SendSMS, Long> {

    @Query(value = "SELECT * FROM tbl_sms ORDER BY cdsms DESC LIMIT 25", nativeQuery = true)
    List<SendSMS> findAllByOrderByIdDesc();

}
