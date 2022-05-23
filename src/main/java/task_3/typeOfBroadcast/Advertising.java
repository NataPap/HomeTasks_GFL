package task_3.typeOfBroadcast;

public class Advertising extends TypeOfBroadcast {
    private final double price=5;

    public Advertising(int duration, String name) {
        super(duration, name);

    }

    @Override
    public double cost() {
        return price * duration*60;
    }

    @Override
    public String toString() {
        return "Name of advertising: " + name;
    }
}
