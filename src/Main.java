import java.util.List;
import java.util.ArrayList;

import cidade.GeradorKML;
import cidade.GrafoTransito;
import cidade.Sinal;
import semaforo.ControladorSemaforos;

import semaforo.Semaforo;


public class Main {
    public static void main(String[] args) {
        try {
            // 🔹 Importa os dados do JSON e constrói o grafo
            GrafoTransito grafo = new GrafoTransito();
            grafo.carregarDados("src/cidade/teresina1.json");

            // 🔹 Definir manualmente quais sinais terão semáforo
            List<Sinal> sinaisComSemaforo = new ArrayList<>();

            String[] idsCruzamento1 = { "590497440", "596497981" }; // Cruzamento 1
            String[] idsCruzamento2 = { "604381281", "9237851142" }; // Cruzamento 2

            for (String id : idsCruzamento1) {
                Sinal sinal = grafo.getSinais().get(id);
                if (sinal != null) {
                    Semaforo semaforo = new Semaforo(6, 2, 6);
                    sinal.setSemaforo(semaforo);
                    sinaisComSemaforo.add(sinal);
                }
            }

            for (String id : idsCruzamento2) {
                Sinal sinal = grafo.getSinais().get(id);
                if (sinal != null) {
                    Semaforo semaforo = new Semaforo(6, 2, 6);
                    sinal.setSemaforo(semaforo);
                    sinaisComSemaforo.add(sinal);
                }
            }


            // 🔹 Criar e iniciar controlador de semáforos

            ControladorSemaforos controlador = new ControladorSemaforos(sinaisComSemaforo);

            controlador.aplicarControle();


            // 🔹 Gerar o KML com os dados importados
            List<Sinal> OutralistaSinais = new ArrayList<>(grafo.getSinais().values());

            String caminhoArquivo = "/home/vini/Desktop/Simulador/mapa.kml";
            GeradorKML.gerarKML(OutralistaSinais, caminhoArquivo);


            System.out.println("✅ Arquivo KML gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Erro ao importar JSON e simular trânsito: " + e.getMessage());
        }
    }
}
