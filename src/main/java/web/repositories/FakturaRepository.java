
package web.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.entities.Faktura;

@Repository
public interface FakturaRepository extends JpaRepository<Faktura, Integer> {

   @Query(value="SELECT * FROM faktury f WHERE id_klienta=:id", nativeQuery=true)
   List<Faktura> findAllByIdKlienta(@Param("id") int id);
   
   @Query(value="SELECT * FROM faktury f WHERE id_pracownika=:id", nativeQuery=true)
   List<Faktura> findAllByIdPracownika(@Param("id") int id);
   
    
    
    
}
