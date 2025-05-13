package semaforo;
import java.util.List;
import cidade.Sinal;


public class ControladorSemaforos {
    private List<Sinal> sinais;

    public ControladorSemaforos(List<Sinal> sinais) {
        this.sinais = sinais;
    }

    public void aplicarControle() {
        for (int tempo = 0; tempo < 60; tempo += 5) {
            System.out.println("\n⏳ Tempo: " + tempo + " segundos");

            // Alterna estados dos semáforos nos cruzamentos
            for (Sinal sinal : sinais) {
                sinal.atualizarSemaforo(tempo);
                System.out.println("🚦 Semáforo no sinal " + sinal.getId() + " está " + sinal.getSemaforo().getEstadoAtual());
            }

            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
