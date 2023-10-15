package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {


//    @Query(value = "SELECT * FROM tbl_equipments WHERE nameEquipment = :nameEquipment", nativeQuery = true)
    EquipmentEntity findBynameEquipment(String nameEquipment);

    @Query(value = "SELECT * FROM tbl_equipments WHERE status = true", nativeQuery = true)
    List<EquipmentEntity> findByStatus();
}
