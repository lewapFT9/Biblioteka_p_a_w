package pl.p_a_w.biblioteka.controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/")
    public String home() {
        return "Welcome to Biblioteka!";
    }
}
