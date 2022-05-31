package Task_5.entities;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Souvenirs implements Serializable {
    private List<Souvenir> souvenirList = new ArrayList<>();
    private static final long serialVersionUID = 2L;

    public Souvenirs() {
    }

    public Souvenirs(List<Souvenir> souvenirList) {
        this.souvenirList = souvenirList;
    }

    public List<Souvenir> getSouvenirList() {
        return souvenirList;
    }

    public void setSouvenirList(List<Souvenir> souvenirList) {
        this.souvenirList = souvenirList;
    }
    @Override
    public String toString() {
        return "Souvenirs {" +
                " souvenirList = " + souvenirList +
                '}';
    }

    public void addSouvenirInList (Souvenir souvenir) {
        if(!souvenirList.contains(souvenir)){
            souvenirList.add(souvenir);
        }
    }

    public void writerInFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("souvenirList.dat"))) {
            oos.writeObject(souvenirList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void readerFile() {
    try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("souvenirList.dat"))) {
        souvenirList=(List<Souvenir>)input.readObject();
        System.out.println(souvenirList.toString());
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}
