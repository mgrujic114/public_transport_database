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
@Table(name="kategorija_vozila")
public class Kategorija_Vozila implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kategorija_vozila_id")
    private Long kategorijaVozilaId;
}
