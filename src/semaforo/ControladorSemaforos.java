package semaforo;
import java.util.List;
import cidade.Intersecao;


public class ControladorSemaforos {
    private List<Intersecao> sinais;

    public ControladorSemaforos(List<Intersecao> sinais) {
        this.sinais = sinais;
    }

    public void aplicarControle() {
        for (int tempo = 0; tempo < 60; tempo += 5) {
            System.out.println("\n⏳ Tempo: " + tempo + " segundos");

            // Alterna estados dos semáforos nos cruzamentos
            for (Intersecao intersecao : sinais) {
                intersecao.atualizarSemaforo(tempo);
                System.out.println("🚦 Semáforo no sinal " + intersecao.getId() + " está " + intersecao.getSemaforo().getEstadoAtual());
            }

            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
