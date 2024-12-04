package pl.p_a_w.biblioteka.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.p_a_w.biblioteka.dto.BookDTO;
import pl.p_a_w.biblioteka.dto.BookDTO2;
import pl.p_a_w.biblioteka.model.Books;
import pl.p_a_w.biblioteka.service.BooksService;

import java.util.Map;

@RestController
public class BooksController {
    final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/books")
    public ResponseEntity<Object> books() {
        return booksService.getBooks();
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("books/{id}")
    public ResponseEntity<Object> book(@PathVariable Integer id) {
        return booksService.getBook(id);
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @PostMapping("/books/byauthor")
    public ResponseEntity<Object> booksByAuthor(@RequestBody Map<String, String> author) {
        String getAuthor = author.get("author");
        return booksService.getBooksByAuthor(getAuthor);
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @PostMapping("/savebook")
    public ResponseEntity<Books> booksSave(@RequestBody BookDTO2 bookToSave) {
        return booksService.addBook(bookToSave);
    }


}




