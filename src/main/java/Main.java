import radioStation.Broadcast;
import radioStation.FirstBroadcast;
import radioStation.RadioStation;
import typeOfBroadcast.Advertising;
import typeOfBroadcast.Interview;
import typeOfBroadcast.Song;
import typeOfBroadcast.TypeOfBroadcast;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Song firstSong=new Song(5,"Ho-ho","Enemy");
        System.out.println(firstSong);
        Advertising firstAdvertising = new Advertising(4,"MacDonald's");
        System.out.println(firstAdvertising);
        System.out.println(firstAdvertising.cost());
        Interview firstInterview = new Interview(3,"Live","Malahov Andrey");
        System.out.println(firstInterview);
        System.out.println(firstInterview.cost());
        RadioStation radioStation ;
        radioStation=new FirstBroadcast(15);
        //radioStation.printQueue(queue);
        radioStation.addTypeOfBroadcast(firstAdvertising);
        radioStation.addTypeOfBroadcast(firstInterview);
        radioStation.addTypeOfBroadcast(firstSong);
        Song secondSong=new Song(5,"You'll See","Madonna");
        radioStation.addTypeOfBroadcast(secondSong);
        radioStation.printQueue();

    }
}
