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
@Table(name="zone")
public class Zona implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="zona_id")
    private Long zonaId;
    @Column(name = "naziv", length = 10, unique = true)
    private String naziv;

    @Override
    public String toString() {
        return "Zona{" + naziv + '}';
    }
}
