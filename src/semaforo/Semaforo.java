package semaforo;

public class Semaforo {
    private int tempoVerde, tempoAmarelo, tempoVermelho;
    private String estadoAtual;
    private int tempoAtual;

    public Semaforo(int verde, int amarelo, int vermelho) {
        this.tempoVerde = verde;
        this.tempoAmarelo = amarelo;
        this.tempoVermelho = vermelho;
        this.estadoAtual = "VERDE";
        this.tempoAtual = 0;
    }

    public void atualizarEstado() {
        tempoAtual++;
        if (estadoAtual.equals("VERDE") && tempoAtual >= tempoVerde) {
            estadoAtual = "AMARELO"; tempoAtual = 0;
        } else if (estadoAtual.equals("AMARELO") && tempoAtual >= tempoAmarelo) {
            estadoAtual = "VERMELHO"; tempoAtual = 0;
        } else if (estadoAtual.equals("VERMELHO") && tempoAtual >= tempoVermelho) {
            estadoAtual = "VERDE"; tempoAtual = 0;
        }
    }

    public void atualizar(int tempo) {
        for (int i = 0; i < tempo; i++) {
            atualizarEstado(); // Atualiza o estado repetidamente conforme o tempo passado
        }
    }

    public void exibirEstado() {
        System.out.println("🚦 Estado atual do semáforo: " + estadoAtual);
    }


    public String getEstadoAtual() { return estadoAtual; }
}
