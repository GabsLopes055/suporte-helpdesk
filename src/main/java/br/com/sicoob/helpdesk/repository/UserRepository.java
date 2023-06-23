package br.com.sicoob.helpdesk.repository;

import br.com.sicoob.helpdesk.entities.UserEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntities, Long> {

    UserEntities findByUsername(String username);

}
