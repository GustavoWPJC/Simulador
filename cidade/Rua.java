package cidade;

public class Rua {
    private Intersecao origem;
    private Intersecao destino;
    private int tempoTravessia;

    public Rua(Intersecao origem, Intersecao destino, int tempo) {
        this.origem = origem;
        this.destino = destino;
        this.tempoTravessia = tempo;
    }

    public int getTempoTravessia() {
        return tempoTravessia;
    }
}