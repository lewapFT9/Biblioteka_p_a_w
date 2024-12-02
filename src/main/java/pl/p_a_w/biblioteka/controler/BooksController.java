package pl.p_a_w.biblioteka.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.p_a_w.biblioteka.model.Ksiazki;
import pl.p_a_w.biblioteka.service.BooksService;

import java.util.List;

@RestController
public class BooksController {
    final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/books")
    public ResponseEntity<Object> books() {
        return booksService.getBooks();
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("books/{id}")
    public ResponseEntity<Object> book(@PathVariable Integer id) {
        return booksService.getBook(id);
    }
}
