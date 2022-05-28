package Task_5.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Souvenirs implements Serializable {
    Map<String, String> producerMap = new HashMap<>();
    List<Souvenir> souvenirList = new ArrayList<>();
    private static final long serialVersionUID = 2L;

    public Souvenirs() {
    }

    public Souvenirs(Map<String, String> producerMap, List<Souvenir> souvenirList) {
        this.producerMap = producerMap;
        this.souvenirList = souvenirList;
    }

    public Map<String, String> getMap() {
        return producerMap;
    }

    public void setMap(Map<String, String> producerMap) {
        this.producerMap = producerMap;
    }

    public List<Souvenir> getSouvenirList() {
        return souvenirList;
    }

    public void setSouvenirList(List<Souvenir> souvenirList) {
        this.souvenirList = souvenirList;
    }
}
