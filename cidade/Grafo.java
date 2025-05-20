package cidade;

import semaforo.Semaforo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafo {
    private HashMap<String, Vertice> vertices = new HashMap<>();
    private List<Aresta> arestas = new ArrayList<>();
    private List<Semaforo> semaforos = new ArrayList<>();

    // 🔹 Adicionar vértice ao grafo
    public void adicionarVertice(Vertice v) {
        vertices.put(v.getId(), v);
    }

    // 🔹 Adicionar aresta ao grafo (somente se vértices existirem)
    public void adicionarAresta(Aresta a) {
        if (vertices.containsKey(a.getOrigem().getId()) && vertices.containsKey(a.getDestino().getId())) {
            arestas.add(a);
        } else {
            System.out.println("❌ Erro: Tentando adicionar aresta com vértice inexistente!");
        }
    }

    // 🔹 Adicionar semáforo ao grafo
    public void adicionarSemaforo(Semaforo semaforo) {
        semaforos.add(semaforo);
    }

    // 🔹 Retornar cópia do mapa de vértices
    public HashMap<String, Vertice> getVertice() {
        return new HashMap<>(vertices);
    }

    // 🔹 Retornar lista de arestas
    public List<Aresta> getAresta() {
        return arestas;
    }

    // 🔹 Retornar lista de semáforos (evitando valores nulos)
    public List<Semaforo> getSemaforos() {
        List<Semaforo> listaSemaforos = new ArrayList<>();
        for (Vertice v : vertices.values()) {
            if (v.getSemaforos() != null) {
                listaSemaforos.addAll(v.getSemaforos());
            }
        }
        listaSemaforos.addAll(semaforos);
        return listaSemaforos;
    }
}
