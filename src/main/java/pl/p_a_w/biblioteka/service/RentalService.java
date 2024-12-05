package pl.p_a_w.biblioteka.service;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.model.Books;
import pl.p_a_w.biblioteka.model.DaneUzytkownika;
import pl.p_a_w.biblioteka.model.Rents;
import pl.p_a_w.biblioteka.model.Users;
import pl.p_a_w.biblioteka.repo.BooksRepo;
import pl.p_a_w.biblioteka.repo.RentalsRepo;
import pl.p_a_w.biblioteka.repo.UserRepo;

import java.time.LocalDate;
import java.util.List;

@Service
public class RentalService {

    final RentalsRepo rentalsRepo;
    final BooksService booksService;
    final UserRepo userRepo;
    final UserService userService;
    private final BooksRepo booksRepo;

    public RentalService(RentalsRepo rentalsRepo, BooksService booksService, UserRepo userRepo, UserService userService, BooksRepo booksRepo) {
        this.rentalsRepo = rentalsRepo;
        this.booksService = booksService;
        this.userRepo = userRepo;
        this.userService = userService;
        this.booksRepo = booksRepo;
    }

    public ResponseEntity<Rents> rentBook(int id){
        Books book = booksService.getBookById(id).getBody();
        assert book != null;
        if(book.getNumberOfCopies()>0) {
            UserDetails userDetails = userService.getLoggedInUserDetails();
            Users user = userRepo.findByEmail(userDetails.getUsername());
            Rents rent = new Rents();
            rent.setIdBook(book);
            rent.setIdUser(user);
            rent.setRentDate(LocalDate.now());
            book.setNumberOfCopies(book.getNumberOfCopies() - 1);
            rentalsRepo.save(rent);
            return new ResponseEntity<>(rent, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public List<Rents> UserRents(){
        UserDetails userDetails = userService.getLoggedInUserDetails();
        Users user = userRepo.findByEmail(userDetails.getUsername());
        return rentalsRepo.findByUserId(user.getId());
    }

    public ResponseEntity<Rents> returnBook(int id){
        UserDetails userDetails = userService.getLoggedInUserDetails();
        Users user = userRepo.findByEmail(userDetails.getUsername());
        if(rentalsRepo.findById(id).isPresent()) {
            Rents rent = rentalsRepo.findById(id).get();
            if(rent.getIdUser().getId().equals(user.getId())) {
                rent.setReturnDate(LocalDate.now());
                Books book = booksService.getBookById(rent.getIdBook().getId()).getBody();
                assert book != null;
                book.setNumberOfCopies(book.getNumberOfCopies() + 1);
                booksRepo.save(book);
                rentalsRepo.save(rent);
                return ResponseEntity.ok(rent);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
