package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {

    @Query(value = "SELECT * FROM tbl_informations ORDER BY cd_inform DESC", nativeQuery = true)
    List<Information> listAllInformation();

}
