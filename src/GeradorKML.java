import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorKML {

    public static void gerarKML(List<Sinal> sinais, String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n");
            writer.write("<Document>\n");

            for (Sinal sinal : sinais) {
                writer.write("<Placemark>\n");
                writer.write("<name>" + sinal.getId() + "</name>\n");

                // Define ícone baseado na existência de semáforo
                if (sinal.temSemaforo()) {
                    writer.write("<Style><IconStyle><Icon><href>http://maps.google.com/mapfiles/kml/paddle/red-circle.png</href></Icon></IconStyle></Style>\n");
                } else {
                    writer.write("<Style><IconStyle><Icon><href>http://maps.google.com/mapfiles/kml/paddle/grn-circle.png</href></Icon></IconStyle></Style>\n");
                }

                writer.write("<Point><coordinates>" + sinal.getLongitude() + "," + sinal.getLatitude() + ",0</coordinates></Point>\n");
                writer.write("</Placemark>\n");
            }


            writer.write("</Document>\n</kml>");
            System.out.println("Arquivo KML '" + nomeArquivo + "' gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo KML: " + e.getMessage());
        }
    }
}
