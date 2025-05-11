class Rua {
    public String id;
    public Sinal origem;
    public Sinal destino;
    public double comprimento;
    public double tempoViagem;
    public double velocidadeMaxima;

    public Rua(String id, Sinal origem, Sinal destino, double comprimento, double tempoViagem, double velocidadeMaxima) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.comprimento = comprimento;
        this.tempoViagem = tempoViagem;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    @Override
    public String toString() {
        return "Rua id='" + id + "', origem=" + origem.id + ", destino=" + destino.id +
                ", comprimento=" + comprimento + ", velMax=" + velocidadeMaxima + " km/h}";
    }
}
