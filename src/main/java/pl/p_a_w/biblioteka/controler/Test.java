package pl.p_a_w.biblioteka.controler;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/")
    public String home() {
        return "Welcome to Biblioteka!";
    }

    //@PreAuthorize("hasAuthority('USER')")
    @GetMapping("/test")
    public String test() {
        return "Welcome to testing!";
    }
//    @RequestMapping("/error")
//    public String error() {
//        return "no i w pizdu i wylądował i cały misterny plan też w pizdu";
//    }
}
