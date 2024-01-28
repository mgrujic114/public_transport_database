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
@Table(name="podtipovi_vozila")
public class PodtipVozila implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="podtip_vozila_id")
    private Long podtipVozilaId;
    @Column(name="naziv", unique = true, length = 30)
    private String naziv;

    @OneToMany
    private Set<Vozilo> vozila = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "tip_vozila_id", referencedColumnName = "tip_vozila_id")
    private TipVozila tip;

    @Override
    public String toString() {
        return "PodtipVozila{" +
                "naziv='" + naziv + '\'' +
                '}';
    }
}
