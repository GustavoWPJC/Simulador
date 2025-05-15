package cidade;

public class Rua {
    public String id;
    public Intersecao origem;
    public Intersecao destino;
    public double comprimento;
    public double tempoViagem; // Tempo baseado na velocidade máxima

    public Rua(String id, Intersecao origem, Intersecao destino, double comprimento, double velocidade) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.comprimento = comprimento;
        this.tempoViagem = comprimento / velocidade; // Cálculo do tempo de deslocamento
    }
}
