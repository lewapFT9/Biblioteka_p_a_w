package pl.p_a_w.biblioteka.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Authors", schema = "railway")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "surname", nullable = false, length = 200)
    private String surname;

    @OneToMany(mappedBy = "idAuthor",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Books> booksS = new LinkedHashSet<>();

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Books> getBooksS() {
        return booksS;
    }

    public void setBooksS(Set<Books> booksS) {
        this.booksS = booksS;
    }
}