import typeOfBroadcast.Advertising;
import typeOfBroadcast.Interview;
import typeOfBroadcast.Song;

public class Main {
    public static void main(String[] args) {
        Song first=new Song(5,"Ho-ho","Enemy");
        System.out.println(first);
        Advertising one = new Advertising(4,"MacDonald's");
        System.out.println(one);
        System.out.println(one.cost());
        Interview interview = new Interview(3,"Live","Malahov Andrey");
        System.out.println(interview);
        System.out.println(interview.cost());
    }
}
