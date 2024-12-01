package pl.p_a_w.biblioteka.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Wypozyczenia", schema = "sql7747662")
public class Wypozyczenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_wypozyczenia", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_uzytkownika")
    @JsonBackReference
    private Uzytkownicy idUzytkownika;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_ksiazki")
    @JsonBackReference
    private Ksiazki idKsiazki;

    @Column(name = "Data_wypozyczenia", nullable = false)
    private LocalDate dataWypozyczenia;

    @Column(name = "Data_zwrotu")
    private LocalDate dataZwrotu;

}