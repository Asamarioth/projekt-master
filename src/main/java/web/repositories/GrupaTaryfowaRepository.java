package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.entities.GrupaTaryfowa;

public interface GrupaTaryfowaRepository extends JpaRepository<GrupaTaryfowa, Integer> {

    @Query(value = "SELECT g.* FROM grupy_taryfowe g INNER JOIN klienci k ON g.id_grupy_taryfowej = k.id_grupy_taryfowej INNER JOIN faktury f on f.id_klienta = k.id_klienta WHERE f.id_faktury =:id", nativeQuery = true)
    GrupaTaryfowa findGrupaTaryfowaByFakturaID(@Param("id") int id);
}
