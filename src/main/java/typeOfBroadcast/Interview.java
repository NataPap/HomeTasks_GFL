package typeOfBroadcast;

public class Interview extends TypeOfBroadcast {
    private String interviewer;
    private final double price=30;


    public Interview(int duration, String name, String interviewer) {
        super(duration, name);
        this.interviewer = interviewer;
    }

    public Interview(int duration, String name) {
        super(duration, name);
    }

    @Override
    public double cost() {
        return price * duration;
    }

    @Override
    public String toString() {
        return "Interviewer: "+ interviewer+"; name of interview: "+name;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public double getPrice() {
        return price;
    }
}
