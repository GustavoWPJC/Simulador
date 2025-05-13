/*import cidade.GrafoTransito;
import cidade.Sinal;

import java.util.List; // Para listas

public class Veiculo {
    private String id;
    private Sinal localizacaoAtual;

    public Veiculo(String id, Sinal inicio) {
        this.id = id;
        this.localizacaoAtual = inicio;
    }

    public void mover(GrafoTransito grafo, Sinal destino) {
        System.out.println("[Veículo " + id + "] Calculando menor caminho para " + destino.getId() + "...");

        List<Sinal> caminho = Dijkstra.encontrarMenorCaminho(grafo, localizacaoAtual, destino);

        for (Sinal proximoSinal : caminho) {
            if (proximoSinal.temSemaforo() && !proximoSinal.getSemaforo().getCorAtual().equals(semaforo.Cor.VERDE)) {
                System.out.println("[Veículo " + id + "] 🚦 Aguardando semáforo verde em " + proximoSinal.getId());
                return;
            }

            localizacaoAtual = proximoSinal;
            System.out.println("[Veículo " + id + "] ➡ Moveu para " + localizacaoAtual.getId());
        }

        System.out.println("[Veículo " + id + "] 🏁 Chegou ao destino!");
    }
}
*/