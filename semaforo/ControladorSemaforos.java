package semaforo;

import listener.Listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorSemaforos implements Listener {
    private Map<String, List<Semaforo>> semaforosPorIntersecao;
    private final int cicloTotal = 20;
    private final int tempoAmarelo = 3;

    public ControladorSemaforos(List<Semaforo> semaforos) {
        semaforosPorIntersecao = new HashMap<>();

        for (Semaforo s : semaforos) {
            semaforosPorIntersecao
                    .computeIfAbsent(s.getIntersecaoId(), k -> new java.util.ArrayList<>())
                    .add(s);
        }
    }

    @Override
    public void aoDispararEvento(String tipoEvento, Object dados) {
        if ("TICK".equals(tipoEvento)) {
            int tempoGlobal = (int) dados;
            System.out.println("[Controlador] Tick " + tempoGlobal);

            for (Map.Entry<String, List<Semaforo>> entry : semaforosPorIntersecao.entrySet()) {
                List<Semaforo> semaforos = entry.getValue();

                int tempoNoCiclo = tempoGlobal % cicloTotal;

                // Alternância de grupos com a nova lógica baseada em direção
                boolean grupo1Verde = tempoNoCiclo < (cicloTotal / 2) - tempoAmarelo;
                atualizarCruzamento(semaforos, grupo1Verde);
            }
        }
    }

    private void atualizarCruzamento(List<Semaforo> semaforos, boolean grupo1Verde) {
        for (Semaforo s : semaforos) {
            if (s.getDirecao().equals("forward") || s.getDirecao().equals("backward")) {
                s.setCor(grupo1Verde ? Semaforo.Cor.VERDE : Semaforo.Cor.VERMELHO);
            } else {
                s.setCor(!grupo1Verde ? Semaforo.Cor.VERDE : Semaforo.Cor.VERMELHO);
            }
            s.exibirEstado();
        }
    }

}
