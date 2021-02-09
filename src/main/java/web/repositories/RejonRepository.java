package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.entities.Rejon;

public interface RejonRepository extends JpaRepository<Rejon, Integer> {
    
    
   @Query(value="SELECT r.* FROM rejon r INNER JOIN klienci k ON r.id_rejonu = k.id_rejonu INNER JOIN faktury f on f.id_klienta = k.id_klienta WHERE f.id_faktury =:id", nativeQuery=true)
   Rejon findRejonByFakturaID(@Param("id") int id);

}