package pl.p_a_w.biblioteka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "Categories", schema = "railway")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Books> getBooksS() {
        return booksS;
    }

    public void setBooksS(Set<Books> booksS) {
        this.booksS = booksS;
    }

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "idCategory", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Books> booksS = new LinkedHashSet<>();

}