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
@Table(name="vozaci")
public class Vozac implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vozac_id")
    private Long vozacId;
    @Column(name = "ime", length = 15)
    private String ime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "kategorija_id", referencedColumnName = "kategorija_id", nullable = false)
    private Kategorija kategorija;

    @ManyToOne
    @JoinColumn(name = "radno_vreme_id",  referencedColumnName = "radno_vreme_id")
    private RadnoVreme radnoVreme;

    @Override
    public String toString() {
        return "Vozac{" +
                "ime='" + ime +
                '}';
    }
}
