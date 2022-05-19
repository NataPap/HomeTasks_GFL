package radioStation;

import typeOfBroadcast.TypeOfBroadcast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FirstBroadcast extends Broadcast {


    public FirstBroadcast(int maxDuration) {
        super(maxDuration);
    }

    public FirstBroadcast(int maxDuration, Queue<TypeOfBroadcast> queue) {
        super(maxDuration, queue);
    }

    @Override
    public int totalDuration(int dur) {
        duration += dur;
        return duration;
    }

    @Override
    public Broadcast createBroadcast(int maxDuration) {

        return new FirstBroadcast(maxDuration);
    }

    @Override
    public void printQueue() {
        super.printQueue();
    }

    @Override
    public void updateBroadcast(int duration, Queue<TypeOfBroadcast> queue) {
        super.updateBroadcast(duration, queue);
    }

    @Override
    public void addTypeOfBroadcast(TypeOfBroadcast typeOfBroadcast) {
        int resDuration = totalDuration(typeOfBroadcast.duration);
        if (resDuration <= getMaxDuration()) {
            if (getQueue() != null) {
                getQueue().add(typeOfBroadcast);
                System.out.println("Added.");
            } else {
                Queue<TypeOfBroadcast> queue = new LinkedList<>();
                queue.add(typeOfBroadcast);
                System.out.println("Added.");
            }
            updateBroadcast(duration,getQueue());
        } else {
            System.out.println("Maximum duration exceeded.");
        }

    }


}




