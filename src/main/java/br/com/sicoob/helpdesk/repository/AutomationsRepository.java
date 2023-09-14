package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.Automations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomationsRepository extends JpaRepository<Automations, Long> {
}
