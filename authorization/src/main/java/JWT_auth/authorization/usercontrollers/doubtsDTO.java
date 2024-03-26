package JWT_auth.authorization.usercontrollers;

public class doubtsDTO {
    private String username;
    private String doubtdesc;

    public doubtsDTO() {
    }

    public doubtsDTO(String username, String doubtdesc) {
        this.username = username;
        this.doubtdesc = doubtdesc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDoubtdesc() {
        return doubtdesc;
    }

    public void setDoubtdesc(String doubtdesc) {
        this.doubtdesc = doubtdesc;
    }
}
