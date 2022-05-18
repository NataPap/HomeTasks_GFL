package radioStation;

import typeOfBroadcast.TypeOfBroadcast;

import java.util.Queue;

public class FirstBroadcast extends Broadcast {

    public FirstBroadcast(int maxDuration, Queue<TypeOfBroadcast> queue) {
        super(maxDuration, queue);
    }

    @Override
    public int totalDuration(int dur) {
        duration+=dur;
       return duration;
    }



}




