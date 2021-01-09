package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.entities.Uzytkownik;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, String> {

    Uzytkownik findByUserName(String userName);

}