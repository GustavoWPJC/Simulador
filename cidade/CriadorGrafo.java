package cidade;

import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import semaforo.Semaforo;

// Classes auxiliares para mapeamento do JSON
class JsonTrafficLight {
    String id;
    double latitude, longitude;
    Map<String, String> attributes; // Captura os atributos como um mapa
}

class JsonData {
    List<JsonNode> nodes;
    List<JsonEdge> edges;
    List<JsonTrafficLight> traffic_lights;
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
        Type tipo = new TypeToken<JsonData>() {}.getType();
        JsonData data = gson.fromJson(reader, tipo);
        reader.close();

        Grafo grafo = new Grafo();

        // Adiciona os vértices ao grafo
        for (JsonNode node : data.nodes) {
            grafo.adicionarVertice(new Vertice(node.id, node.latitude, node.longitude));
        }

        // Adiciona as arestas, verificando se os vértices de origem e destino existem
        for (JsonEdge edge : data.edges) {
            if (!grafo.getVertices().containsKey(edge.source) || !grafo.getVertices().containsKey(edge.target)) {
                System.out.println("❌ Erro: Vértice não encontrado! Origem = " + edge.source + ", Destino = " + edge.target);
                continue;
            }
            Vertice origem = grafo.getVertices().get(edge.source);
            Vertice destino = grafo.getVertices().get(edge.target);
            int tempoTravessia = (int) edge.length;  // Ajuste se preferir usar double
            boolean sentidoUnico = edge.oneway;

            grafo.adicionarAresta(new Aresta(origem, destino, tempoTravessia, sentidoUnico));
        }

        // Adiciona os semáforos, vinculando-os ao vértice correspondente (caso exista)
        for (JsonTrafficLight trafficLight : data.traffic_lights) {
            if (grafo.getVertices().containsKey(trafficLight.id)) {
                String direcao = trafficLight.attributes.get("traffic_signals:direction");
                Semaforo semaforo = new Semaforo(trafficLight.id, direcao, trafficLight.latitude, trafficLight.longitude);
                grafo.adicionarSemaforo(semaforo);
            }
        }

        return grafo;
    }
}
