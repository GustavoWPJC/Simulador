package trafego;
import semaforo.listener.Listener;


public class GeradorVeiculos implements Listener {
    private final int tempoGerarVeiculos = 3;

    public void aoDispararEvento(String tipoEvento, Object dados) {
        if (tipoEvento.equals("TICK")) {
            int tempo = (int) dados;

            int gerar = tempo % tempoGerarVeiculos;

            System.out.println("[Controlador] Verificando geração de Veículos no minuto " + tempo);
            if(gerar == 0){
                System.out.println("Veiculo gerado");
            }
        }
    }

    public void gerar() {
        System.out.println("Veículos gerados aleatoriamente.");
    }

}