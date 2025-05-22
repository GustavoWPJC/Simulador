package cidade;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String id;
    private double latitude, longitude;
    private List<Aresta> arestas = new ArrayList<>();
    private List<semaforo.Semaforo> semaforos = new ArrayList<>();

    public Vertice(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() { return id; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public List<semaforo.Semaforo> getSemaforos() { return semaforos; }

    public void adicionarSemaforo(semaforo.Semaforo s) {
        semaforos.add(s);
    }

    public void adicionarAresta(Aresta a) {
        arestas.add(a);
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    @Override
    public String toString() {
        return "Intersecao{" + "id='" + id + "', latitude=" + latitude + ", longitude=" + longitude + '}';
    }
}
