package JWT_auth.authorization.usercontrollers;

public class analysisDTO {
    private String user;
    private Integer as_id;
    private String subject;
    private Integer marks;

    public analysisDTO() {
    }

    public analysisDTO(String user, Integer as_id, String subject, Integer marks) {
        this.user = user;
        this.as_id = as_id;
        this.subject = subject;
        this.marks = marks;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
