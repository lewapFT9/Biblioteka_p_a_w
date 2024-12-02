package pl.p_a_w.biblioteka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Autorzy", schema = "sql7747662")
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
    @JsonIgnore
    private Set<Ksiazki> ksiazkis = new LinkedHashSet<>();

}