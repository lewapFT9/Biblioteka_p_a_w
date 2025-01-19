package pl.p_a_w.biblioteka.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Authors getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Authors idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Categories getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Categories idCategory) {
        this.idCategory = idCategory;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Set<Rents> getRentalsS() {
        return rentalsS;
    }

    public void setRentalsS(Set<Rents> rentalsS) {
        this.rentalsS = rentalsS;
    }
}