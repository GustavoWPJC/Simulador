package cidade;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String id;
    double latitude, longitude;
    private List<semaforo.Semaforo> semaforos = new ArrayList<>();


    public Vertice(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void adicionarSemaforo(semaforo.Semaforo s){
        semaforos.add(s);
    }
    public List<semaforo.Semaforo> getSemaforos(){
        return semaforos;
    }


    @Override
    public String toString() {
        return "Intersecao{" + "id='" + id + '\'' + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }
}

