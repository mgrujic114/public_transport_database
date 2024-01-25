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
@Table(name="garaza")
public class Garaza implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="garza_id")
    private Long garazaId;

    @Column(name="kapacitet")
    private Long kapacitet;
    @Column(name="adresa", unique = true, length = 50)
    private String adresa;

}
