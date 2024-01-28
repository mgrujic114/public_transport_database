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
@Table(name="kategorije")
public class Kategorija implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kategorija_id")
    private Long kategorijaId;

    @Column(name="naziv", length = 5)
    private String nazivKategorije;

    @ManyToMany
    @JoinTable(
            name = "vozila_u_kategoriji",
            joinColumns = @JoinColumn(name = "kategorija_id"),
            inverseJoinColumns = @JoinColumn(name = "tip_vozila_id")
    )
    private List<TipVozila> vozila = new ArrayList<>();

    @OneToMany
    private Set<Vozac> vozaci = new HashSet<>();

    @Override
    public String toString() {
        return "Kategorija{" +
                "nazivKategorije='" + nazivKategorije + '\'' +
                '}';
    }
}
