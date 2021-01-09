
package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.entities.Pracownik;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Integer> {
    
}
