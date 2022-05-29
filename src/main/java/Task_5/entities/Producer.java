package Task_5.entities;

import java.io.Serializable;
import java.util.Objects;

public class Producer implements Serializable {
    private String name;
    private String country;
    private static final long serialVersionUID = 2L;

    public Producer() {
    }

    public Producer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Objects.equals(name, producer.name) && Objects.equals(country, producer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
    public static Producer addProducer(String name, String country) {
        Producer producer=new Producer();
        producer.setName(name);
        producer.setCountry(country);
        return producer;
    }

}
