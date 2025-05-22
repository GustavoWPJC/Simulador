package trafego;

import cidade.Vertice;
import cidade.Grafo;
import estruturas.FilaEncadeada;
import semaforo.Semaforo;

public class Veiculo {
    private String id;
    private double velocidade;
    private Vertice posicaoAtual;
    private FilaEncadeada<Vertice> caminho;
    private boolean parado;

    public Veiculo(String id, double velocidade, Vertice origem, Vertice destino, Grafo grafo) {
        this.id = id;
        this.velocidade = velocidade;
        this.posicaoAtual = origem;
        this.parado = false;
        // Calcula o caminho utilizando o algoritmo de Dijkstra
        this.caminho = Dijkstra.encontrarMenorCaminho(grafo, origem, destino);
    }

    public void mover() {
        // Primeiro, verifica se na interseção atual há semáforo(s).
        if (posicaoAtual.getSemaforos() != null && !posicaoAtual.getSemaforos().isEmpty()) {
            boolean semaforoVermelho = false;
            // Percorre todos os semáforos presentes nesta interseção.
            for (Semaforo sem : posicaoAtual.getSemaforos()) {
                // Se algum semáforo estiver vermelho, o veículo deve parar.
                if (sem.getCorAtual() == Semaforo.Cor.VERMELHO) {
                    semaforoVermelho = true;
                    break;
                }
            }
            if (semaforoVermelho) {
                parado = true;
                System.out.println("Veículo " + id + " está parado no semáforo vermelho na interseção " + posicaoAtual.getId());
                return;
            }
        }
        // Se não houve semáforos ou se todos estiverem verdes, prossegue.
        parado = false;
        if (!caminho.estaVazia()) {
            posicaoAtual = caminho.desenfileirar(); // Avança para o próximo vértice do caminho
            System.out.println("Veículo " + id + " moveu para " + posicaoAtual.getId());
        } else {
            System.out.println("Veículo " + id + " chegou ao destino final.");
        }
    }

    public void parar() {
        parado = true;
    }

    public void continuar() {
        parado = false;
    }

    public void exibirEstado() {
        String proximo = (caminho.obterPrimeiro() != null) ? caminho.obterPrimeiro().getId() : "destino final";
        System.out.println("🚗 Veículo " + id + " está em " + posicaoAtual.getId()
                + (parado ? " 🚦 PARADO" : " → MOVENDO para " + proximo));
    }
}
