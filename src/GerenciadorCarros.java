import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GerenciadorCarros {
    private List<Carro> carros;
    private GrafoTransito grafo;

    public GerenciadorCarros(GrafoTransito grafo, List<Sinal> sinais) {
        if (sinais == null || sinais.isEmpty()) {
            throw new IllegalArgumentException("A lista de sinais está vazia! Impossível gerar carros.");
        }

        this.grafo = grafo;
        carros = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Sinal inicio = sinais.get(new Random().nextInt(sinais.size()));
            Sinal destino = sinais.get(new Random().nextInt(sinais.size())); // Definir destino aleatório
            List<Sinal> caminho = new ArrayList<>(); // Aqui pode entrar a lógica do Dijkstra
            carros.add(new Carro(inicio, destino, caminho, 0));
        }
    }

    public void simularMovimento(Sinal destino) {
        if (destino == null) {
            throw new IllegalArgumentException("O destino do carro não pode ser nulo.");
        }

        for (int rodada = 0; rodada < 10; rodada++) {
            System.out.println("🚗 Rodada " + rodada);
            for (Carro carro : carros) {
                carro.moverSePossivel(rodada);
            }

            try {
                Thread.sleep(3000); // Simulação em tempo real
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
