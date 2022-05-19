package radioStation;

import typeOfBroadcast.TypeOfBroadcast;

import java.util.Queue;

public interface RadioStation {
    Broadcast createBroadcast(int maxDuration);
    public void printQueue();
    public void addTypeOfBroadcast(TypeOfBroadcast typeOfBroadcast);
    public void updateBroadcast(int duration, Queue<TypeOfBroadcast> queue);
    public int totalDuration(int duration);
}
