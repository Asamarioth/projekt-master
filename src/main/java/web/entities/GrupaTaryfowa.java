package web.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "grupyTaryfowe")
public class GrupaTaryfowa implements Serializable {

    @Id
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGrupyTaryfowej;

    @NotEmpty
    private String nazwaGrupyTaryfowej;

    @NotEmpty
    private double stawkaTaryfowa;

    @OneToMany(mappedBy = "grupaTaryfowa", cascade = {
        CascadeType.ALL
    })
    private List<Klient> klienci;
}
