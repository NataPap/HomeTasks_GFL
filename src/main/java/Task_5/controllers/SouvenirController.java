package Task_5.controllers;

import Task_5.entities.Producer;
import Task_5.entities.Souvenir;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SouvenirController {
    public static Souvenir addSouvenir(String name, Producer producer, Date dateOfManufacture, Double price) {
        Souvenir souvenir=new Souvenir();
        souvenir.setName(name);
        souvenir.setProducer(producer);
        souvenir.setDateOfManufacture(dateOfManufacture);
        souvenir.setPrice(price);
        return souvenir;
    }
}
