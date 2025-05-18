package semaforo;

public class Semaforo {

    public enum Cor {
        VERDE, AMARELO, VERMELHO
    }

    private String intersecaoId;
    private int tempoVerde;
    private int tempoAmarelo;
    private int tempoVermelho;
    private int offset;
    private Cor corAtual;

    public Semaforo(String intersecaoId, int verde, int amarelo, int vermelho, int offset) {
        this.intersecaoId = intersecaoId;
        this.tempoVerde = verde;
        this.tempoAmarelo = amarelo;
        this.tempoVermelho = vermelho;
        this.offset = offset;
        this.corAtual = Cor.VERDE;
    }

    public void atualizar(int tempo) {
        int cicloTotal = tempoVerde + tempoAmarelo + tempoVermelho;
        //Considera o offset para o ciclo não comece do zeo para todos os semáforos
        int tempoNoCiclo = (tempo + offset) % cicloTotal;

        if (tempoNoCiclo < tempoVerde) {
            corAtual = Cor.VERDE;
        } else if (tempoNoCiclo < tempoVerde + tempoAmarelo) {
            corAtual = Cor.AMARELO;
        } else {
            corAtual = Cor.VERMELHO;
        }
    }

    // Método para exibir o ID da interseção
    public void exibirEstado() {
        System.out.println("Semáforo da interseção " + intersecaoId + " está " + corAtual);
    }
}
