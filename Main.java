import cidade.CriadorGrafo;
import cidade.Grafo;
import semaforo.Semaforo;
import semaforo.ControladorSemaforos;
import trafego.GeradorVeiculos;


public class Main {
    public static void main(String[] args) {
        try {
            // Caminho do JSON contendo o grafo (ajuste conforme a localização do arquivo)
            String jsonPath = "cidade/JoqueiTeresinaPiauíBrazil.json";

            // Criar o grafo a partir do JSON
            Grafo grafo = CriadorGrafo.construirGrafo(jsonPath);

            // Exibir informações carregadas
            System.out.println("✅ Total de Vértices: " + grafo.getVertices().size());
            System.out.println("✅ Total de Arestas: " + grafo.getArestas().size());
            System.out.println("✅ Total de Semáforos: " + grafo.getSemaforos().size());

            // Exibir posição dos semáforos
            for (Semaforo sem : grafo.getSemaforos()) {
                System.out.println("🚦 Semáforo ID " + sem.getIntersecaoId() + " na posição (" +
                        sem.getLatitude() + ", " + sem.getLongitude() + ")");
            }

            // Criar o simulador
            Simulador simulador = new Simulador();

            // Criar e registrar o controlador de semáforos (o listener deve ser conforme o exemplo que você enviou)
            ControladorSemaforos controlador = new ControladorSemaforos(grafo.getSemaforos());
            simulador.registrarListener(controlador);

            // Criar e registrar o gerador de veículos, que também atualizará os veículos a cada tick.
            // Veja a classe GeradorVeiculos abaixo.
            GeradorVeiculos gerador = new GeradorVeiculos(grafo);
            simulador.registrarListener(gerador);

            // Gerar veículos iniciais para dar início à simulação (ex.: 5 veículos)
            /*for (int i = 1; i <= 5; i++) {
                // Gera veículos com velocidade arbitrária (exemplo: 10.0)
                gerador.gerarVeiculo("V" + i, 10.0);
            }*/


            // Iniciar a simulação por 10 segundos
            int tempoSimulacao = 300;
            simulador.iniciar(tempoSimulacao);

        } catch (Exception e) {
            System.out.println("❌ Erro ao carregar o JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
