package pl.p_a_w.biblioteka.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.p_a_w.biblioteka.model.Rents;
import pl.p_a_w.biblioteka.service.RentalService;

@RestController
public class RentalsController {
    final RentalService rentalService;


    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @PostMapping("/books/{id}/rent")
    public ResponseEntity<Rents> rentBook(@PathVariable int id) {
        return rentalService.rentBook(id);
    }
}
