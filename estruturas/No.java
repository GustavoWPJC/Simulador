package estruturas;

public class No<TIPO> {
    private TIPO valor;
    private No<TIPO> prox;

    public No(TIPO valor){
        this.valor = valor;
    }


    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public No<TIPO> getProx() {
        return prox;
    }

    public void setProx(No<TIPO> prox) {
        this.prox = prox;
    }

}
