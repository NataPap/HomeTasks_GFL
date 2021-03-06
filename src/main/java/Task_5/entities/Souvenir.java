package Task_5.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import static Task_5.entities.Menu.in;
import static java.lang.Double.parseDouble;

public class Souvenir implements Serializable {
    private String name;
    private Producer producer;
    private LocalDate dateOfManufacture;
    private Double price;
    private static final long serialVersionUID = 2L;
    public Souvenir() {
    }

    public Souvenir(String name, Producer producer, LocalDate dateOfManufacture, Double price) {
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

    public LocalDate getDateOfManufacture() {
        return this.dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
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
        return "\nSouvenir{" +
                "name='" + name + '\'' +
                ", producer=" + producer +
                ", dateOfManufacture=" + dateOfManufacture +
                ", price=" + price +
                "} \n";

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
    public static Souvenir addSouvenir(String name, Producer producer, LocalDate dateOfManufacture, Double price) {
        Souvenir souvenir=new Souvenir();
        souvenir.setName(name);
        souvenir.setProducer(producer);
        souvenir.setDateOfManufacture(dateOfManufacture);
        souvenir.setPrice(price);
        return souvenir;
    }
    public static Souvenir editSouvenir(Souvenir souvenirSearch) {
        Souvenir souvenir=new Souvenir();
        souvenir.setName(souvenirSearch.getName());
        souvenir.setProducer(souvenirSearch.getProducer());
        souvenir.setDateOfManufacture(souvenirSearch.getDateOfManufacture());
        souvenir.setPrice(souvenirSearch.getPrice());
        System.out.print("Enter new name: ");
        String tmp = in.nextLine();
        if(tmp != null && !tmp.isEmpty()) {
            souvenir.setName(tmp);
        }
        System.out.print("Enter new name of producer: ");
        tmp = in.nextLine();
        if(tmp != null && !tmp.isEmpty()) {
            souvenir.getProducer().setName(tmp);
        }
        System.out.print("Enter new country of producer: ");
        tmp = in.nextLine();
        if(tmp != null && !tmp.isEmpty()) {
            souvenir.getProducer().setCountry(tmp);
        }
        System.out.print("Enter new date of manufacture: ");
        tmp = in.nextLine();
        if(tmp != null && !tmp.isEmpty()) {
            LocalDate dateTime = LocalDate.parse(tmp);
            souvenir.setDateOfManufacture(dateTime);
        }
        System.out.print("Enter new price: ");
        tmp = in.nextLine();
        if(tmp != null && !tmp.isEmpty()) {
            souvenir.setPrice(parseDouble(tmp));
        }
        return souvenir;
    }



}
