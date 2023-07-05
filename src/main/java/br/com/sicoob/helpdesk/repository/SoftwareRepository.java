package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.SoftwareEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareRepository extends JpaRepository<SoftwareEntities, Long> {
}
