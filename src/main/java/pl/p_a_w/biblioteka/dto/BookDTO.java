package pl.p_a_w.biblioteka.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO {
    private int id;
    private String tytul;
    private String autor;
    private String kategoria;
    private Integer rokWydania;
    private int iloscEgzeplazy;

    public BookDTO(Integer id, String tytul, String autor, String kategoria, Integer rokWydania, Integer iloscEgzeplazy) {
        this.id = id;
        this.tytul = tytul;
        this.autor = autor;
        this.kategoria = kategoria;
        this.rokWydania = rokWydania;
        this.iloscEgzeplazy = iloscEgzeplazy;
    }


}
