package Task_5.entities;

import javafx.util.converter.LocalDateTimeStringConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
                    "Choose transaction number from 1 to 5: \n" +
                    "Adding a souvenir - 1\n" +
                    "Editing souvenir data - 2\n" +
                    "Removing a souvenir - 3\n" +
                    "View souvenirs and producers - 4\n" +
                    "Exit - 5\n");
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
                case 5:
                    System.out.println("Good bay!");
                    break;
                default:
                    System.out.println("\"Invalid number.Please try again.\n");
                    break;
            }
        } while (select!=5);
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
        Producer producer = new Producer();
        Double price;
        System.out.println();
        System.out.print("Enter name of souvenir: ");
        name = in.nextLine();
        System.out.print("Enter or choice producer: ");
        producer = addProducerMenu();
        System.out.print("Enter date of manufacture in the format \"yyyy-MM-dd\": ");
        date = in.nextLine();
        LocalDate dateTime = LocalDate.parse(date);
        System.out.print("Enter price: ");
        price = Double.parseDouble(in.nextLine());
        Souvenir newSouvenir = addSouvenir(name, producer, dateTime, price);
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
        if(souvenirSearch!=null) {
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
        System.out.print("Enter name of producer: ");
        String name = in.nextLine();
        System.out.print("Enter country of producer: ");
        String countryProducer = in.nextLine();
        Souvenir souvenirRemove=new Souvenir();
        do{
            souvenirRemove= souvenirs.getSouvenirList().stream()
                .filter(e -> e.getProducer().getName().equals(name) && e.getProducer().getCountry().equals(countryProducer))
                .findFirst()
                .orElse(null);
            if(souvenirRemove != null) {
                int index = souvenirs.getSouvenirList().indexOf(souvenirRemove);
                souvenirs.getSouvenirList().remove(index);
            } else {
                System.out.println("The object is missing from the database with the specified search parameters:\n" +
                    " name of souvenir - " +name+ "; name of producer - "+countryProducer);
            }
        } while (souvenirRemove != null);

        }


    public static void viewMenu (){
        int select;
        do {
            System.out.print("What operations will we perform?\n" +
                    "Choose transaction number from 1 to 9: \n" +
                    "View all souvenirs - 1\n" +
                    "View all producers - 2\n" +
                    "View souvenirs by producer - 3\n" +
                    "View souvenirs by country - 4\n" +
                    "View producers by price - 5\n" +
                    "View producers and their souvenirs - 6\n" +
                    "View producers of a particular souvenir of a particular year - 7\n" +
                    "View souvenirs by year - 8\n" +
                            "Exit - 9\n"


                    );
            select = Integer.parseInt(in.nextLine());
            switch (select) {
                case 1:
                    System.out.println(souvenirs.toString());
                    break;
                case 2:
                    viewAllProducers();
                    break;
                case 3:
                    viewSouvenirsByProducer ();
                    break;
                case 4:
                    souvenirsByCountry();
                    break;
                case 5:
                    producerByPrice();
                    break;
                case 6:
                    viewProducersAndTheySouvenirs();
                    break;
                case 7:
                    viewProducersOfSouvenirOfYear();
                    break;
                case 8:
                    viewSouvenirByYear();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("\"Invalid number.Please try again.\n");
                    break;
            }
        } while (select !=9);
    }

    private static void viewAllProducers() {
        List<Producer>producerList=souvenirs.getSouvenirList().stream()
                .map(Souvenir::getProducer)
                .distinct()
                .collect(Collectors.toList());
        if(producerList.isEmpty()){
            System.out.println("null");
        }
        System.out.println(producerList);
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
        System.out.println(souvenirsByProducer);
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
        System.out.println(souvenirsByProducer);
    }

    private static void producerByPrice() {
        System.out.print("Enter name of souvenir: ");
        String nameSouvenir = in.nextLine();
        System.out.print("Enter maximum purchase price: ");
        double maxPrice = Double.parseDouble(in.nextLine());
        List<Producer> producerList = souvenirs.getSouvenirList().stream()
                .filter(e -> e.getName().equals(nameSouvenir)&& e.getPrice()<=maxPrice)
                .map(e->e.getProducer())
                .distinct()
                .collect(Collectors.toList());
        if(producerList.isEmpty()){
            System.out.println("There are no producers.");
        }
        System.out.println(producerList);
    }
    private static void viewProducersAndTheySouvenirs() {
        Map <Producer, List<Souvenir>> producerList = souvenirs.getSouvenirList().stream()
                .collect(Collectors.groupingBy(Souvenir::getProducer));
        System.out.println(producerList);
    }
    private static void viewProducersOfSouvenirOfYear() {
        System.out.print("Enter name of souvenir: ");
        String nameSouvenir = in.nextLine();
        System.out.print("Enter year of manufacture: ");
        int yearManufacture = Integer.parseInt(in.nextLine());

        List<Producer> producerList=souvenirs.getSouvenirList().stream()
               .filter(e->e.getDateOfManufacture().getYear()==yearManufacture && e.getName().equals(nameSouvenir))
                .map(e->e.getProducer())
                .distinct()
                .collect(Collectors.toList());;
        if(producerList.isEmpty()){
            System.out.println("There are no producers.");
        }
        System.out.println(producerList);
    }

    private static void viewSouvenirByYear() {
        Map <Integer, List<Souvenir>> yearList = souvenirs.getSouvenirList().stream()
                .collect(Collectors.groupingBy(e->e.getDateOfManufacture().getYear()));
        System.out.println(yearList);
    }

}
