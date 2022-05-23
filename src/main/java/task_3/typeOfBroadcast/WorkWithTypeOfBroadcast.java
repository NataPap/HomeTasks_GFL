package task_3.typeOfBroadcast;

import task_3.radioStation.Broadcast;

public interface WorkWithTypeOfBroadcast {
    Song createSong (TypeOfBroadcast typeOfBroadcast, Broadcast broadcast);
    Advertising createAdvertising (TypeOfBroadcast typeOfBroadcast, Broadcast broadcast);
    Interview createInterview (TypeOfBroadcast typeOfBroadcast, Broadcast broadcast);
}
