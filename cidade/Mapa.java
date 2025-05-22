package cidade;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import semaforo.Semaforo;

public class Mapa extends JPanel {
    private List<Semaforo> semaforos;

    public Mapa(List<Semaforo> semaforos) {
        this.semaforos = semaforos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        for (Semaforo sem : semaforos) {
            int x = (int) (sem.getLongitude() * 10); // Ajuste de escala
            int y = (int) (sem.getLatitude() * 10);  // Ajuste de escala
            g.fillOval(x, y, 10, 10);
            g.drawString("ID: " + sem.getIntersecaoId(), x + 12, y + 12);
        }
    }

    public static void exibirMapa(List<Semaforo> semaforos) {
        JFrame frame = new JFrame("Mapa de Semáforos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new Mapa(semaforos));
        frame.setVisible(true);
    }
}
