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
@Table(name="tip_vozila")
public class TipVozila implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tip_vozila_id")
    private Long tipVozilaId;
    @Column(name = "naziv", length = 20)
    private String naziv;
}
