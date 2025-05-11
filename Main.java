import estruturas.Fila;

public class Main {
    public static void main(String[] args) {
        //Simulador simulador = new Simulador();
        //simulador.iniciar();

        Fila<String> fila = new Fila<String>();


fila.adicionarFinal("Vinicius");
        fila.adicionarFinal("Cecilia");


        fila.mostrar();

        fila.removerInicio();

        fila.mostrar();

    }
}