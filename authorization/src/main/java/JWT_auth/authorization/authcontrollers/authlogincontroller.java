package JWT_auth.authorization.authcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
public class authlogincontroller {

    private final AuthenticationService authenticationService;

    public authlogincontroller(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register/user")
    public ResponseEntity<AuhtenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ){
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/login/user")
    public ResponseEntity<AuhtenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationrequest
            ) throws IOException {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationrequest));
    }
}
