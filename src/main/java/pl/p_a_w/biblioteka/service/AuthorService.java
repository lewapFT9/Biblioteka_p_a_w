package pl.p_a_w.biblioteka.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.model.Authors;
import pl.p_a_w.biblioteka.repo.AuthorRepo;

import java.util.List;

@Service
public class AuthorService {

    final AuthorRepo authorRepo;

    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public ResponseEntity<List<Integer>> findAuthorByName(String name) {
        String adaptedName = "%"+name+"%";
        return authorRepo.findByFirstName(adaptedName).isPresent() ? ResponseEntity.ok(authorRepo.findByFirstName(adaptedName).get()) : ResponseEntity.notFound().build();
    }

    public ResponseEntity<Authors> findAuthorToAddBook(String firstName, String lastName) {
        if(authorRepo.findByNameAndSurname(firstName,lastName).isPresent()) {
            return ResponseEntity.ok(authorRepo.findByNameAndSurname(firstName,lastName).get());
        }
        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<Authors> addAuthor(String firstName, String lastName) {
        if(authorRepo.findByNameAndSurname(firstName,lastName).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Authors author = new Authors();
        author.setName(firstName);
        author.setSurname(lastName);
        authorRepo.save(author);
        return ResponseEntity.ok(author);
    }
    public ResponseEntity<Authors> getAuthorById(int id) {
        if(authorRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(authorRepo.findById(id).get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Authors> returnAuthorToAddBook(String firstName, String lastName) {
        if(authorRepo.findByNameAndSurname(firstName,lastName).isPresent()) {
            return ResponseEntity.ok(authorRepo.findByNameAndSurname(firstName,lastName).get());
        }
        Authors author = new Authors();
        author.setName(firstName);
        author.setSurname(lastName);
        authorRepo.save(author);
        return ResponseEntity.ok(author);
    }
}
