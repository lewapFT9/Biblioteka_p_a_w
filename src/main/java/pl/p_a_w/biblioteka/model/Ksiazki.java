package pl.p_a_w.biblioteka.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Ksiazki", schema = "sql7747662")
public class Ksiazki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_ksiazki", nullable = false)
    private Integer id;

    @Column(name = "Tytul", nullable = false, length = 300)
    private String tytul;

    @Column(name = "Rok_wydania")
    private Integer rokWydania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_autora")
    @JsonBackReference
    private Autorzy idAutora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_kategorii")
    @JsonBackReference
    private Kategorie idKategorii;

    @ColumnDefault("1")
    @Column(name = "Ilosc_egzemplarzy")
    private Integer iloscEgzemplarzy;

    @OneToMany(mappedBy = "idKsiazki")
    @JsonIgnore
    private Set<Wypozyczenia> wypozyczenias = new LinkedHashSet<>();

}