package typeOfBroadcast;

public abstract class TypeOfBroadcast {
    public int duration;
    public String name;

    public TypeOfBroadcast(int duration, String name) {
        this.duration = duration;
        this.name = name;
    }

    public abstract double cost();
    public abstract String toString();

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
