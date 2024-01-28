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
@Table(name="garaze")
public class Garaza implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="garaza_id")
    private Long garazaId;

    @Column(name="kapacitet")
    private Long kapacitet;
    @Column(name="adresa", unique = true, length = 50)
    private String adresa;

    @ManyToOne
    @JoinColumn(name = "tip_id", referencedColumnName = "tip_garaze_id")
    private TipGaraze tip;

    @OneToMany
    private Set<Vozilo> vozila = new HashSet<>();

    @Override
    public String toString() {
        return "Garaza{" +
                ", adresa='" + adresa +
                "kapacitet=" + kapacitet +
                '}';
    }
}
