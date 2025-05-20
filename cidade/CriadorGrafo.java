package cidade;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import semaforo.Semaforo;

class JsonTrafficLight {
    String id;
    double latitude, longitude;
    String direction; // Exemplo: "backward"
}

class JsonData {
    List<JsonNode> nodes;
    List<JsonEdge> edges;
    List<JsonTrafficLight> traffic_lights; // 🔹 Adicionando semáforos
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

        // 🔹 Criar vértices
        for (JsonNode node : data.nodes) {
            grafo.adicionarVertice(new Vertice(node.id, node.latitude, node.longitude));
        }

        // 🔹 Criar arestas
        for (JsonEdge edge : data.edges) {
            if (!grafo.getVertice().containsKey(edge.source) || !grafo.getVertice().containsKey(edge.target)) {
                System.out.println("❌ Erro: Vértice não encontrado! Origem = " + edge.source + ", Destino = " + edge.target);
                continue;
            }

            Vertice origem = grafo.getVertice().get(edge.source);
            Vertice destino = grafo.getVertice().get(edge.target);
            int tempoTravessia = (int) edge.length;
            boolean sentidoUnico = edge.oneway;

            grafo.adicionarAresta(new Aresta(origem, destino, tempoTravessia, sentidoUnico));
        }

        // 🔹 Criar semáforos nas interseções corretas e adicionar ao grafo
        for (JsonTrafficLight trafficLight : data.traffic_lights) {
            if (grafo.getVertice().containsKey(trafficLight.id)) {
                Semaforo semaforo = new Semaforo(trafficLight.id, "A", trafficLight.latitude, trafficLight.longitude);
                grafo.adicionarSemaforo(semaforo); // 🔹 Adicionando semáforo ao grafo
            } else {
                System.out.println("⚠️ Aviso: Semáforo " + trafficLight.id + " não está associado a um vértice existente.");
            }
        }

        return grafo;
    }
}