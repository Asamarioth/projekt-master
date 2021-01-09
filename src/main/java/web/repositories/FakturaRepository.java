
package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.entities.Faktura;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Integer> {
    
}
