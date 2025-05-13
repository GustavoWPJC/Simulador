package cidade;

public class Rua {
    public String id;
    public Sinal origem;
    public Sinal destino;
    public double comprimento;
    public double tempoViagem; // Tempo baseado na velocidade máxima

    public Rua(String id, Sinal origem, Sinal destino, double comprimento, double velocidade) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.comprimento = comprimento;
        this.tempoViagem = comprimento / velocidade; // Cálculo do tempo de deslocamento
    }
}
