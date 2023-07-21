package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.ManualsDocs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualsDocsRepository extends JpaRepository<ManualsDocs, Integer> {
}
