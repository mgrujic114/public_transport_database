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
@Table(name="kategorije_vozila")
public class KategorijaVozila implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kategorija_vozila_id")
    private Long kategorijaVozilaId;

//    @ManyToOne
//    @JoinColumn(name = "kategorija_id", referencedColumnName = "kategorija_id")
//    private Kategorija kategorija;
//
//    @ManyToOne
//    @JoinColumn(name = "tip_vozila_id", referencedColumnName = "tip_vozila_id")
//    private TipVozila tip;

}
