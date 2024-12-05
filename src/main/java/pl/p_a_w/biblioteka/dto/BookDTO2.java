package pl.p_a_w.biblioteka.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookDTO2 {
    private String title;
    private String category;
    private Integer yearOfRelease;
    private Integer numberOfCopies;
    private String authorName;
    private String authorSurname;

    public BookDTO2(String title, String category, int yearOfRelease, int numberOfCopies, String authorName, String authorSurname) {
        this.title = title;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.numberOfCopies = numberOfCopies;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }
}
