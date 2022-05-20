package Task_3.typeOfBroadcast;

import Task_3.radioStation.Broadcast;

public abstract class TypeOfBroadcast implements WorkWithTypeOfBroadcast{
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


    @Override
    public Song createSong(TypeOfBroadcast typeOfBroadcast, Broadcast broadcast) {
        return new Song(typeOfBroadcast.duration, typeOfBroadcast.name);
    }

    @Override
    public Advertising createAdvertising(TypeOfBroadcast typeOfBroadcast, Broadcast broadcast) {
        return new Advertising(typeOfBroadcast.duration, typeOfBroadcast.name);
    }

    @Override
    public Interview createInterview(TypeOfBroadcast typeOfBroadcast, Broadcast broadcast) {
        return new Interview(typeOfBroadcast.duration, typeOfBroadcast.name);
    }
}
