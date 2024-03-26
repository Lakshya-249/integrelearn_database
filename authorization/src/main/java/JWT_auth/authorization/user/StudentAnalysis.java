package JWT_auth.authorization.user;

import jakarta.persistence.*;

@Entity
@Table(name = "analysis_table")
public class StudentAnalysis {
    @Id
    private Integer as_id;
    private String subject;
    private Integer marks;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StudentAnalysis() {
    }
    public StudentAnalysis(Integer as_id, String subject, Integer marks) {
        this.as_id = as_id;
        this.subject = subject;
        this.marks = marks;
    }

    public Integer getAs_id() {
        return as_id;
    }
    public void setAs_id(Integer as_id) {
        this.as_id = as_id;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Integer getMarks() {
        return marks;
    }
    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}
