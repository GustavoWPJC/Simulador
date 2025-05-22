package trafego;

import cidade.Aresta;
import cidade.Grafo;
import cidade.Vertice;
import estruturas.FilaEncadeada;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkstra {

    public static FilaEncadeada<Vertice> encontrarMenorCaminho(Grafo grafo, Vertice origem, Vertice destino) {
        HashMap<Vertice, Double> distancias = new HashMap<>();
        HashMap<Vertice, Vertice> anteriores = new HashMap<>();
        HashSet<Vertice> visitados = new HashSet<>();
        PriorityQueue<Nodo> filaPrioridade = new PriorityQueue<>((a, b) -> Double.compare(a.distancia, b.distancia));

        for (Vertice v : grafo.getVertices().values()) {
            distancias.put(v, Double.POSITIVE_INFINITY);
            anteriores.put(v, null);
        }
        distancias.put(origem, 0.0);
        filaPrioridade.add(new Nodo(origem, 0.0));

        while (!filaPrioridade.isEmpty()) {
            Nodo atual = filaPrioridade.poll();
            if (visitados.contains(atual.vertice)) continue;
            visitados.add(atual.vertice);

            for (Aresta aresta : grafo.obterArestasDe(atual.vertice)) {
                Vertice vizinho = aresta.getDestino();
                if (!visitados.contains(vizinho)) {
                    double novaDistancia = distancias.get(atual.vertice) + aresta.getPeso();
                    if (novaDistancia < distancias.get(vizinho)) {
                        distancias.put(vizinho, novaDistancia);
                        anteriores.put(vizinho, atual.vertice);
                        filaPrioridade.add(new Nodo(vizinho, novaDistancia));
                    }
                }
            }
        }

        return construirCaminho(anteriores, destino);
    }

    private static FilaEncadeada<Vertice> construirCaminho(HashMap<Vertice, Vertice> anteriores, Vertice destino) {
        FilaEncadeada<Vertice> caminho = new FilaEncadeada<>();
        for (Vertice at = destino; at != null; at = anteriores.get(at)) {
            caminho.enfileirar(at);
        }
        return caminho;
    }

    private static class Nodo {
        Vertice vertice;
        double distancia;

        public Nodo(Vertice vertice, double distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }
    }
}
