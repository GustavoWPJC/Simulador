/*package trafego;

import cidade.Vertice;
import semaforo.Semaforo;
import java.util.List;
import java.util.Map;

public class Veiculo {
    private String id;
    private String origem;
    private String destino;
    private List<String> caminho; // Lista de interseções no trajeto
    private int posicaoAtual; // Índice da posição atual no caminho

    public Veiculo(String id, String origem, String destino, List<Vertice> caminho) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.posicaoAtual = 0; // Começa na primeira interseção do caminho
    }

    // 🚦 Método para tentar avançar
    public boolean mover(Map<String, Semaforo> semaforos) {
        if (posicaoAtual < caminho.size() - 1) {
            String proximaIntersecao = caminho.get(posicaoAtual + 1);

            // Verifica se há um semáforo na interseção e se está verde
            if (semaforos.containsKey(proximaIntersecao) && semaforos.get(proximaIntersecao).getCorAtual() == Semaforo.Cor.VERMELHO) {
                System.out.println("🚦 Veículo " + id + " PARADO no semáforo vermelho na interseção " + proximaIntersecao);
                return false;
            }

            // Se não houver semáforo ou estiver verde, o veículo avança
            posicaoAtual++;
            System.out.println("🚗 Veículo " + id + " avançou para " + caminho.get(posicaoAtual));
            return true;
        } else {
            System.out.println("✅ Veículo " + id + " chegou ao destino!");
            return false;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(int posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }
}
*/