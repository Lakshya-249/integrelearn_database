package JWT_auth.authorization.authcontrollers;

import java.time.LocalDate;

public class RegisterRequestTeacher {
    public RegisterRequestTeacher() {
    }

    public RegisterRequestTeacher(String firstname, String lastname, LocalDate date_of_birth,
                                  String qualification, LocalDate joining_date, String email,
                                  String t_password,Integer experience,String subject) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.date_of_birth = date_of_birth;
        this.Qualification = qualification;
        this.joining_date = joining_date;
        this.email = email;
        this.t_password = t_password;
        this.Experience = experience;
        this.subject = subject;
    }
    private String firstname;
    private String lastname;
    private LocalDate date_of_birth;
    private String Qualification;
    private LocalDate joining_date;
    private String email;
    private Integer Experience;
    private String t_password;
    private String subject;

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

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        this.Qualification = qualification;
    }

    public LocalDate getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(LocalDate joining_date) {
        this.joining_date = joining_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public Integer getExperience() {
        return Experience;
    }

    public void setExperience(Integer experience) {
        this.Experience = experience;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
