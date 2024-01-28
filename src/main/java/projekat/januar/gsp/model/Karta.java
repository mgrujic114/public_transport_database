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
@Table(name="karte")
public class Karta implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="karta_id")
    private Long kartaId;
    @Column(name="povlascena", columnDefinition = "boolean default true")
    private Boolean jePovlascena;

    @ManyToOne
    @JoinColumn(name = "period_vazenja_id", referencedColumnName = "period_vazenja_id")
    private PeriodVazenja period;

    @Override
    public String toString() {
        return "Karta{" +
                "kartaId=" + kartaId +
                ", jePovlascena=" + jePovlascena +
                '}';
    }
}
