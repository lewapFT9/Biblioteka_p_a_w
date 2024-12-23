package pl.p_a_w.biblioteka.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.p_a_w.biblioteka.model.Rents;

import java.util.List;

@Repository
public interface RentalsRepo extends JpaRepository<Rents, Integer> {

    @Query(value = "select * from rentals where user_id = ?1", nativeQuery = true)
    List<Rents> findByUserId(int id);
}
