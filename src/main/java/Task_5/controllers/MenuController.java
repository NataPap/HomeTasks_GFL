package Task_5.controllers;


import Task_5.entities.Producer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Double.parseDouble;


public class MenuController {
    static Scanner in = new Scanner((System.in));
    public static Producer addProducerMenu(){
        String name, country;
        System.out.println();
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.print("Enter country: ");
        country = in.nextLine();
        Producer producer=new Producer();
        producer=ProducerController.addProducer(name,country);
        return producer;
    }
    public static void addSouvenirMenu() {
        String name, date;
        Date dateManufactures = new Date();
        Producer producer=new Producer();
        Double price;
        System.out.println();
        System.out.print("Enter name: ");
        name = in.nextLine();
        System.out.print("Enter or choice country: ");
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
        SouvenirController.addSouvenir(name,producer,dateManufactures,price);
    }

    public Producer manufacturersChoice (String name, String country) {
        Producer producer=new Producer();
        return producer;
    }

}
