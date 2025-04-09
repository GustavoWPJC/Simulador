package semaforo;

public class Semaforo {
    private int tempoVerde;
    private int tempoAmarelo;
    private int tempoVermelho;

    public Semaforo(int verde, int amarelo, int vermelho) {
        this.tempoVerde = verde;
        this.tempoAmarelo = amarelo;
        this.tempoVermelho = vermelho;
    }

    public void exibirEstado() {
        System.out.println("Semáforo em execução.");
    }
}