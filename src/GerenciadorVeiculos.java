import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerenciadorVeiculos {
    private List<Veiculo> veiculos;
    private GrafoTransito grafo;

    public GerenciadorVeiculos(GrafoTransito grafo, List<Sinal> sinais) {
        this.grafo = grafo;
        veiculos = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Sinal inicio = sinais.get(new Random().nextInt(sinais.size()));
            veiculos.add(new Veiculo("V" + i, inicio));
        }
    }

    public void simularMovimento(Sinal destino) {
        for (int rodada = 0; rodada < 10; rodada++) {
            System.out.println("🚗 Rodada " + rodada);
            for (Veiculo veiculo : veiculos) {
                veiculo.mover(grafo, destino);
            }

            try {
                Thread.sleep(3000); // Simulação em tempo real
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
