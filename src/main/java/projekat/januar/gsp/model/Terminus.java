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
@Table(name="terminusi")
public class Terminus implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="terminus_id")
    private Long terminusId;

    @OneToOne
    @JoinColumn(name = "stajaliste_id", referencedColumnName = "stajaliste_id")
    private Stajaliste stajaliste;

    @OneToMany
    private Set<Linija> linije = new HashSet<>();

    @Override
    public String toString() {
        return "Terminus{" +
                "terminusId=" + terminusId +
                '}';
    }
}
