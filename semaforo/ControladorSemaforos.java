package semaforo;

import semaforo.listener.Listener;
import java.util.List;

public class ControladorSemaforos implements Listener {

    private List<Semaforo> semaforos;

    //Contrutor modificada para receber uma lista de semáforos
    public ControladorSemaforos(List<Semaforo> semaforos){
        this.semaforos = semaforos;
    }

    public void aplicarControle() {
        System.out.println("Controle de semáforos aplicado.");
    }

    @Override
    public void aoDispararEvento(String tipoEvento, Object dados) {
        if (tipoEvento.equals("TICK")) {
            int tempo = (int) dados;
            System.out.println("[Controlador] Verificando semáforos no minuto " + tempo);

            //atualiza e exibe o estado de cada semáforo
            for(Semaforo s : semaforos){
                s.atualizar(tempo);
                s.exibirEstado();
            }
        }
    }
}
