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
@Table(name="radna_vremena")
public class RadnoVreme implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="radno_vreme_id")
    private Long radnoVremeId;
    @Column(name = "radni_dan", length = 20)
    private String radniDan;
    @Column(name = "subota", length = 20)
    private String subota;
    @Column(name = "nedelja", length = 20)
    private String nedelja;

    @OneToMany
    private Set<Vozac> vozaci = new HashSet<>();

    @Override
    public String toString() {
        return "RadnoVreme{" +
                "radniDan='" + radniDan + '\'' +
                ", subota='" + subota + '\'' +
                ", nedelja='" + nedelja + '\'' +
                '}';
    }
}
