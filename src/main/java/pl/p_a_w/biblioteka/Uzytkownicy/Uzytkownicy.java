package pl.p_a_w.biblioteka.Uzytkownicy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import pl.p_a_w.biblioteka.Wypozyczenia.Wypozyczenia;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Uzytkownicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_uzytkownika", nullable = false)
    private Integer id;

    @Column(name = "Imie", nullable = false, length = 100)
    private String imie;

    @Column(name = "Nazwisko", nullable = false, length = 100)
    private String nazwisko;

    @Column(name = "Telefon", length = 20)
    private String telefon;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @ColumnDefault("'USER'")
    @Column(name = "Rola", nullable = false, length = 10)
    private String rola;

    @OneToMany(mappedBy = "idUzytkownika")
    private Set<Wypozyczenia> wypozyczenias = new LinkedHashSet<>();

}