package pl.p_a_w.biblioteka.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.p_a_w.biblioteka.model.Users;
import pl.p_a_w.biblioteka.repo.UserRepo;

import java.util.List;

@RestController
public class Test {
    final UserRepo userRepo;

    public Test(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/test")
    public List<Users> home() {
        return userRepo.findAll();
    }
}
