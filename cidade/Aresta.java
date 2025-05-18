package cidade;

public class Aresta {
    private Vertice origem;
    private Vertice destino;
    private int tempoTravessia;
    boolean sentidoUnico;

    public Aresta(Vertice origem, Vertice destino, int tempoTravessia, boolean sentidoUnico) {
        this.origem = origem;
        this.destino = destino;
        this.tempoTravessia = tempoTravessia;
        this.sentidoUnico = sentidoUnico;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public int getTempoTravessia() {
        return tempoTravessia;
    }

    @Override
    public String toString() {
        return "Aresta{" +
                "origem=" + origem +
                ", destino=" + destino +
                ", tempoTravessia=" + tempoTravessia +
                ", sentidoUnico=" + sentidoUnico +
                '}';
    }
}
/*
class Aresta {
    String id;
    Vertice origem, destino;
    double custo;
    boolean sentidoUnico;

    public Aresta(String id, Vertice origem, Vertice destino, double custo, boolean sentidoUnico) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;
        this.sentidoUnico = sentidoUnico;
    }

    @Override
    public String toString() {
        return "Aresta{id='" + id + "', origem=" + origem + ", destino=" + destino + ", custo=" + custo + ", sentidoUnico=" + sentidoUnico + "}";
    }
}
*/