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
@Table(name="redovi_voznje")
public class RedVoznje implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="red_voznje_id")
    private Long redVoznjeId;

    @Column(name = "polazak", length = 10)
    private String polazak;

    @ManyToOne
    @JoinColumn(name = "smer_id",  referencedColumnName = "smer_id")
    private Smer smer;

    @OneToOne
    @JoinColumn(name = "linija_id", referencedColumnName = "linija_id")
    private Linija linija;
    @Override
    public String toString() {
        return "RedVoznje{" + linija +
                " polazak='" + polazak + '\'' +
                '}';
    }
}
