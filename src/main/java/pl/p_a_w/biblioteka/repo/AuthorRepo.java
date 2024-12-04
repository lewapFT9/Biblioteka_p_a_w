package pl.p_a_w.biblioteka.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.p_a_w.biblioteka.model.Authors;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Authors, Integer> {

    @Query(value = "select author_id from authors where (lower(name) like lower(?1)) or (lower(surname) like lower(?1))", nativeQuery = true)
    Optional<List<Integer>> findByFirstName(String firstName);


    @Query(value = "select * from authors where lower(name) = lower(?1) and lower(surname) = lower(?2)", nativeQuery = true)
    Optional<Authors> findByNameAndSurname(String name, String surname);
}
