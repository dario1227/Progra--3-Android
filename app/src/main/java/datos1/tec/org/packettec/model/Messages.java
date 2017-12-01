package datos1.tec.org.packettec.model;


public class Messages {
    private String content = "";
    private String special = "";
    private String userName = "";

    public Messages() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String body) {
        this.content = body;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
