package pl.p_a_w.biblioteka.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.p_a_w.biblioteka.model.Categories;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Categories, Integer> {

    @Query(value = "select * from categories where lower(name) = lower(?1)", nativeQuery = true)
    Optional<Categories> findByName(String name);
}
