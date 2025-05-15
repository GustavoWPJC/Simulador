import java.util.ArrayList;
import java.util.List;
import Semaforo.Semaforo;

public class Sinal {
    private String id;
    private double latitude;
    private double longitude;
    private List<Rua> ruasConectadas;
    private Semaforo semaforo; // Semáforo opcional

    public Sinal(String id, double latitude, double longitude) {
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

    // 🔹 Método corrigido para verificar se o sinal possui semáforo
    public boolean temSemaforo() {
        return semaforo != null;
    }

    public boolean estaVerde() {
        return semaforo != null && semaforo.getCorAtual() == Semaforo.Cor.VERDE;
    }


    // 🔹 Correção no método de atualização do semáforo
    public void atualizarSemaforo(int tempo) {
        if (temSemaforo()) {
            semaforo.atualizar(tempo);
        }
    }

    public void exibirSemaforo() {
        if (temSemaforo()) {
            System.out.println("🚦 Sinal " + id + " está " + semaforo.getCorAtual());
        }
    }


}
