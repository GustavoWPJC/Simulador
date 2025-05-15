import java.util.List;
import java.util.ArrayList;
import Semaforo.ControladorSemaforos;
import Semaforo.Semaforo;

public class Main {
    public static void main(String[] args) {
        try {
            // 🔹 Carregar dados do grafo
            GrafoTransito grafo = new GrafoTransito();
            grafo.carregarDados("src/teresina1.json");

            // 🔹 Criar lista de sinais
            List<Sinal> listaSinais = new ArrayList<>(grafo.getSinais().values());

            // 🔹 Configurar semáforos em alguns sinais
            String[] idsComSemaforo = { "590497440", "596497981", "604381281", "9237851142" };
            for (String id : idsComSemaforo) {
                Sinal sinal = grafo.getSinais().get(id);
                if (sinal != null) {
                    sinal.setSemaforo(new Semaforo(4, 2, 6)); // Tempos padrão: Verde=4s, Amarelo=2s, Vermelho=6s
                }
            }

            // 🔹 Criar lista de carros
            List<Carro> carros = new ArrayList<>();
            carros.add(new Carro(listaSinais.get(0), listaSinais.get(listaSinais.size() - 1), listaSinais, 0)); // Corrigindo parêntese

            // 🔹 Controlador de semáforos
            ControladorSemaforos controlador = new ControladorSemaforos(listaSinais.stream()
                    .filter(Sinal::temSemaforo)
                    .map(Sinal::getSemaforo)
                    .toList());

            // 🔹 Simulação de tempo
            int tempoTotal = 20; // Define quantos ciclos a simulação terá
            for (int tempo = 0; tempo < tempoTotal; tempo++) {
                System.out.println("\n🕒 Tempo atual: " + tempo + "s");

                // Atualizar semáforos
                for (Sinal sinal : listaSinais) {
                    sinal.atualizarSemaforo(tempo);
                    sinal.exibirSemaforo(); // Exibir estado do semáforo
                }

                // Mover carros
                for (Carro carro : carros) {
                    carro.moverSePossivel(tempo);
                }

                // Pequena pausa para facilitar a visualização (opcional)
                Thread.sleep(1000); // 1 segundo entre cada ciclo
            }

            // 🔹 Gerar o KML com os dados importados
            List<Sinal> OutralistaSinais = new ArrayList<>(grafo.getSinais().values());
            String caminhoArquivo = "/Users/gw792/IdeaProjects/testeSemaforo/mapa.kml";
            GeradorKML.gerarKML(OutralistaSinais, caminhoArquivo);
            System.out.println("✅ Arquivo KML gerado com sucesso!");

            System.out.println("\n✅ Simulação concluída!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Erro ao importar JSON e simular trânsito: " + e.getMessage());
        }
    }
}
