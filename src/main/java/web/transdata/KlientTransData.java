
package web.transdata;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import web.entities.Klient;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KlientTransData extends Klient {
    
    private String idRejonu;
    
    private String idGrupyTaryfowej;
    
    
   public Klient extractKlient() {
       Klient klient = new Klient();
       klient.setNazwaKlienta(this.getNazwaKlienta());
       klient.setKodPocztowy(this.getKodPocztowy());
       klient.setMiejscowosc(this.getMiejscowosc());
       klient.setNrDomu(this.getNrDomu());
       klient.setNrIdentyfikacyjny(this.getNrIdentyfikacyjny());
       klient.setNrKonta(this.getNrKonta());
       klient.setUlica(this.getUlica());
       return klient;
   }
}
