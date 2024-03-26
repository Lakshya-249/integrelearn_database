package JWT_auth.authorization;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Democontroller {

    @GetMapping("/demo")
    public String sayhello(HttpServletResponse response){
        return "hello from the controllery";
    }
}
