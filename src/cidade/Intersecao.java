package cidade;

import semaforo.Semaforo;
import java.util.ArrayList;
import java.util.List;


public class Intersecao {
    private String id;
    private double latitude;
    private double longitude;
    private List<Rua> ruasConectadas;
    private Semaforo semaforo; // Semáforo opcional

    public Intersecao(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ruasConectadas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void conectarRua(Rua rua) {
        ruasConectadas.add(rua);
    }

    public List<Rua> getRuasConectadas() {
        return ruasConectadas;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }
    public Semaforo getSemaforo() {
        return semaforo;
    }

    public boolean temSemaforo() {
        return semaforo != null;
    }

    public void atualizarSemaforo(int tempo) {
        if (temSemaforo()) semaforo.atualizar(tempo);
    }

    public void exibirSemaforo() {
        if (temSemaforo()) semaforo.exibirEstado();
    }



}
