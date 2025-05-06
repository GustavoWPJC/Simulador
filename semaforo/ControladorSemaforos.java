package semaforo;

import semaforo.listener.Listener;

public class ControladorSemaforos implements Listener {

    Semaforo semaforo = new Semaforo(4, 2, 6);

    public void aplicarControle() {
        System.out.println("Controle de semáforos aplicado.");
    }

    @Override
    public void aoDispararEvento(String tipoEvento, Object dados) {
        if (tipoEvento.equals("TICK")) {
            int tempo = (int) dados;
            System.out.println("[Controlador] Verificando semáforos no minuto " + tempo);

            semaforo.atualizar(tempo);
            semaforo.exibirEstado();
        }
    }
}
