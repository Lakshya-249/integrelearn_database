package JWT_auth.authorization.user;

import jakarta.persistence.*;

@Entity
@Table(name = "doubt_table")
public class Doubts {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String doubtId;
    private String doubtdesc;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDoubtId() {
        return doubtId;
    }

    public void setDoubtId(String doubtId) {
        this.doubtId = doubtId;
    }

    public String getDoubtdesc() {
        return doubtdesc;
    }

    public void setDoubtdesc(String doubtdesc) {
        this.doubtdesc = doubtdesc;
    }

    public Doubts() {
    }

    public Doubts(String doubtId, String doubtdesc) {
        this.doubtId = doubtId;
        this.doubtdesc = doubtdesc;
    }

    public Doubts(String doubtId, String doubtdesc, String username) {
        this.doubtId = doubtId;
        this.doubtdesc = doubtdesc;
        this.user = new User(); // Initialize user object
        this.user.setStd_username(username); // Set username
        this.user.setRole(Role.valueOf("LOCALUSER"));
    }
}
