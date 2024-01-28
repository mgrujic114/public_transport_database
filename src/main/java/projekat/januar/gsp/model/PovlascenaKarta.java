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
@Table(name="povlascene_karte")
public class PovlascenaKarta implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="povlascena_karta_id")
    private Long povlascenaKartaId;
    @Column(name="popust")
    private Double popust;

    @ManyToOne
    @JoinColumn(name = "tip_povlastice_id", referencedColumnName = "tip_povlastice_id")
    private TipPovalstice povlastica;

    @OneToOne
    @JoinColumn(name = "karta_id", referencedColumnName = "karta_id")
    private Karta karta;

    @Override
    public String toString() {
        return "PovlascenaKarta{" + povlastica +
                " popust=" + popust +
                '}';
    }
}
