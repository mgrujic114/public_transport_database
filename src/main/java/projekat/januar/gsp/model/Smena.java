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
@Table(name="smena")
public class Smena implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="smena_id")
    private Long smenaId;
    @Column(name = "pocetak", length = 10)
    private String pocetak;
    @Column(name = "kraj", length = 10)
    private String kraj;
}
