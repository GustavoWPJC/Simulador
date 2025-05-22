import cidade.CriadorGrafo;
import cidade.Grafo;
import semaforo.Semaforo;
import semaforo.ControladorSemaforos;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        try {
            // Caminho do JSON dentro do projeto
            String jsonPath = "cidade/JoqueiTeresinaPiauíBrazil.json";

            // Criar o grafo a partir do JSON
            Grafo grafo = CriadorGrafo.construirGrafo(jsonPath);

            //Exibir informações carregadas
            System.out.println("✅ Total de Vértices: " + grafo.getVertice().size());
            System.out.println("✅ Total de Arestas: " + grafo.getAresta().size());
            System.out.println("✅ Total de Semáforos: " + grafo.getSemaforos().size());

            //Exibir posição e direção dos semáforos
            for (Semaforo sem : grafo.getSemaforos()) {
                System.out.println("🚦 Semáforo ID " + sem.getIntersecaoId() + " na posição (" +
                        sem.getLatitude() + ", " + sem.getLongitude() + ")");
            }

            //Criar simulador e registrar controlador de semáforos
            Simulador simulador = new Simulador();
            ControladorSemaforos controlador = new ControladorSemaforos(grafo.getSemaforos());
            simulador.registrarListener(controlador);



            //Iniciar a simulação

            int tempoSimulacao = 10;
            simulador.iniciar(tempoSimulacao);



        } catch (Exception e) {
            System.out.println("❌ Erro ao carregar o JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
