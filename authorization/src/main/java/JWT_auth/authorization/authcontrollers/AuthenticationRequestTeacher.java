package JWT_auth.authorization.authcontrollers;

public class AuthenticationRequestTeacher {
    private String email;
    private String password;

    public AuthenticationRequestTeacher(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthenticationRequestTeacher() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
