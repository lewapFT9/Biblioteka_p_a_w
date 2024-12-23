package pl.p_a_w.biblioteka.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class DaneUzytkownika implements UserDetails {

    private Users uzytkownik;
    private List<GrantedAuthority> role;


    public DaneUzytkownika(Users uzytkownik) {
        this.uzytkownik = uzytkownik;
        role = Arrays.stream(uzytkownik.getRole().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role;
    }

    @Override
    public String getPassword() {
        return uzytkownik.getPassword();
    }

    @Override
    public String getUsername() {
        return uzytkownik.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

