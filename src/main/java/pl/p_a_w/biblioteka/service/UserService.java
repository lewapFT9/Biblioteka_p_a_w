package pl.p_a_w.biblioteka.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.repo.UserRepo;

@Service
public class UserService {

    final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public ResponseEntity<Object> getAllUsers(){
        return ResponseEntity.ok(userRepo.findAll());
    }
}
