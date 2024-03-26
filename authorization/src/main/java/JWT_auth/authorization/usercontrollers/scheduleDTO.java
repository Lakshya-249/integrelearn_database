package JWT_auth.authorization.usercontrollers;

import java.time.LocalDate;

public class scheduleDTO {
    private String user;
    private String sch_id;
    private LocalDate day;
    private Integer startTime;
    private Integer endTime;
    private String description;

    public scheduleDTO() {
    }
    public scheduleDTO(String user, String sch_id, LocalDate day,
                       Integer startTime, Integer endTime, String description) {
        this.user = user;
        this.sch_id = sch_id;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
}
