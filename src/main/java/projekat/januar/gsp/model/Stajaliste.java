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
@Table(name="stajaliste")
public class Stajaliste implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stajaliste_id")
    private Long stajalisteId;

    @Column(name = "naziv", unique = true, length = 30)
    private String nazivStajalista;
    @Column(name="kod", unique = true, length = 10)
    private String kod;
    @Column(name = "terminus", columnDefinition = "boolean default false")
    private Boolean jeTerminus;
}
