package semaforo;

import semaforo.listener.Listener;
import java.util.List;
import java.util.*;

public class ControladorSemaforos implements Listener {

    private Map<String, List<Semaforo>> semaforosPorIntersecao;
    private final int cicloTotal = 20;

    //Contrutor modificada para receber uma lista de semáforos
    public ControladorSemaforos(List<Semaforo> semaforos){
        semaforosPorIntersecao = new HashMap<>();
        for (Semaforo s : semaforos) {
            semaforosPorIntersecao.computeIfAbsent(s.getIntersecaoId(), k -> new ArrayList<>()).add(s);
        }
    }


    public void aplicarControle() {
        System.out.println("Controle de semáforos aplicado.");
    }

    @Override
    public void aoDispararEvento(String tipoEvento, Object dados) {
        if ("TICK".equals(tipoEvento)) {
            int tempoGlobal = (int) dados;
            System.out.println("[Controlador] Tick " + tempoGlobal);

            // 🚦 Percorre todas as interseções para atualizar os semáforos
            for (Map.Entry<String, List<Semaforo>> entry : semaforosPorIntersecao.entrySet()) {
                String intersecao = entry.getKey();
                List<Semaforo> semaforos = entry.getValue();
                int tempoNoCiclo = tempoGlobal % cicloTotal;

                System.out.println("🔄 Atualizando semáforos na interseção " + intersecao);

                for (Semaforo s : semaforos) {
                    if ("A".equals(s.getGrupo())) {
                        if (tempoNoCiclo < 10) {    // Tick 0 a 9 → Verde
                            s.setCor(Semaforo.Cor.VERDE);
                        } else if (tempoNoCiclo < 12) { // Tick 10 a 11 → Amarelo
                            s.setCor(Semaforo.Cor.AMARELO);
                        } else {                  // Tick 12 a 19 → Vermelho
                            s.setCor(Semaforo.Cor.VERMELHO);
                        }
                    } else if ("B".equals(s.getGrupo())) {
                        if (tempoNoCiclo < 12) {    // Tick 0 a 11 → Vermelho
                            s.setCor(Semaforo.Cor.VERMELHO);
                        } else if (tempoNoCiclo < 18) { // Tick 12 a 17 → Verde
                            s.setCor(Semaforo.Cor.VERDE);
                        } else {                  // Tick 18 a 19 → Amarelo
                            s.setCor(Semaforo.Cor.AMARELO);
                        }
                    }
                    s.exibirEstado();
                }
            }
        }
    }
}
