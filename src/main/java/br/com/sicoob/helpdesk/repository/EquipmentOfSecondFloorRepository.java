package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.EquipmentOfSecondFloorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentOfSecondFloorRepository extends JpaRepository<EquipmentOfSecondFloorEntity, Long> {
}
