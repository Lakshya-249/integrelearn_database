package JWT_auth.authorization.authcontrollers;

import java.time.LocalDate;

public class RegisterRequest {

    public RegisterRequest() {
    }

    public RegisterRequest(String firstname, String lastname, LocalDate date_of_Birth,
                           String email_id, String stream,
                           String user_password, String std_username, Long phone_num) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.Date_of_Birth = date_of_Birth;
        this.email_id = email_id;
        this.stream = stream;
        this.user_password = user_password;
        this.std_username = std_username;
        this.phone_num = phone_num;
    }

    private String firstname;
    private String lastname;
    private LocalDate Date_of_Birth;
    private String email_id;
    private String stream;
    private String user_password;
    private String std_username;
    private Long phone_num;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDate_of_Birth() {
        return Date_of_Birth;
    }

    public void setDate_of_Birth(LocalDate date_of_Birth) {
        Date_of_Birth = date_of_Birth;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }


    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getStd_username() {
        return std_username;
    }

    public void setStd_username(String std_username) {
        this.std_username = std_username;
    }

    public Long getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(Long phone_num) {
        this.phone_num = phone_num;
    }
}
