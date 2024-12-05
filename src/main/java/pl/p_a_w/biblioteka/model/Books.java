package pl.p_a_w.biblioteka.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Books", schema = "railway")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 300)
    private String title;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor")
    @JsonBackReference
    private Authors idAuthor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategory")
    @JsonBackReference
    private Categories idCategory;

    @ColumnDefault("1")
    @Column(name = "numberOfCopies")
    private Integer numberOfCopies;

    @OneToMany(mappedBy = "idBook", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Rents> rentalsS = new LinkedHashSet<>();

}