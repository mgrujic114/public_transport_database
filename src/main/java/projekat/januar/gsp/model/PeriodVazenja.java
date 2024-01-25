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
@Table(name="period_vazenja")
public class PeriodVazenja implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="period_vazenja_id")
    private Long periodVazenjaId;
    @Column(name = "period", unique = true, length = 30)
    private String period;
    @Column(name="cena")
    private Double cena;
}
