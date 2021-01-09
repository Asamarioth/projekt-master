
package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.entities.Klient;

@Repository
public interface KlientRepository extends JpaRepository<Klient, Integer> {
    
}
