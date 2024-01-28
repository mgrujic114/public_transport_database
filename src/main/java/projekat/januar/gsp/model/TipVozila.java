package projekat.januar.gsp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tipovi_vozila")
public class TipVozila implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tip_vozila_id")
    private Long tipVozilaId;
    @Column(name = "naziv", length = 20)
    private String naziv;

    @ManyToMany(mappedBy = "vozila")
    private List<Kategorija> kategorije = new ArrayList<>();

    @OneToMany
    private Set<Vozilo> vozila = new HashSet<>();

    @Override
    public String toString() {
        return "TipVozila{" +
                "naziv='" + naziv +
                '}';
    }
}
