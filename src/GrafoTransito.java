import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GrafoTransito {
    public static void main(String[] args) {
        String caminhoArquivo = "src/teresina1.json"; // Certifique-se de que o arquivo JSON está neste caminho

        try {
            // Lendo o conteúdo do arquivo JSON
            String jsonData = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));

            // Parseando o JSON
            JSONObject dados = new JSONObject(jsonData);

            // Criando sinais
            Map<String, Sinal> sinais = new HashMap<>();
            JSONArray nodes = dados.getJSONArray("nodes");
            for (int i = 0; i < nodes.length(); i++) {
                JSONObject node = nodes.getJSONObject(i);
                String idSinal = node.getString("id");
                double latitude = node.getDouble("latitude");
                double longitude = node.getDouble("longitude");

                sinais.put(idSinal, new Sinal(idSinal, latitude, longitude));
            }

            // Criando ruas e conectando aos sinais
            Map<String, Rua> ruas = new HashMap<>();
            JSONArray edges = dados.getJSONArray("edges");
            for (int i = 0; i < edges.length(); i++) {
                JSONObject edge = edges.getJSONObject(i);
                String idRua = edge.getString("id");
                String idOrigem = edge.getString("source");
                String idDestino = edge.getString("target");
                double comprimento = edge.getDouble("length");
                double tempoViagem = edge.getDouble("travel_time");
                double velocidadeMaxima = edge.getDouble("maxspeed");

                // Criando a rua
                Rua rua = new Rua(idRua, sinais.get(idOrigem), sinais.get(idDestino), comprimento, tempoViagem, velocidadeMaxima);
                ruas.put(idRua, rua);

                // Conectando a rua aos sinais de origem e destino
                sinais.get(idOrigem).conectarRua(rua);
                sinais.get(idDestino).conectarRua(rua);
            }

            // Exibindo o resultado
            System.out.println("\n🚦 Sinais carregados: ");
            System.out.println(sinais);

            System.out.println("\n🛣️ Ruas carregadas: ente d");
            System.out.println(ruas);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
}
