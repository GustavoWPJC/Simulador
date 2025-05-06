import semaforo.ControladorSemaforos;

public class Main {
    public static void main(String[] args) {
        /*Simulador simulador = new Simulador();
         *simulador.iniciar();
         */

        Simulador sim = new Simulador();
        sim.registrarListener(new ControladorSemaforos());
        sim.iniciar();
    }
}