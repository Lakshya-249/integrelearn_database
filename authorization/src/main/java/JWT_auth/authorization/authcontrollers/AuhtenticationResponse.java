package JWT_auth.authorization.authcontrollers;

public class AuhtenticationResponse {
    public AuhtenticationResponse() {
    }

    public AuhtenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
}
