package cidade;

public class Aresta {
    private Vertice origem;
    private Vertice destino;
    private double tempoTravessia;
    private boolean sentidoUnico;

    public Aresta(Vertice origem, Vertice destino, double tempoTravessia, boolean sentidoUnico) {
        this.origem = origem;
        this.destino = destino;
        this.tempoTravessia = tempoTravessia;
        this.sentidoUnico = sentidoUnico;
    }

    public Vertice getOrigem() { return origem; }
    public Vertice getDestino() { return destino; }
    public double getTempoTravessia() { return tempoTravessia; }

    public double getPeso() {
        return tempoTravessia;
    }

    @Override
    public String toString() {
        return "Aresta{origem=" + origem + ", destino=" + destino + ", tempoTravessia=" + tempoTravessia + ", sentidoUnico=" + sentidoUnico + '}';
    }
}
