package projekat.januar.gsp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="vozilo")
public class Vozilo implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vozilo_id")
    private Long voziloId;
    @Column(name="br_mesta_za_sedenje")
    private Integer brojMestaZaSedenje;
    @Column(name="br_mesta_za_stajanje")
    private Integer brojMestaZaStajanje;
    @Column(name="pogon")
    private Integer pogon;
    @Column(name="datum_evaluacije")
    private String datumEvaluacije;
}
