import java.util.List;
import java.util.ArrayList;

import cidade.GeradorKML;
import cidade.GrafoTransito;
import cidade.Intersecao;
import semaforo.ControladorSemaforos;

import semaforo.Semaforo;

public class Main {
    public static void main(String[] args) {
        try {
            // 🔹 Importa os dados do JSON e constrói o grafo
            GrafoTransito grafo = new GrafoTransito();
            grafo.carregarDados("src/cidade/teresina1.json");

            // 🔹 Definir manualmente quais sinais terão semáforo
            List<Intersecao> sinaisComSemaforo = new ArrayList<>();

            String[] idsCruzamento1 = { "1555757125", "1555757135" }; // Cruzamento 1
            String[] idsCruzamento2 = { "2142438848", "2142438843" }; // Cruzamento 2

            for (String id : idsCruzamento1) {
                Intersecao intersecao = grafo.getSinais().get(id);
                if (intersecao != null) {
                    Semaforo semaforo = new Semaforo(6, 2, 6);
                    intersecao.setSemaforo(semaforo);
                    sinaisComSemaforo.add(intersecao);
                }
            }

            for (String id : idsCruzamento2) {
                Intersecao intersecao = grafo.getSinais().get(id);
                if (intersecao != null) {
                    Semaforo semaforo = new Semaforo(6, 2, 6);
                    intersecao.setSemaforo(semaforo);
                    sinaisComSemaforo.add(intersecao);
                }
            }


            // 🔹 Criar e iniciar controlador de semáforos

            ControladorSemaforos controlador = new ControladorSemaforos(sinaisComSemaforo);

            controlador.aplicarControle();


            // 🔹 Gerar o KML com os dados importados
            List<Intersecao> OutralistaSinais = new ArrayList<>(grafo.getSinais().values());
            String caminhoArquivo = "/home/vini/Desktop/Simulador/mapa.kml";
            GeradorKML.gerarKML(OutralistaSinais, caminhoArquivo);
            System.out.println("✅ Arquivo KML gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Erro ao importar JSON e simular trânsito: " + e.getMessage());
        }
    }
}
