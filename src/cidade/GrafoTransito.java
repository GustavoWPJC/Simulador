package cidade;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GrafoTransito {
    public Map<String, Intersecao> sinais = new HashMap<>(); // Agora são atributos da classe
    public Map<String, Rua> ruas = new HashMap<>();

    public Map<String, Intersecao> getSinais() {
        return sinais;
    }

    public Map<String, Rua> getRuas() {
        return ruas;
    }


    public void carregarDados(String caminhoArquivo) {
        try {
            // Lendo o conteúdo do arquivo JSON
            String jsonData = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));
            JSONObject dados = new JSONObject(jsonData);

            // Criando sinais
            JSONArray nodes = dados.getJSONArray("nodes");
            for (int i = 0; i < nodes.length(); i++) {
                JSONObject node = nodes.getJSONObject(i);
                String idSinal = node.getString("id");
                double latitude = node.getDouble("latitude");
                double longitude = node.getDouble("longitude");

                sinais.put(idSinal, new Intersecao(idSinal, latitude, longitude));
            }

            // Criando ruas e conectando aos sinais
            JSONArray edges = dados.getJSONArray("edges");
            for (int i = 0; i < edges.length(); i++) {
                JSONObject edge = edges.getJSONObject(i);
                String idRua = edge.getString("id");
                String idOrigem = edge.getString("source");
                String idDestino = edge.getString("target");
                double comprimento = edge.getDouble("length");
                double velocidadeMaxima = edge.getDouble("maxspeed");

                // Criando a rua
                Rua rua = new Rua(idRua, sinais.get(idOrigem), sinais.get(idDestino), comprimento, velocidadeMaxima);
                ruas.put(idRua, rua);

                // Conectando a rua aos sinais de origem e destino
                sinais.get(idOrigem).conectarRua(rua);
                sinais.get(idDestino).conectarRua(rua);
            }

            System.out.println("\n✅ Dados carregados com sucesso!");

        } catch (IOException e) {
            System.err.println("❌ Erro ao ler o arquivo JSON: " + e.getMessage());
        }
    }
}
