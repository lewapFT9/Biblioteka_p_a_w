package pl.p_a_w.biblioteka.Wypozyczenia;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.p_a_w.biblioteka.Ksiazki.Ksiazki;
import pl.p_a_w.biblioteka.Uzytkownicy.Uzytkownicy;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Wypozyczenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_wypozyczenia", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_uzytkownika")
    private Uzytkownicy idUzytkownika;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_ksiazki")
    private Ksiazki idKsiazki;

    @Column(name = "Data_wypozyczenia", nullable = false)
    private LocalDate dataWypozyczenia;

    @Column(name = "Data_zwrotu")
    private LocalDate dataZwrotu;

}