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
@Table(name="povlascena_karta")
public class PovlascenaKarta implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="povlascena_karta_id")
    private Long povlascenaKartaId;
    @Column(name="popust")
    private Double popust;
}
