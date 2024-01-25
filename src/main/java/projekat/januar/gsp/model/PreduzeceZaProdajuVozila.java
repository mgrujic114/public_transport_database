package projekat.januar.gsp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="preduzece_za_prodaju_vozila")
public class PreduzeceZaProdajuVozila implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="preduzece_id")
    private Long preduzeceId;
    @Column(name = "naziv", length = 50)
    private String nazivPreduzeca;
    @Column(name = "mejl", unique = true, length = 75)
    private String eMail;
    @Column(name="websajt", unique = true, length = 100)
    private String sajt;
}
