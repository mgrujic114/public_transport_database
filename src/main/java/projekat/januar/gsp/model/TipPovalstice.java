package projekat.januar.gsp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tipovi_povlastice")
public class TipPovalstice implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tip_povlastice_id")
    private Long tipPovlasticeId;
    @Column(name = "naziv", length = 20)
    private String naziv;

    @OneToMany
    private Set<PovlascenaKarta> karte = new HashSet<>();

    @Override
    public String toString() {
        return "TipPovalstice{" +
                "naziv='" + naziv +
                '}';
    }
}
