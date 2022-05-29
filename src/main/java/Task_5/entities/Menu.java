package Task_5.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static Task_5.entities.Producer.addProducer;
import static Task_5.entities.Souvenir.addSouvenir;

public class Menu {
    static Scanner in = new Scanner((System.in));
    public static void menu() {
        Souvenirs souvenirs=new Souvenirs();
        int select;
        do {
            System.out.print("Welcome to the souvenir base. What operations will we perform?\n" +
                    "Choose transaction number from 1 to 4: \n" +
                    "Adding a souvenir - 1\n" +
                    "Editing souvenir data - 2\n" +
                    "Removing a souvenir - 3\n" +
                    "View souvenirs - 4 :\n");
            select = Integer.parseInt(in.nextLine());
            switch (select) {
                case 1:
                    Souvenir newSouvenir=addSouvenirMenu();
                    souvenirs.addSouvenirInList(newSouvenir);
                    System.out.println(souvenirs.toString());
                    souvenirs.writerInFile();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    souvenirs.readerFile();
                    break;
                default:
                    System.out.println("Некоректний вибір");
                    break;
            }
        } while (select < 1 && select > 4);
    }
    public static Producer addProducerMenu(){
        String name, country;
        System.out.println();
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.print("Enter country: ");
        country = in.nextLine();
        Producer producer=new Producer();
        producer=addProducer(name,country);
        return producer;
    }
    public static Souvenir addSouvenirMenu() {
        String name, date;
        Date dateManufactures = new Date();
        Producer producer=new Producer();
        Double price;
        System.out.println();
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.print("Enter or choice producer: ");
        producer=addProducerMenu();
        System.out.print("Enter date of manufacture in the format \"yyyy-MM-dd\": ");
        date=in.nextLine();
        try {
            SimpleDateFormat dateOfManufacture=new SimpleDateFormat ("yyyy-MM-dd");
            dateManufactures = dateOfManufacture.parse(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format " + date);
        }
        System.out.print("Enter price: ");
        price = Double.parseDouble(in.nextLine());
        Souvenir newSouvenir= addSouvenir(name,producer,dateManufactures,price);
        return newSouvenir;
    }

//    public Producer manufacturersChoice (String name, String country) {
//        Producer producer=new Producer();
//        return producer;
//    }

}