package pl.p_a_w.biblioteka.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.p_a_w.biblioteka.model.Uzytkownicy;
import pl.p_a_w.biblioteka.repo.UzytkownikRepo;

@RestController
public class LoginRegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UzytkownikRepo uRepo;

   @PostMapping(path = "/register")
    public ResponseEntity<Object> RegisterUser(@RequestBody Uzytkownicy uzytkownik) {
        uzytkownik.setHaslo(passwordEncoder.encode(uzytkownik.getHaslo()));
        uzytkownik.setRola("USER");
        uRepo.save(uzytkownik);
        if(uzytkownik.getId() > 0){
            return ResponseEntity.ok("User saved");
        }
        return ResponseEntity.status(404).body("User not saved");
   }
}