package trafego;

import cidade.Grafo;
import cidade.Vertice;
import listener.Listener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorVeiculos implements Listener {
    private List<Veiculo> veiculos = new ArrayList<>();
    private Grafo grafo;
    private Random random = new Random();
    private int veiculoCounter = 1; // Contador para gerar IDs únicos para os veículos

    public GeradorVeiculos(Grafo grafo) {
        this.grafo = grafo;
    }

    // Método para gerar um novo veículo com um ID e velocidade informados
    public void gerarVeiculo(String id, double velocidade) {
        List<Vertice> vertices = new ArrayList<>(grafo.getVertices().values());
        if (vertices.size() < 2) {
            System.out.println("❌ Não há vértices suficientes para criar um veículo!");
            return;
        }

        Vertice origem = vertices.get(random.nextInt(vertices.size()));
        Vertice destino;
        do {
            destino = vertices.get(random.nextInt(vertices.size()));
        } while (origem.equals(destino)); // Garante que origem e destino sejam diferentes

        Veiculo veiculo = new Veiculo(id, velocidade, origem, destino, grafo);
        veiculos.add(veiculo);
        System.out.println("🚗 Veículo " + id + " gerado: Origem: " + origem.getId() + " → Destino: " + destino.getId());
    }

    // Atualiza o movimento e o estado dos veículos
    private void atualizarVeiculos() {
        for (Veiculo veiculo : veiculos) {
            veiculo.mover(); // Dentro do mover(), o veículo checa os semáforos e decide se avança ou não
            veiculo.exibirEstado();
        }
    }

    // Esse método é chamado a cada "TICK" pelo simulador
    @Override
    public void aoDispararEvento(String tipoEvento, Object dados) {
        if ("TICK".equals(tipoEvento)) {
            int tick = (int) dados;
            // A cada 3 ticks, gera um novo veículo
            if (tick % 3 == 0) {
                String id = "V" + (veiculoCounter++);
                // Aqui usamos uma velocidade arbitrária, por exemplo, 10.0
                gerarVeiculo(id, 10.0);
            }
            // Atualiza o estado de todos os veículos
            atualizarVeiculos();
        }
    }
}
