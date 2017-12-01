package datos1.tec.org.packettec.model;


import java.util.ArrayList;

public class Conversations {

    private String name = "";
    private String time = "";
    private String content = "";
    private ArrayList<Conversations> conversations = new ArrayList<>();

    public Conversations() {

    }

    //getting content value
    public String getContent() {
        return content;
    }

    //setting content value
    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
