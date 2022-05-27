package Task_5;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Souvenir implements Serializable {
    private String name;
    private Producer producer;
    private SimpleDateFormat dateOfManufacture = new SimpleDateFormat ("yyyy-MM-dd");
    private Double price;
    private static final long serialVersionUID = 2L;
    public Souvenir() {
    }

    public Souvenir(String name, Producer producer, SimpleDateFormat dateOfManufacture, Double price) {
        this.name = name;
        this.producer = producer;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Souvenir{" +
                "name='" + name + '\'' +
                ", producer=" + producer +
                ", dateOfManufacture=" + dateOfManufacture +
                ", price=" + price +
                '}';
    }
}
