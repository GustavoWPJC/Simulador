package cidade;

/*public abstract class Grafo {
    public abstract void adicionarAresta(Rua rua);
    public abstract void adicionarVertice(Intersecao intersecao);
}*/
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;



class JsonData {
    List<JsonNode> nodes;
    List<JsonEdge> edges;
}

class JsonNode {
    String id;
    double latitude, longitude;
}

class JsonEdge {
    String id;
    String source, target;
    double length;
    boolean oneway;
}

public class CriadorGrafo {
    public static Grafo construirGrafo(String jsonPath) throws Exception {
        Gson gson = new Gson();
        FileReader reader = new FileReader(jsonPath);
        Type tipo = new TypeToken<JsonData>(){}.getType();
        JsonData data = gson.fromJson(reader, tipo);
        reader.close();
        Grafo grafo = new Grafo();
        // Criar vértices
        for (JsonNode node : data.nodes) {
            grafo.adicionarVertice(new Vertice(node.id, node.latitude, node.longitude));
        }
        // Criar arestas
        // Criar arestas
        for (JsonEdge edge : data.edges) {
            Vertice origem = grafo.vertice.get(edge.source);
            Vertice destino = grafo.vertice.get(edge.target);

            // 🔹 Adicionando verificação antes de criar a aresta
            if (!grafo.vertice.containsKey(edge.source) || !grafo.vertice.containsKey(edge.target)) {
                System.out.println("Erro: Vértice não encontrado! Origem = " + edge.source + ", Destino = " + edge.target);
                continue; // Evita criar uma aresta inválida
            }

            // Criando e adicionando a aresta
            int tempoTravessia = (int) edge.length;
            boolean sentidoUnico = edge.oneway;

            grafo.adicionarAresta(new Aresta(origem, destino, tempoTravessia, sentidoUnico));
        }

        return grafo;
    }
}
