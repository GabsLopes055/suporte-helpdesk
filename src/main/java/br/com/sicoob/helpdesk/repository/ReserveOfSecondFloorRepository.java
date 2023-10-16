package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.ReserveOfSecondFloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveOfSecondFloorRepository extends JpaRepository<ReserveOfSecondFloorEntity, Long> {

    @Query(value = "SELECT * FROM tbl_reserve_of_second_floor ORDER BY cd_reserve DESC LIMIT 25", nativeQuery = true)
    List<ReserveOfSecondFloorEntity> findAll();

}
