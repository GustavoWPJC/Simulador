package Semaforo;

import java.util.List;

public class ControladorSemaforos {
    private List<Semaforo> semaforos;
    private int tempoSimulacao = 0;

    public ControladorSemaforos(List<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }

    public void aplicarControle() {
        System.out.println("✅ Controle de semáforos iniciado!");
        for (int i = 0; i < 10; i++) { // Simula 10 ciclos de trânsito
            atualizarSemaforos();
            tempoSimulacao += 5;
            try {
                Thread.sleep(2000); // Atualiza semáforos a cada 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizarSemaforos() {
        System.out.println("\n⏳ Tempo: " + tempoSimulacao + " segundos");
        for (Semaforo semaforo : semaforos) {
            semaforo.atualizar(tempoSimulacao);
            semaforo.exibirEstado();
        }
    }
}
