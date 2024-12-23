package pl.p_a_w.biblioteka.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
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
}
