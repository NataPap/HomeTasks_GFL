package Task_5.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Task_5.entities.Producer.addProducer;
import static Task_5.entities.Souvenir.addSouvenir;
import static Task_5.entities.Souvenir.editSouvenir;


public class Menu {
    static Scanner in = new Scanner((System.in));
    static Souvenirs souvenirs = new Souvenirs();

    public static void menu() {
        souvenirs.readerFile();
        int select;
        do {
            System.out.print("Welcome to the souvenir base. What operations will we perform?\n" +
                    "Choose transaction number from 1 to 4: \n" +
                    "Adding a souvenir - 1\n" +
                    "Editing souvenir data - 2\n" +
                    "Removing a souvenir - 3\n" +
                    "View souvenirs and producers - 4 :\n");
            select = Integer.parseInt(in.nextLine());
            switch (select) {
                case 1:
                    Souvenir newSouvenir = addSouvenirMenu();
                    souvenirs.addSouvenirInList(newSouvenir);
                    System.out.println(souvenirs.toString());
                    souvenirs.writerInFile();
                    break;
                case 2:
                    editSouvenirMenu();
                    System.out.println(souvenirs.toString());
                    souvenirs.writerInFile();
                    break;
                case 3:
                    removeSouvenirMenu();
                    System.out.println(souvenirs.toString());
                    souvenirs.writerInFile();
                    break;
                case 4:
                    viewMenu();
                    break;
                default:
                    System.out.println("Некоректний вибір");
                    break;
            }
        } while (select < 1 && select > 4);
    }

    public static Producer addProducerMenu() {
        String name, country;
        System.out.println();
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.print("Enter country: ");
        country = in.nextLine();
        Producer producer = new Producer();
        producer = addProducer(name, country);
        return producer;
    }

    public static Souvenir addSouvenirMenu() {
        String name, date;
        Date dateManufactures = new Date();
        Producer producer = new Producer();
        Double price;
        System.out.println();
        System.out.print("Enter name of souvenir: ");
        name = in.nextLine();
        System.out.print("Enter or choice producer: ");
        producer = addProducerMenu();
        System.out.print("Enter date of manufacture in the format \"yyyy-MM-dd\": ");
        date = in.nextLine();
        try {
            SimpleDateFormat dateOfManufacture = new SimpleDateFormat("yyyy-MM-dd");
            dateManufactures = dateOfManufacture.parse(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format " + date);
        }
        System.out.print("Enter price: ");
        price = Double.parseDouble(in.nextLine());
        Souvenir newSouvenir = addSouvenir(name, producer, dateManufactures, price);
        return newSouvenir;
    }

    public static void editSouvenirMenu() {
        System.out.print("Enter name of souvenir: ");
        String name = in.nextLine();
        System.out.print("Enter name of producer: ");
        String nameProducer = in.nextLine();
        Souvenir souvenirSearch = new Souvenir();
        souvenirSearch= souvenirs.getSouvenirList().stream()
                .filter(e -> e.getName().equals(name) && e.getProducer().getName().equals(nameProducer))
                .findFirst()
                .orElse(null);
        if(souvenirs != null) {
            int index = souvenirs.getSouvenirList().indexOf(souvenirSearch);
            souvenirSearch = editSouvenir(souvenirSearch);
            souvenirs.getSouvenirList().get(index).setName(souvenirSearch.getName());
            souvenirs.getSouvenirList().get(index).setProducer(souvenirSearch.getProducer());
            souvenirs.getSouvenirList().get(index).setDateOfManufacture(souvenirSearch.getDateOfManufacture());
            souvenirs.getSouvenirList().get(index).setPrice(souvenirSearch.getPrice());
        } else {
            System.out.println("The object is missing from the database with the specified search parameters:\n" +
                    " name of souvenir - " +name+ "; name of producer - "+nameProducer);
        }
    }

    public static void removeSouvenirMenu() {
        System.out.print("Enter name of souvenir: ");
        String name = in.nextLine();
        System.out.print("Enter name of producer: ");
        String nameProducer = in.nextLine();
        Souvenir souvenirRemove = new Souvenir();
        souvenirRemove= souvenirs.getSouvenirList().stream()
                .filter(e -> e.getName().equals(name) && e.getProducer().getName().equals(nameProducer))
                .findFirst()
                .orElse(null);
        if(souvenirRemove != null) {
            int index = souvenirs.getSouvenirList().indexOf(souvenirRemove);
            souvenirs.getSouvenirList().remove(index);
        } else {
            System.out.println("The object is missing from the database with the specified search parameters:\n" +
                    " name of souvenir - " +name+ "; name of producer - "+nameProducer);
        }
    }

    public static void viewMenu (){
        int select;
        do {
            System.out.print("What operations will we perform?\n" +
                    "Choose transaction number from 1 to 4: \n" +
                    "View all souvenirs - 1\n" +
                    "View all producers - 2\n" +
                    "View souvenirs by producer - 3\n" +
                    "View souvenirs - 4 :\n");
            select = Integer.parseInt(in.nextLine());
            switch (select) {
                case 1:
                    System.out.println(souvenirs.toString());
                    break;
                case 2:

                    break;
                case 3:
                    viewSouvenirsByProducer ();
                    break;
                case 4:
                    souvenirsByCountry();
                    break;
                case 5:
                    souvenirsByCountry();
                    break;
                default:
                    System.out.println("Некоректний вибір");
                    break;
            }
        } while (select < 1 && select > 4);
    }



    public static void viewSouvenirsByProducer () {
        System.out.print("Enter name of producer: ");
        String nameProducer = in.nextLine();
        System.out.print("Enter country of producer: ");
        String countryProducer = in.nextLine();
        List<Souvenir> souvenirsByProducer = souvenirs.getSouvenirList().stream()
                .filter(e -> e.getProducer().getName().equals(nameProducer) && e.getProducer().getCountry().equals(countryProducer))
                .collect(Collectors.toList());
        if(souvenirsByProducer.isEmpty()){
            System.out.println("There are no souvenirs from the specified producer.");
        }
        System.out.println(souvenirsByProducer.toString());

    }
    private static void souvenirsByCountry() {
        System.out.print("Enter country of producer: ");
        String countryProducer = in.nextLine();
        List<Souvenir> souvenirsByProducer = souvenirs.getSouvenirList().stream()
                .filter(e -> e.getProducer().getCountry().equals(countryProducer))
                .collect(Collectors.toList());
        if(souvenirsByProducer.isEmpty()){
            System.out.println("There are no souvenirs from the specified producer.");
        }
        System.out.println(souvenirsByProducer.toString());

    }


//    public Producer manufacturersChoice (String name, String country) {
//        Producer producer=new Producer();
//        return producer;
//    }

}
