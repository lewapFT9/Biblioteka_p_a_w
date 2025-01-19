package pl.p_a_w.biblioteka.dto;




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

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", numberOfCopies=" + numberOfCopies +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
