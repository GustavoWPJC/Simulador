package estruturas;

public class Pilha<T> {
    private No<T> topo;
    private int tamanho;

    // Classe interna para representar os nós da pilha
    private static class No<T> {
        T dado;
        No<T> proximo;

        No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    // Construtor
    public Pilha() {
        topo = null;
        tamanho = 0;
    }

    // Empilha um elemento
    public void empilhar(T elemento) {
        No<T> novo = new No<>(elemento);
        novo.proximo = topo;
        topo = novo;
        tamanho++;
    }

    // Desempilha o elemento do topo
    public T desempilhar() {
        if (estaVazia()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        T elemento = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return elemento;
    }

    // Retorna o elemento no topo da pilha, sem removê-lo
    public T topo() {
        if (estaVazia()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return topo.dado;
    }

    // Verifica se a pilha está vazia
    public boolean estaVazia() {
        return topo == null;
    }

    // Retorna o número de elementos na pilha
    public int tamanho() {
        return tamanho;
    }

    // Limpa todos os elementos da pilha
    public void limpar() {
        topo = null;
        tamanho = 0;
    }
}
