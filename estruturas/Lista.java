package estruturas;

public class Lista<TIPO> {
    private No<TIPO> head;
    private No<TIPO> tail;
    private int tamanho;


    public Lista(){
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

    public void adicionarFinal(int posicao, TIPO valor){
       No<TIPO> Novono = new No<TIPO>(valor);
       if(posicao == 0 || posicao > tamanho){
           System.out.println("Posição invalida!");
           return;
       }

       if (posicao != 0 || posicao < tamanho ){
           if(posicao ==  1 && head == null){
               head = Novono;
               tail = Novono;
           }else if(posicao == 1 && head != null){
               Novono.setProx(head);
               head = Novono;
           }
       }
    }
    public void removerInicio(){

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
