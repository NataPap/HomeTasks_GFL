package announcers;

import typeOfBroadcast.TypeOfBroadcast;
import java.util.Queue;

public class Announcer implements Performance {

    private String name;
    private int experience;
    private Queue<TypeOfBroadcast> typeOfBroadcasts;

    public Announcer(String name, int experience,Queue<TypeOfBroadcast> typeOfBroadcasts) {
        this.name = name;
        this.experience = experience;
        this.typeOfBroadcasts=typeOfBroadcasts;
    }

    public Announcer() {
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Queue<TypeOfBroadcast> getTypeOfBroadcasts() {
        return typeOfBroadcasts;
    }

    public void setTypeOfBroadcasts(Queue<TypeOfBroadcast> typeOfBroadcasts) {
        this.typeOfBroadcasts = typeOfBroadcasts;
    }
}
