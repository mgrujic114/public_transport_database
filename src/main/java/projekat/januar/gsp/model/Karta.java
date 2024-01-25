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
@Table(name="karta")
public class Karta implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="karta_id")
    private Long kartaId;
    @Column(name="povlascena", columnDefinition = "boolean default true")
    private Boolean jePovlascena;
}
