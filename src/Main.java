import java.util.List;
import java.util.ArrayList;
import Semaforo.ControladorSemaforos;
import Semaforo.Semaforo;

public class Main {
    public static void main(String[] args) {
        try {
            // 🔹 Importa os dados do JSON e constrói o grafo
            GrafoTransito grafo = new GrafoTransito();
            grafo.carregarDados("src/teresina1.json");

            // 🔹 Definir manualmente quais sinais terão semáforo
            List<Sinal> listaSinais = new ArrayList<>(grafo.getSinais().values());

            String[] idsComSemaforo = { "590497440", "596497981", "604381281", "9237851142" };

            for (String id : idsComSemaforo) {
                Sinal sinal = grafo.getSinais().get(id);
                if (sinal != null) {
                    sinal.setSemaforo(new Semaforo(4, 2, 6)); // Configuração padrão
                }
            }

            // 🔹 Criar e iniciar controlador de semáforos
            ControladorSemaforos controlador = new ControladorSemaforos(listaSinais.stream()
                    .filter(Sinal::temSemaforo)
                    .map(Sinal::getSemaforo)
                    .toList());
            controlador.aplicarControle();

            // 🔹 Gerar o KML com os dados importados
            List<Sinal> OutralistaSinais = new ArrayList<>(grafo.getSinais().values());

            String caminhoArquivo = "/home/vini/Desktop/Simulador/mapa.kml";
            GeradorKML.gerarKML(listaSinais, caminhoArquivo);


            System.out.println("✅ Arquivo KML gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Erro ao importar JSON e simular trânsito: " + e.getMessage());
        }
    }
}
