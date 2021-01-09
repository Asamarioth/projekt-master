package web.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "faktury")
public class Faktura implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFaktury;
    
    private String nrFaktury;
    
    private double iloscPaliwa;
    
    private double naleznosc;
    
    private Date dataWystawienia;
    
    private Date terminPlatnosci;
    
    private boolean czyZaplacone;
    
    private Date dataPlatnosci;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idKlienta")
    private Klient klient;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPracownika")
    private Pracownik pracownik;
}
