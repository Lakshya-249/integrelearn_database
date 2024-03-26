package JWT_auth.authorization.authcontrollers;

import JWT_auth.authorization.config.JWTservice;
import JWT_auth.authorization.user.Role;
import JWT_auth.authorization.user.User;
import JWT_auth.authorization.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final JWTservice jwTservice;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthenticationService(UserRepository repository, JWTservice jwTservice, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.jwTservice = jwTservice;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }


    public AuhtenticationResponse register(RegisterRequest request){
        User user = new User(
                request.getFirstname(),
                request.getLastname(),
                request.getDate_of_Birth(),
                request.getEmail_id(),
                passwordEncoder.encode(request.getUser_password()),
                request.getStream(),
                request.getStd_username(),
                request.getPhone_num()
        );
        user.setRole(Role.valueOf("LOCALUSER"));
        repository.save(user);
        var jwtToken = jwTservice.generateToken(user);
        return new AuhtenticationResponse(jwtToken);
    }

    public AuhtenticationResponse authenticate(AuthenticationRequest request) throws IOException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.finduserbyusername(request.getUsername());
        System.out.println(user);
        var jwtToken = jwTservice.generateToken(user);
        return new AuhtenticationResponse(jwtToken);
    }
}
