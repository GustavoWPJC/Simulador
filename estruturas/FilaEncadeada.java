package estruturas;

public class FilaEncadeada<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public FilaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    // Classe interna para os nós da fila
    private static class No<T> {
        T dado;
        No<T> proximo;

        No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public T obterPrimeiro() {
        return (primeiro != null) ? primeiro.dado : null;
    }


    // Enfileira um elemento no final
    public void enfileirar(T elemento) {
        No<T> novo = new No<>(elemento);
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
        tamanho++;
    }

    // Desenfileira e retorna o primeiro elemento
    public T desenfileirar() {
        if (primeiro == null) {
            return null;
        }
        No<T> atual = primeiro;
        primeiro = primeiro.proximo;
        if (primeiro == null) {
            ultimo = null;
        }
        tamanho--;
        return atual.dado;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }
}
