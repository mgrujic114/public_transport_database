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
@Table(name="tip_garaze")
public class TipGaraze implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tip_garaze_id")
    private Long tipGarazeId;
    @Column(name = "naziv", length = 15)
    private String naziv;
}
