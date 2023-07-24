package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.CategoryOfManuals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryOfManualsRepository extends JpaRepository<CategoryOfManuals, Long> {
}
