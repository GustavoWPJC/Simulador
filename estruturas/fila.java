package estruturas;

public class fila<T> {
    private No<T> ultimo;
    private No<T> primeiro;
    private int tamanho;

    public fila() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adicionar(T valor){
        No<T> novo = new No<>(valor);
        if (primeiro == null){
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
        tamanho++;
    }

    public T sair(){
        if (primeiro == null) {
            return null;
        }
        No<T> atual = primeiro;
        primeiro = primeiro.proximo;
        if (primeiro == null) {
            ultimo = null;
        }
        tamanho--;
        return atual.valor;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }
}
