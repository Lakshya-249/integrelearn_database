package JWT_auth.authorization.authcontrollers;

import JWT_auth.authorization.config.JWTservice;
import JWT_auth.authorization.user.Role;
import JWT_auth.authorization.user.TeacherUserRepository;
import JWT_auth.authorization.user.Teacher_User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationServiceTeacher {

    private final TeacherUserRepository repository;
    private final JWTservice jwTservice;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceTeacher(TeacherUserRepository repository, JWTservice jwTservice, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.jwTservice = jwTservice;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
    public AuhtenticationResponse register(RegisterRequestTeacher request){
        Teacher_User user = new Teacher_User(
                request.getFirstname(),
                request.getLastname(),
                request.getDate_of_birth(),
                request.getQualification(),
                request.getJoining_date(),
                request.getEmail(),
                passwordEncoder.encode(request.getT_password()),
                request.getExperience(),
                request.getSubject()
        );
        user.setRole(Role.valueOf("ADMIN"));
        repository.save(user);
        var jwtToken = jwTservice.generateToken(user);
        return new AuhtenticationResponse(jwtToken);
    }

    public AuhtenticationResponse authenticate(AuthenticationRequestTeacher request) throws IOException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.finduserbyemail(request.getEmail());
        System.out.println(user);
        var jwtToken = jwTservice.generateToken(user);
        return new AuhtenticationResponse(jwtToken);
    }

}
