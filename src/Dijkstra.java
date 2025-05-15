import cidade.GrafoTransito;
import cidade.Rua;
import cidade.Intersecao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    public static List<Intersecao> encontrarMenorCaminho(GrafoTransito grafo, Intersecao origem, Intersecao destino) {
        Map<Intersecao, Double> distancias = new HashMap<>();
        Map<Intersecao, Intersecao> anteriores = new HashMap<>();
        Set<Intersecao> visitados = new HashSet<>();

        for (Intersecao s : grafo.sinais.values()) {
            distancias.put(s, Double.MAX_VALUE);
            anteriores.put(s, null);
        }
        distancias.put(origem, 0.0);

        while (visitados.size() < grafo.sinais.size()) {
            Intersecao atual = encontrarMenorSinal(distancias, visitados);
            if (atual == null) break;
            visitados.add(atual);

            for (Rua rua : atual.getRuasConectadas()) {
                Intersecao vizinho = rua.destino;
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

    private static Intersecao encontrarMenorSinal(Map<Intersecao, Double> distancias, Set<Intersecao> visitados) {
        Intersecao menor = null;
        double menorDistancia = Double.MAX_VALUE;
        for (Intersecao s : distancias.keySet()) {
            if (!visitados.contains(s) && distancias.get(s) < menorDistancia) {
                menor = s;
                menorDistancia = distancias.get(s);
            }
        }
        return menor;
    }

    private static List<Intersecao> construirCaminho(Map<Intersecao, Intersecao> anteriores, Intersecao origem, Intersecao destino) {
        LinkedList<Intersecao> caminho = new LinkedList<>();
        Intersecao atual = destino;

        while (atual != null) {
            caminho.addFirst(atual);
            atual = anteriores.get(atual);
        }
        return caminho;
    }
}
