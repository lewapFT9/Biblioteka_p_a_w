package pl.p_a_w.biblioteka.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.p_a_w.biblioteka.model.Rents;
import pl.p_a_w.biblioteka.service.RentalService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
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

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/user/rents")
    public ResponseEntity<Object> getRents() {
        return ResponseEntity.ok(rentalService.UserRents());
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @PostMapping("/user/rents/{id}")
    public ResponseEntity<Rents> returnBook(@PathVariable int id) {
        return rentalService.returnBook(id);
    }
}
