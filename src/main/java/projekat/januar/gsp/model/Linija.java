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
@Table(name="linije")
public class Linija implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="linija_id")
    private Long linijaId;
    @Column(name="redni_broj", unique = true)
    private Integer redniBroj;

    @ManyToOne
    @JoinColumn(name = "smena_id", referencedColumnName = "smena_id")
    private Smena smena;

    @Override
    public String toString() {
        return "Linija{" +
                "redniBroj=" + redniBroj +
                '}';
    }
}
