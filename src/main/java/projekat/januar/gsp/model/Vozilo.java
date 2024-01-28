package projekat.januar.gsp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import projekat.januar.gsp.model.TipVozila;
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="vozila")
public class Vozilo implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vozilo_id")
    private Long voziloId;
    @Column(name="br_mesta_za_sedenje")
    private Integer brojMestaZaSedenje;
    @Column(name="br_mesta_za_stajanje")
    private Integer brojMestaZaStajanje;
    @Column(name="pogon", length = 10)
    private String pogon;
    @Column(name="datum_evaluacije")
    private String datumEvaluacije;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tip_id", referencedColumnName = "tip_vozila_id", nullable = false)
    private TipVozila tipVozila;

    @ManyToOne(optional = false)
    @JoinColumn(name = "podtip_id", referencedColumnName = "podtip_vozila_id", nullable = false)
    private PodtipVozila podtipVozila;

    @ManyToOne(optional = false)
    @JoinColumn(name = "garaza_id", referencedColumnName = "garaza_id", nullable = false)
    private Garaza garaza;

    @Override
    public String toString() {
        return "Vozilo{" + "voziloId=" + voziloId + '}';
    }
}
