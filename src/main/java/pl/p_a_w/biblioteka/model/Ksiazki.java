package pl.p_a_w.biblioteka.model;

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
    private Autorzy idAutora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_kategorii")
    private Kategorie idKategorii;

    @ColumnDefault("1")
    @Column(name = "Ilosc_egzemplarzy")
    private Integer iloscEgzemplarzy;

    @OneToMany(mappedBy = "idKsiazki")
    private Set<Wypozyczenia> wypozyczenias = new LinkedHashSet<>();

}