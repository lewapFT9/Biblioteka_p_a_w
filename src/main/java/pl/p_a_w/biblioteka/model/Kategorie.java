package pl.p_a_w.biblioteka.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Kategorie", schema = "sql7747662")
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