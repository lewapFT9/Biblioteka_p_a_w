package pl.p_a_w.biblioteka.dto;


import java.time.LocalDate;


public class RentDTO {
    private Integer id;
    private String title;
    private LocalDate rentDate;
    private LocalDate returnDate;

    public RentDTO(Integer id, String title, LocalDate rentDate, LocalDate returnDate) {
        this.id = id;
        this.title = title;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "RentDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                '}';
    }

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

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
