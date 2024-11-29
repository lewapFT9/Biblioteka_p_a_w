package pl.p_a_w.biblioteka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.model.DaneUzytkownika;
import pl.p_a_w.biblioteka.model.Uzytkownicy;
import pl.p_a_w.biblioteka.repo.UzytkownikRepo;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UzytkownikRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Uzytkownicy uzytkownik = repo.findByEmail(email);
        if (uzytkownik == null) {
            throw new UsernameNotFoundException(email);
        }
        return new DaneUzytkownika(uzytkownik);
    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Uzytkownicy> user = Optional.ofNullable(repo.findByEmail(username));
//        return user.map(DaneUzytkownika::new).orElseThrow(()->new UsernameNotFoundException("user does not exist"));
//
//    }
}
