package br.com.sicoob.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentOfSecondFloor extends JpaRepository<EquipmentOfSecondFloor, Long> {
}
