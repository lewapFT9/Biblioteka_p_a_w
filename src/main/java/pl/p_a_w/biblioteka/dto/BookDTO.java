package pl.p_a_w.biblioteka.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class BookDTO {
    private int id;
    private String title;
    private String author;
    private String category;
    private int yearOfRelease;
    private int numberOfCopies;


    public BookDTO(int id, String title, String author, String category, int yearOfRelease, int numberOfCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.numberOfCopies = numberOfCopies;
    }

}
