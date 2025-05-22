package trafego;


import cidade.Vertice;
import java.util.*;

public class GeradorVeiculos {
    private Random random = new Random();

    public List<Veiculo> gerarVeiculos(List<Vertice> intersecoes, int quantidade) {
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < quantidade; i++) {
            Vertice origem = intersecoes.get(random.nextInt(intersecoes.size()));
            Vertice destino = intersecoes.get(random.nextInt(intersecoes.size()));

            while (origem.equals(destino)) { // Garante que origem e destino não sejam iguais
                destino = intersecoes.get(random.nextInt(intersecoes.size()));
            }

            Veiculo veiculo = new Veiculo(
                    "V" + i,
                    origem.getLatitude(),
                    origem.getLongitude(),
                    random.nextDouble() * 2 + 1, // Velocidade aleatória entre 1 e 3
                    destino.getId()
            );

            veiculos.add(veiculo);
        }

        return veiculos;
    }
}
