package task_3.typeOfBroadcast;

public class Song extends TypeOfBroadcast  {
    private String singer;

    public Song(int duration, String name, String singer) {
        super(duration, name);
        this.singer = singer;
    }

    public Song(int duration, String name) {
        super(duration, name);
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String toString() {
        return "Singer: "+ singer+"; song: "+name;
    }

//    @Override
//    public void add(Song song,Broadcast broadcast) {
//
//        boolean b = duration + broadcast.getDuration() <= broadcast.getMaxDuration();
//        if(!b){
//            System.out.println("Adding is not possible due to exceeding the maximum broadcast time!");
//        }
//        else {
//            duration +=broadcast.getDuration();
//        }
//    }
}
