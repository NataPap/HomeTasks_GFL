package Task_5.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Souvenir implements Serializable {
    private String name;
    private Producer producer;
    private Date dateOfManufacture;
    private Double price;
    private static final long serialVersionUID = 2L;
    public Souvenir() {
    }

    public Souvenir(String name, Producer producer, Date dateOfManufacture, Double price) {
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Date getDateOfManufacture(Date dateOfManufacture) {
        return this.dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Souvenir souvenir = (Souvenir) o;
        return Objects.equals(name, souvenir.name)
                && Objects.equals(producer, souvenir.producer)
                && Objects.equals(dateOfManufacture, souvenir.dateOfManufacture)
                && Objects.equals(price, souvenir.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, producer, dateOfManufacture, price);
    }
    public static Souvenir addSouvenir(String name, Producer producer, Date dateOfManufacture, Double price) {
        Souvenir souvenir=new Souvenir();
        souvenir.setName(name);
        souvenir.setProducer(producer);
        souvenir.setDateOfManufacture(dateOfManufacture);
        souvenir.setPrice(price);
        return souvenir;
    }


}
