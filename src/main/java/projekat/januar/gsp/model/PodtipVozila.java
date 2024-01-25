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
@Table(name="podtip_vozila")
public class PodtipVozila implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="podtip_vozila_id")
    private Long podtipVozilaId;
    @Column(name="naziv", unique = true, length = 30)
    private String naziv;
}
