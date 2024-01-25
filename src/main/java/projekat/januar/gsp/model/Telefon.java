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
@Table(name="telefon")
public class Telefon implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="telefon_id")
    private Long telefonId;
    @Column(name="pozivni_broj", length = 3)
    private String pozivniBroj;
    @Column(name = "broj", length = 7)
    private String broj;

}
