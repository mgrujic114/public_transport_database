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
@Table(name="smerovi")
public class Smer implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="smer_id")
    private Long smerId;

    @OneToMany
    private Set<RedVoznje> redVoznje = new HashSet<>();

    @Override
    public String toString() {
        return "Smer{" +
                "smerId=" + smerId +
                '}';
    }
}
