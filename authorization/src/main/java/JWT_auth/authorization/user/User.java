package JWT_auth.authorization.user;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Student_table_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String user_id;
    private String firstname;
    private String lastname;
    private LocalDate Date_of_Birth;

    @Column(unique = true)
    private String email_id;
    private String user_password;

    private String stream;

    @Column(unique = true)
    private String std_username;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Long phone_num;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<StudentAnalysis> studentAnalysis = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Doubts> doubts = new ArrayList<>();

    public Long getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(Long phone_num) {
        this.phone_num = phone_num;
    }

    public User() {
    }

    public User(String firstname, String lastname, LocalDate date_of_Birth,
                String email_id, String user_password, String stream,
                String std_username, Long phone_num) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.Date_of_Birth = date_of_Birth;
        this.stream = stream;
        this.email_id = email_id;
        this.user_password = user_password;
        this.std_username = std_username;
        this.phone_num = phone_num;
    }

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
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
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return user_password;
    }

    @Override
    public String getUsername() {
        return std_username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public List<StudentAnalysis> getStudentAnalysis() {
        return studentAnalysis;
    }
    public void setStudentAnalysis(List<StudentAnalysis> studentAnalysis) {
        this.studentAnalysis = studentAnalysis;
    }

    public List<Doubts> getDoubts() {
        return doubts;
    }

    public void setDoubts(List<Doubts> doubts) {
        this.doubts = doubts;
    }
}
