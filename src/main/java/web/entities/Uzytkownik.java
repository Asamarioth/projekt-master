package web.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Uzytkownik implements Serializable{


    @Id
    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;
    
    @NotEmpty
    private String role;
    
    @OneToOne(mappedBy = "uzytkownik")
    private Pracownik pracownik;


}