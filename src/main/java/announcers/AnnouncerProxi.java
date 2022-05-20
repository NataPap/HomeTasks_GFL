package announcers;

import typeOfBroadcast.TypeOfBroadcast;

import java.util.Queue;

public class AnnouncerProxi implements Performance{
    private Performance performance=new Announcer();
    private String name;
    private String resume;
    private Queue<TypeOfBroadcast> typeOfBroadcasts;

    public AnnouncerProxi(String name, String resume, Queue<TypeOfBroadcast> typeOfBroadcasts) {
        this.performance = performance;
        this.name = name;
        this.resume = resume;
    }

    @Override
    public String perfomanceOfAnnouncer() {
        return "Hello, we are starting the broadcast.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Queue<TypeOfBroadcast> getTypeOfBroadcasts() {
        return typeOfBroadcasts;
    }

    public void setTypeOfBroadcasts(Queue<TypeOfBroadcast> typeOfBroadcasts) {
        this.typeOfBroadcasts = typeOfBroadcasts;
    }
}
