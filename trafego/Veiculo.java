package trafego;

public class Veiculo {
    private String id;
    private String origem;
    private String destino;

    public Veiculo(String id, String origem, String destino) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }
}