package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.ReserveOfSecondFloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveOfSecondFloorRepository extends JpaRepository<ReserveOfSecondFloorEntity, Long> {
}
