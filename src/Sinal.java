import java.util.ArrayList;
import java.util.List;

class Sinal {
    public String id;
    private double latitude;
    private double longitude;
    private List<Rua> ruasConectadas;

    public Sinal(String id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ruasConectadas = new ArrayList<>();
    }

    public void conectarRua(Rua rua) {
        ruasConectadas.add(rua);
    }

    @Override
    public String toString() {
        return "Sinal{id='" + id + "', lat=" + latitude + ", lon=" + longitude + ", ruas=" + ruasConectadas + "}";
    }
}
