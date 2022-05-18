package typeOfBroadcast;

public class Song extends TypeOfBroadcast {
    private String singer;

    public Song(int duration, String name, String singer) {
        super(duration, name);
        this.singer = singer;
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String toString() {
        return "Singer: "+ singer+"; song: "+name;
    }
}
