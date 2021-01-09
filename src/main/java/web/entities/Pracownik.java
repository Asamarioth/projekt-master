package web.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pracownicy")
public class Pracownik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPracownika;

    private String imie;

    private String nazwisko;

    @OneToMany(mappedBy = "pracownik", cascade = {
        CascadeType.ALL
    })
    private List<Faktura> klienci;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    private Uzytkownik uzytkownik;

}
