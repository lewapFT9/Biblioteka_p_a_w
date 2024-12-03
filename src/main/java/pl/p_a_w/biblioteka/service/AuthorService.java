package pl.p_a_w.biblioteka.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
}
