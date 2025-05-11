package Semaforo;

public class Semaforo {
    public enum Cor {
        VERDE, AMARELO, VERMELHO
    }

    private Cor corAtual;
    private int tempoVerde;
    private int tempoAmarelo;
    private int tempoVermelho;

    public Semaforo(int verde, int amarelo, int vermelho) {
        this.tempoVerde = verde;
        this.tempoAmarelo = amarelo;
        this.tempoVermelho = vermelho;
        this.corAtual = Cor.VERMELHO; // Começa vermelho
    }

    public void atualizar(int tempo) {
        int cicloTotal = tempoVerde + tempoAmarelo + tempoVermelho;
        int tempoNoCiclo = tempo % cicloTotal;

        if (tempoNoCiclo < tempoVerde) {
            corAtual = Cor.VERDE;
        } else if (tempoNoCiclo < tempoVerde + tempoAmarelo) {
            corAtual = Cor.AMARELO;
        } else {
            corAtual = Cor.VERMELHO;
        }
    }

    public Cor getCorAtual() {
        return corAtual;
    }

    public void exibirEstado() {
        System.out.println("🚦 Semáforo está " + corAtual);
    }
}
