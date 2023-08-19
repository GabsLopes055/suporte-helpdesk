package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {
}
