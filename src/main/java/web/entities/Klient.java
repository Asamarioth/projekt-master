package web.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "klienci")
public class Klient implements Serializable {

    @Id
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idKlienta;

    @NotEmpty
    private String nazwaKlienta;

    @NotEmpty
    private String nrIdentyfikacyjny;

    @NotEmpty
    private String nrKonta;

    @NotEmpty
    private String ulica;

    @NotEmpty
    private String nrDomu;

    @NotEmpty
    private String kodPocztowy;

    @NotEmpty
    private String miejscowosc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRejonu")
    private Rejon rejon;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idGrupyTaryfowej")
    private GrupaTaryfowa grupaTaryfowa;

    @OneToMany(mappedBy = "klient", cascade = {
        CascadeType.ALL
    })
    private List<Faktura> faktury;
    

}
