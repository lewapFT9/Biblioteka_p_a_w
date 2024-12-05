package pl.p_a_w.biblioteka.service;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.model.Users;
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

    public UserDetails getLoggedInUserDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            return (UserDetails) auth.getPrincipal();
        }
        return null;
    }
    public ResponseEntity<Users> getUserById(Integer id) {
        if(userRepo.findById(id).isPresent()) {
            return ResponseEntity.ok(userRepo.findById(id).get());
        }
        return null;
    }

}
