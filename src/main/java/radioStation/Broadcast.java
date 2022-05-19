package radioStation;

import typeOfBroadcast.TypeOfBroadcast;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Queue;

public abstract class Broadcast {

    int duration=0;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int maxDuration;

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    private Queue<TypeOfBroadcast> queue;

    public Queue<TypeOfBroadcast> getQueue() {
        return queue;
    }

    public void setQueue(Queue<TypeOfBroadcast> queue) {
        this.queue = queue;
    }

    public Broadcast( int maxDuration, Queue<TypeOfBroadcast> queue) {
        this.maxDuration = maxDuration;
        this.queue = queue;
    }

    public abstract int totalDuration(int duration);

    public void PrintQueue() {
        for (Iterator<TypeOfBroadcast> iterator = queue.iterator(); iterator.hasNext(); ) {
            TypeOfBroadcast next = iterator.next();
            System.out.print(next + " ");
        }
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }


}
