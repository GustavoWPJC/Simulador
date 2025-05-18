package cidade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafo {
    public HashMap<String, Vertice> vertice = new HashMap<>();
    public List<Aresta> aresta = new ArrayList<>();

    public void adicionarVertice(Vertice v) {
        vertice.put(v.getId(), v);
    }

    public void adicionarAresta(Aresta a) {
        aresta.add(a);
    }

    public HashMap<String, Vertice> getVertice() {
        return vertice;
    }

    public void setVertice(HashMap<String, Vertice> vertice) {
        this.vertice = vertice;
    }

    public List<Aresta> getAresta() {
        return aresta;
    }

    public void setAresta(List<Aresta> aresta) {
        this.aresta = aresta;
    }
}
