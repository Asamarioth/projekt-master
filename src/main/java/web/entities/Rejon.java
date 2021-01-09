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
@Table(name = "rejon")
public class Rejon implements Serializable{

    @Id
    @NotEmpty
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRejonu;
    
    private String nazwaRejonu;
    
    @NotEmpty
    private double abonament;
    
    @NotEmpty
    private double oplataSieciowaStala;
    
    @NotEmpty
    private double oplataSieciowaZmienna;
    
    @OneToMany(mappedBy = "rejon", cascade = {
        CascadeType.ALL
    })
    private List<Klient> klienci;
    

}
