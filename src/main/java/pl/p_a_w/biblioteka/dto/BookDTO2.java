package pl.p_a_w.biblioteka.dto;


public class BookDTO2 {
    private String title;
    private String category;
    private Integer yearOfRelease;
    private Integer numberOfCopies;
    private String authorName;
    private String authorSurname;

    public BookDTO2() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public BookDTO2(String title, String category, int yearOfRelease, int numberOfCopies, String authorName, String authorSurname) {
        this.title = title;
        this.category = category;
        this.yearOfRelease = yearOfRelease;
        this.numberOfCopies = numberOfCopies;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
    }
}
