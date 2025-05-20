/*package trafego;

import cidade.Aresta;
import cidade.Vertice;
import cidade.Grafo;
import semaforo.listener.Listener;
import java.util.*;
import trafego.Veiculo;

public class GeradorVeiculos implements Listener {
    private final int tempoGerarVeiculos = 3; // Gera um veículo a cada 3 ticks
    private Grafo grafo; // Grafo para calcular caminho
    private List<Veiculo> veiculos; // Lista de veículos ativos

    public GeradorVeiculos(Grafo grafo) {
        this.grafo = grafo;
        this.veiculos = new ArrayList<>();
    }

    @Override
    public void aoDispararEvento(String tipoEvento, Object dados) {
        if ("TICK".equals(tipoEvento)) {
            int tempo = (int) dados;
            System.out.println("[GeradorVeiculos] Tick " + tempo + ": Verificando geração de veículos");

            if (tempo % tempoGerarVeiculos == 0) {
                Veiculo v = gerarVeiculo();
                veiculos.add(v);
                System.out.println("🚗 Veículo criado: ID=" + v.getId() + " | Origem: " + v.getOrigem() + " | Destino: " + v.getDestino());
            }
        }
    }

    public Veiculo gerarVeiculo() {
        List<Vertice> intersecoes = new ArrayList<>(grafo.getVertice().values());
        Vertice origem = intersecoes.get(new Random().nextInt(intersecoes.size()));
        Vertice destino = intersecoes.get(new Random().nextInt(intersecoes.size()));

        while (origem.equals(destino)) { // Evita origem = destino
            destino = intersecoes.get(new Random().nextInt(intersecoes.size()));
        }

        List<Vertice> caminho = (List<Vertice>) Dijkstra.encontrarMenorCaminho(grafo, origem, destino);
        return new Veiculo(UUID.randomUUID().toString(), origem.getId(), destino.getId(), caminho);
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
}
*/