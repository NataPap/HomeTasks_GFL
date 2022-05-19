package typeOfBroadcast;

import radioStation.Broadcast;

public abstract class TypeOfBroadcast {
    public int duration;
    public String name;

    public TypeOfBroadcast(int duration, String name) {
        this.duration = duration;
        this.name = name;
    }

    public abstract double cost();
    public abstract String toString();

    public void add(TypeOfBroadcast typeOfBroadcast, Broadcast broadcast) {
        boolean b = typeOfBroadcast.duration + broadcast.getDuration() <= broadcast.getMaxDuration();
        if(!b){
            System.out.println("Adding is not possible due to exceeding the maximum broadcast time!");
        }
        else {
            typeOfBroadcast.duration +=broadcast.getDuration();
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
