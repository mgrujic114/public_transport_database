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
@Table(name="tip_povlastice")
public class TipPovalstice implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tip_povlastice_id")
    private Long tipPovlasticeId;
    @Column(name = "naziv", length = 20)
    private String naziv;
}
