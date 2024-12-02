package pl.p_a_w.biblioteka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.p_a_w.biblioteka.model.Uzytkownicy;


@Repository
public interface UserRepo extends JpaRepository<Uzytkownicy, Integer> {
   // @Query(value = "select * from uzytkownicy where email = ?1", nativeQuery = true)
    Uzytkownicy findByEmail(String email);
}
