package cidade;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.json.*;
import semaforo.Semaforo;


public class ImportadorJSON {

    public static Map<String, Intersecao> sinais = new HashMap<>();
    public static List<Rua> ruas = new ArrayList<>();

    // Lista manual de sinais que terão semáforo
    public static Set<String> sinaisComSemaforo = Set.of(
            "590497440", "596497981", "604381281", "9237851142"
    ); // IDs escolhidos manualmente

    public static void importar(String caminho) throws Exception {
        String conteudo = new String(Files.readAllBytes(Paths.get(caminho)));
        JSONObject json = new JSONObject(conteudo);

        // Processamento dos nós (sinais)
        JSONArray nodes = json.getJSONArray("nodes");
        for (int i = 0; i < nodes.length(); i++) {
            JSONObject n = nodes.getJSONObject(i);
            String id = n.getString("id");
            double lat = n.getDouble("latitude");
            double lon = n.getDouble("longitude");
            Intersecao intersecao = new Intersecao(id, lat, lon);

            // Adiciona semáforo apenas nos sinais escolhidos manualmente
            if (sinaisComSemaforo.contains(id)) {
                intersecao.setSemaforo(new Semaforo(4, 2, 6)); // Configuração padrão
            }

            sinais.put(id, intersecao);
        }

        // Processamento das ruas (edges)
        JSONArray edges = json.getJSONArray("edges");
        for (int i = 0; i < edges.length(); i++) {
            JSONObject e = edges.getJSONObject(i);
            String origemId = e.getString("source");
            String destinoId = e.getString("target");
            double comprimento = e.getDouble("length");
            double velocidade = e.optDouble("maxspeed", 50.0); // Ajustado para "maxspeed"
            double tempo = comprimento / velocidade;

            Intersecao origem = sinais.get(origemId);
            Intersecao destino = sinais.get(destinoId);

            if (origem != null && destino != null) { // Evita NullPointerException
                Rua rua = new Rua("R" + i, origem, destino, comprimento, velocidade);
                origem.conectarRua(rua);
                destino.conectarRua(rua);
                ruas.add(rua);
            } else {
                System.err.println("Erro: origem ou destino não encontrado para rua " + e.getString("id"));
            }
        }
    }
}
