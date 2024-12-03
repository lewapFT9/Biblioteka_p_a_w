package pl.p_a_w.biblioteka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import pl.p_a_w.biblioteka.model.Books;

import java.util.List;
import java.util.Optional;


@Repository
public interface BooksRepo extends JpaRepository<Books, Integer> {
    @Query(value = "select * from books where id_category = ?1", nativeQuery = true)
    Optional<List<Books>> findAllByCategory(int category);
}
