package pl.p_a_w.biblioteka.Autorzy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.p_a_w.biblioteka.Ksiazki.Ksiazki;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Autorzy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_autora", nullable = false)
    private Integer id;

    @Column(name = "Imie", nullable = false, length = 200)
    private String imie;

    @Column(name = "Nazwisko", nullable = false, length = 200)
    private String nazwisko;

    @OneToMany(mappedBy = "idAutora")
    private Set<Ksiazki> ksiazkis = new LinkedHashSet<>();

}