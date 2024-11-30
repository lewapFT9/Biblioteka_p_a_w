package pl.p_a_w.biblioteka.controler;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.p_a_w.biblioteka.model.Uzytkownicy;
import pl.p_a_w.biblioteka.service.RegisterService;

import java.security.NoSuchAlgorithmException;

@RestController
public class LoginRegisterController {


    @Autowired
    private RegisterService registerService;


    @PostMapping("/login12")
    public String login(@RequestBody Uzytkownicy uzytkownik) throws NoSuchAlgorithmException {
        return registerService.verify(uzytkownik);
    }


    @PostMapping(path = "/register")
    public ResponseEntity<String> RegisterUser(@Valid @RequestBody Uzytkownicy uzytkownik) {
        return registerService.register(uzytkownik);
    }

}
