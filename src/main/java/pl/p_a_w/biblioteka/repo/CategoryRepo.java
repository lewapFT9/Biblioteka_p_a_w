package pl.p_a_w.biblioteka.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.p_a_w.biblioteka.model.Kategorie;

@Repository
public interface CategoryRepo extends JpaRepository<Kategorie, Integer> {
}