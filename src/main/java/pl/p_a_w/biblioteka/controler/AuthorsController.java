package pl.p_a_w.biblioteka.controler;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.p_a_w.biblioteka.model.Authors;
import pl.p_a_w.biblioteka.service.AuthorService;

@RestController
public class AuthorsController {
    final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }



    @PostMapping("/admin/author/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> addAuthor(@RequestBody Authors author) {
        return authorService.addAuthor(author);
    }

    @PatchMapping("/admin/author/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> updateAuthor(@PathVariable("id") int id, @RequestBody Authors author) {
        return ResponseEntity.ok(authorService.updateAuthor(id, author));
    }

    @DeleteMapping("/admin/author/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Object> deleteAuthor(@PathVariable("id") int id) {
        return authorService.deleteAuthorById(id);
    }

}
