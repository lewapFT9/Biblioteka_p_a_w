package pl.p_a_w.biblioteka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.p_a_w.biblioteka.model.DaneUzytkownika;
import pl.p_a_w.biblioteka.model.Users;
import pl.p_a_w.biblioteka.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users uzytkownik = repo.findByEmail(email);
        if (uzytkownik == null) {
            throw new UsernameNotFoundException(email);
        }
        return new DaneUzytkownika(uzytkownik);
    }

}
