package semaforo;

public class Semaforo {
    public enum Cor {
        VERDE, AMARELO, VERMELHO
    }

    private String intersecaoId;
    private String grupo;
    private Cor corAtual;
    private double latitude;
    private double longitude;

    public Semaforo(String intersecaoId, String grupo, double latitude, double longitude) {
        this.intersecaoId = intersecaoId;
        this.grupo = grupo;
        this.corAtual = Cor.VERMELHO; // Estado inicial
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIntersecaoId() {
        return intersecaoId;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setCor(Cor cor) {
        this.corAtual = cor;
    }

    public Cor getCorAtual() {
        return corAtual;
    }

    public void exibirEstado() {
        System.out.println("Semáforo na posição (" + latitude + ", " + longitude +
                ") da interseção " + intersecaoId + " (Grupo " + grupo + ") está " + corAtual);
    }
}
