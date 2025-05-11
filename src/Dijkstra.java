import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public static List<Sinal> encontrarMenorCaminho(GrafoTransito grafo, Sinal origem, Sinal destino) {
        Map<Sinal, Double> distancias = new HashMap<>();
        Map<Sinal, Sinal> anteriores = new HashMap<>();
        Set<Sinal> visitados = new HashSet<>();

        for (Sinal s : grafo.sinais.values()) {
            distancias.put(s, Double.MAX_VALUE);
            anteriores.put(s, null);
        }
        distancias.put(origem, 0.0);

        while (visitados.size() < grafo.sinais.size()) {
            Sinal atual = encontrarMenorSinal(distancias, visitados);
            if (atual == null) break;
            visitados.add(atual);

            for (Rua rua : atual.getRuasConectadas()) {
                Sinal vizinho = rua.destino;
                if (!visitados.contains(vizinho)) {
                    double novaDist = distancias.get(atual) + rua.comprimento;
                    if (novaDist < distancias.get(vizinho)) {
                        distancias.put(vizinho, novaDist);
                        anteriores.put(vizinho, atual);
                    }
                }
            }
        }

        return construirCaminho(anteriores, origem, destino);
    }

    private static Sinal encontrarMenorSinal(Map<Sinal, Double> distancias, Set<Sinal> visitados) {
        Sinal menor = null;
        double menorDistancia = Double.MAX_VALUE;
        for (Sinal s : distancias.keySet()) {
            if (!visitados.contains(s) && distancias.get(s) < menorDistancia) {
                menor = s;
                menorDistancia = distancias.get(s);
            }
        }
        return menor;
    }

    private static List<Sinal> construirCaminho(Map<Sinal, Sinal> anteriores, Sinal origem, Sinal destino) {
        LinkedList<Sinal> caminho = new LinkedList<>();
        Sinal atual = destino;

        while (atual != null) {
            caminho.addFirst(atual);
            atual = anteriores.get(atual);
        }
        return caminho;
    }
}
