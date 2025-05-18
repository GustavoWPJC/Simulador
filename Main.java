
import cidade.CriadorGrafo;
import cidade.Grafo;
import cidade.Vertice;
import semaforo.Semaforo;
import semaforo.ControladorSemaforos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {


        try {
            // Caminho do JSON dentro do projeto
            String jsonPath = "cidade/teresina1.json"; // Certifique-se do caminho correto

            // Criar o grafo a partir do JSON
            Grafo grafo = CriadorGrafo.construirGrafo(jsonPath);

            // Verificar se os vértices e arestas foram corretamente carregados
            System.out.println("Total de Vértices: " + grafo.vertice.size());
            System.out.println("Total de Arestas: " + grafo.aresta.size());

            // Crie os semáforos para cada interseção: se queremos, por exemplo, 2 semáforos por interseção
            List<Semaforo> todosSemaforos = new ArrayList<>();


            for(Vertice v : grafo.getVertice().values()){

                // Supondo que cada interseção tenha dois semáforos com offsets diferentes:
                int offset1 = (int)(Math.random() * 5); // offset entre 0 e 4
                int offset2 = (int)(Math.random() * 5);
                Semaforo sem1 = new Semaforo(v.getId() + "_1",4,2,6, offset1);
                Semaforo sem2 = new Semaforo(v.getId() + "_2",4,2,6, offset2);
                v.adicionarSemaforo(sem1);
                v.adicionarSemaforo(sem2);
                todosSemaforos.add(sem1);
                todosSemaforos.add(sem2);

            }
            // Criar o simulador e registrar o controlador de semáforos
            Simulador simulador = new Simulador();
            ControladorSemaforos ctrlSemaforos = new ControladorSemaforos(todosSemaforos);
            simulador.registrarListener(ctrlSemaforos);

            // Iniciar a simulação
            simulador.iniciar();


        } catch (Exception e) {
            System.out.println("Erro ao carregar o JSON: " + e.getMessage());
            e.printStackTrace(); // Para depuração
        }
    }
}