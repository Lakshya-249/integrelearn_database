package JWT_auth.authorization.user;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "schedule_table")
public class Schedules {
    @Id
    private String sch_id;
    private LocalDate day;
    private Integer startTime;
    private Integer endTime;
    private String description;
    private String subject;
    private String tname;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher_User teacherUser;
    public Schedules() {
    }
    public Schedules(String sch_id, LocalDate day, Integer startTime,
                     Integer endTime, String description,String subject,
                     String tname) {
        this.sch_id = sch_id;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.subject = subject;
        this.tname = tname;
    }

    public String getSch_id() {
        return sch_id;
    }

    public void setSch_id(String sch_id) {
        this.sch_id = sch_id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher_User getTeacherUser() {
        return teacherUser;
    }

    public void setTeacherUser(Teacher_User teacherUser) {
        this.teacherUser = teacherUser;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
