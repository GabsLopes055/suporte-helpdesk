package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.ManualsDocs;
import br.com.sicoob.helpdesk.entities.SendSMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;

@Repository
public interface ManualsDocsRepository extends JpaRepository<ManualsDocs, Integer> {

    @Query(value = "SELECT * FROM public.tbl_manuals_docs", nativeQuery = true)
    List<ManualsDocs> listAllManuals();


}
