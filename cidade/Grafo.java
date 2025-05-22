package cidade;

import semaforo.Semaforo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafo {
    private HashMap<String, Vertice> vertices = new HashMap<>();
    private List<Aresta> arestas = new ArrayList<>();
    private List<Semaforo> semaforos = new ArrayList<>();

    public void adicionarVertice(Vertice v) {
        vertices.put(v.getId(), v);
    }

    public void adicionarAresta(Aresta a) {
        if (!vertices.containsKey(a.getOrigem().getId()) || !vertices.containsKey(a.getDestino().getId())) {
            throw new IllegalArgumentException("❌ Erro: Tentando adicionar aresta com vértices inexistentes!");
        }
        arestas.add(a);
        a.getOrigem().adicionarAresta(a);
    }

    public void adicionarSemaforo(Semaforo semaforo) {
        semaforos.add(semaforo);
    }

    public HashMap<String, Vertice> getVertices() {
        return new HashMap<>(vertices);
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public List<Aresta> obterArestasDe(Vertice vertice) {
        return vertice.getArestas();
    }

    public List<Semaforo> getSemaforos() {
        List<Semaforo> listaSemaforos = new ArrayList<>(semaforos);
        for (Vertice v : vertices.values()) {
            listaSemaforos.addAll(v.getSemaforos());
        }
        return listaSemaforos;
    }
}
