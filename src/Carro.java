import java.util.List;
import Semaforo.Semaforo;

public class Carro {
    private static int contadorId = 0;
    private int id;
    private Sinal origem;
    private Sinal destino;
    private List<Sinal> caminho;
    private int tempoEntrada;
    private int tempoSaida;
    private int posicaoAtual = 0; // posição atual na rota

    public Carro(Sinal origem, Sinal destino, List<Sinal> caminho, int tempoEntrada) {
        this.id = contadorId++;
        this.origem = origem;
        this.destino = destino;
        this.caminho = caminho;
        this.tempoEntrada = tempoEntrada;
        this.tempoSaida = -1; // ainda não chegou
    }

    public int getId() {
        return id;
    }

    public Sinal getOrigem() {
        return origem;
    }

    public Sinal getDestino() {
        return destino;
    }

    public List<Sinal> getCaminho() {
        return caminho;
    }

    public int getTempoEntrada() {
        return tempoEntrada;
    }

    public int getTempoSaida() {
        return tempoSaida;
    }

    public void setTempoSaida(int tempoSaida) {
        this.tempoSaida = tempoSaida;
    }

    public boolean chegouAoDestino() {
        return tempoSaida != -1;
    }

    public boolean podeAvancar() {
        if (posicaoAtual + 1 >= caminho.size()) return false; // Não há mais para onde avançar

        Sinal proximo = caminho.get(posicaoAtual + 1);
        Semaforo semaforoProximo = proximo.getSemaforo();

        // 🔹 Correção: Agora o carro só avança se o semáforo não existir ou estiver VERDE
        if (semaforoProximo != null) {
            if (semaforoProximo.getCorAtual() == Semaforo.Cor.VERMELHO || semaforoProximo.getCorAtual() == Semaforo.Cor.AMARELO) {
                return false; // O carro para se o semáforo estiver VERMELHO ou AMARELO
            }
        }

        return true; // Pode avançar se não há semáforo ou se ele está VERDE
    }




    public void moverSePossivel(int tempoAtual) {
        if (chegouAoDestino()) return;

        Sinal sinalAtual = caminho.get(posicaoAtual);
        Semaforo semaforoAtual = sinalAtual.getSemaforo();

        // 🚦 Verificação extra: Se houver semáforo e ele estiver VERMELHO, o carro deve parar
        if (semaforoAtual != null && semaforoAtual.getCorAtual() == Semaforo.Cor.VERMELHO) {
            System.out.println(this + " PARADO no sinal " + sinalAtual.getId() + " porque está VERMELHO!");
            return; // O carro **não** avança se o semáforo estiver vermelho
        }

        if (podeAvancar()) {
            posicaoAtual++;
            if (posicaoAtual == caminho.size() - 1) {
                tempoSaida = tempoAtual;
                System.out.println(this + " chegou ao destino no tempo " + tempoAtual);
            } else {
                System.out.println(this + " avançou para " + caminho.get(posicaoAtual).getId());
            }
        } else {
            System.out.println(this + " parado em " + caminho.get(posicaoAtual).getId());
        }
    }


    @Override
    public String toString() {
        return "Carro #" + id + " de " + origem.getId() + " para " + destino.getId();
    }
}
