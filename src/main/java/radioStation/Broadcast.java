package radioStation;

import typeOfBroadcast.TypeOfBroadcast;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Broadcast implements RadioStation {

    int duration = 0;
    private int maxDuration;
    private Queue<TypeOfBroadcast> queue=new LinkedList<>();

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Queue<TypeOfBroadcast> getQueue() {
        return queue;
    }

    public void setQueue(Queue<TypeOfBroadcast> queue) {
        this.queue = queue;
    }

    public Broadcast(int maxDuration){
        this.maxDuration=maxDuration;
    }

    public Broadcast(int maxDuration, Queue<TypeOfBroadcast> queue) {
        this.maxDuration = maxDuration;
        this.queue = queue;
    }

    @Override
    public Broadcast createBroadcast(int maxDuration) {

        return new FirstBroadcast(maxDuration);
    }



    @Override
    public void printQueue() {
        for (Iterator<TypeOfBroadcast> iterator = queue.iterator(); iterator.hasNext(); ) {
            TypeOfBroadcast next = iterator.next();
        }
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.print(getQueue().poll() + "\n");
        }
    }

    @Override
    public void updateBroadcast(int duration, Queue<TypeOfBroadcast> queue) {
         setQueue(queue);
         setDuration(duration);
    }

}

