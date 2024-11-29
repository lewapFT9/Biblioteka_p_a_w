package pl.p_a_w.biblioteka.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Uzytkownicy", schema = "sql7747662")
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
    @Column(name = "Rola", length = 10)
    private String rola;

    @Column(name = "Haslo", nullable = false, length = 100)
    private String haslo;

    @OneToMany(mappedBy = "idUzytkownika")
    private Set<Wypozyczenia> wypozyczenias = new LinkedHashSet<>();

}