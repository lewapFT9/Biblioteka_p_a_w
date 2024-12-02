package pl.p_a_w.biblioteka.service;


import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.p_a_w.biblioteka.model.Uzytkownicy;
import pl.p_a_w.biblioteka.repo.UserRepo;

@Service
public class RegisterService {

    @Autowired
    private UserRepo uRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    public String verify(Uzytkownicy uzytkownik) {
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken
                                (uzytkownik.getEmail(),uzytkownik.getHaslo()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(uzytkownik.getEmail());
        }
        return "Fail";
    }

    public ResponseEntity<String> register(Uzytkownicy uzytkownik) {
        try {
            uzytkownik.setHaslo(passwordEncoder.encode(uzytkownik.getHaslo()));
            uzytkownik.setRola("ADMIN");
            uRepo.save(uzytkownik);
            if (uzytkownik.getId() > 0) {
                return ResponseEntity.status(200).body("Successfully registered!");
            }
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Data integrity violation", e);
        } catch (ConstraintViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Validation error", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error", e);
        }
        return ResponseEntity.ok("User not saved");
    }
}
