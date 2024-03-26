package JWT_auth.authorization.authcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
public class teachercontroller {
    private final AuthenticationServiceTeacher authenticationService;
    public teachercontroller(AuthenticationServiceTeacher authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register/admin")
    public ResponseEntity<AuhtenticationResponse> register(
            @RequestBody RegisterRequestTeacher registerRequest
    ){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

        @PostMapping("/login/admin")
        public ResponseEntity<AuhtenticationResponse> authenticate(
                @RequestBody AuthenticationRequestTeacher authenticationrequest
        ) throws IOException {
            return ResponseEntity.ok(authenticationService.authenticate(authenticationrequest));
        }

}
