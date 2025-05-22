package semaforo;

public class Semaforo {
    public enum Cor {
        VERDE, AMARELO, VERMELHO
    }

    private String intersecaoId;
    private Cor corAtual;
    private double latitude;
    private double longitude;
    private String direcao;


    public Semaforo(String intersecaoId, String direcao, double latitude, double longitude) {
        this.intersecaoId = intersecaoId;
        this.direcao = direcao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.corAtual = Cor.VERMELHO;
    }


    public double getLatitude() {
        return latitude;
    }
    public String getDirecao() {
        return direcao;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIntersecaoId() {
        return intersecaoId;
    }

    public void setCor(Cor cor) {
        this.corAtual = cor;
    }

    public Cor getCorAtual() {
        return corAtual;
    }

    public void exibirEstado() {
        System.out.println("Semáforo na posição (" + latitude + ", " + longitude +
                ") da interseção " + intersecaoId + "na direção " + direcao + " está " + corAtual);
    }
}
