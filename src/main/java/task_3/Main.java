package task_3;

import task_3.announcers.Announcer;
import task_3.announcers.AnnouncerProxi;
import task_3.announcers.Performance;
import task_3.radioStation.FirstBroadcast;
import task_3.radioStation.RadioStation;
import task_3.typeOfBroadcast.Advertising;
import task_3.typeOfBroadcast.Interview;
import task_3.typeOfBroadcast.Song;
import task_3.typeOfBroadcast.TypeOfBroadcast;

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

        Queue<TypeOfBroadcast> queue = new LinkedList<>();
        queue.add(secondSong);
        queue.add(firstAdvertising);
        queue.add(firstInterview);
        Performance performance=new Announcer("Skovoroda Den",5,queue);
        performance.perfomanceOfAnnouncer();
        Performance performance1=new AnnouncerProxi("Pupkin David","Two years worked in PanoramasStreet",queue);
        performance1.perfomanceOfAnnouncer();

    }
}
