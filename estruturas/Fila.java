package estruturas;

public class Fila<TIPO> {
    private No<TIPO> head;
    private No<TIPO> tail;
    private int tamanho;


    public Fila(){
        this.tamanho = 0;
    }
    public No<TIPO> getHead() {
        return head;
    }

    public void setHead(No<TIPO> head) {
        this.head = head;
    }

    public No<TIPO> getTail() {
        return tail;
    }

    public void setTail(No<TIPO> tail) {
        this.tail = tail;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionarFinal(TIPO valor){
        No<TIPO> Novono = new No<TIPO>(valor);
        if(head == null){
            head = Novono;
            tail = Novono;
        }else{
            tail.setProx(Novono);
            tail = Novono;
        }

        tamanho++;

    }
    public void removerInicio(){
        if(head == tail){
            head = null;
            tail = null;
        }else{
            No<TIPO> atual = head;
            System.out.println("removido: " + head.getValor());
            head = atual.getProx();
            atual.setProx(null);
        }
        tamanho--;

    }

    public void mostrar(){
        No atual = head;
        while(atual != null){
            System.out.print(atual.getValor() +  "---> ");
            atual = atual.getProx();
        }
        System.out.println("");
    }
}
