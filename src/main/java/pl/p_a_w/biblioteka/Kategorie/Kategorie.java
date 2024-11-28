package pl.p_a_w.biblioteka.Kategorie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.p_a_w.biblioteka.Ksiazki.Ksiazki;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Kategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_kategorii", nullable = false)
    private Integer id;

    @Column(name = "Nazwa", nullable = false, length = 100)
    private String nazwa;

    @OneToMany(mappedBy = "idKategorii")
    private Set<Ksiazki> ksiazkis = new LinkedHashSet<>();

}