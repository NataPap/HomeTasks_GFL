package Task_5.controllers;

import Task_5.entities.Producer;
import task_3.typeOfBroadcast.TypeOfBroadcast;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerController {

    public static Producer addProducer(String name, String country) {
       Producer producer=new Producer();
       producer.setName(name);
       producer.setCountry(country);
       return producer;
    }
}
