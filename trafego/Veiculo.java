package trafego;
import semaforo.Semaforo;



public class Veiculo {
    private String id;
    private double latitude;
    private double longitude;
    private double velocidade;
    private String destino;
    private boolean parado;

    public Veiculo(String id, double latitude, double longitude, double velocidade, String destino) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.velocidade = velocidade;
        this.destino = destino;
        this.parado = false;
    }

    public void mover() {
        if (!parado) {
            this.latitude += velocidade * 0.0001; // Simulação de movimento
            this.longitude += velocidade * 0.0001;
        }
    }

    public void verificarSemaforo(Semaforo semaforo) {
        if (semaforo.getCorAtual() == Semaforo.Cor.VERMELHO) {
            parado = true;
        } else {
            parado = false;
        }
    }

    public void exibirEstado() {
        System.out.println("🚗 Veículo " + id + " está em (" + latitude + ", " + longitude + ") " +
                (parado ? "🚦 PARADO" : "🚗 MOVENDO") + " → Destino: " + destino);
    }
}
