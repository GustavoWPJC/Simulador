

import estruturas.ListaEncadeada;
import listener.Listener;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class Simulador implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient Timer timer;
    private int tempoSimulado = 0;
    private boolean pausado = false;

    // Lista de ouvintes de eventos da simulação
    private ListaEncadeada<Listener> ouvintes = new ListaEncadeada<>();

    // Registrar um ouvinte
    public void registrarListener(Listener listener) {
        ouvintes.adicionar(listener);
    }

    // Disparar evento para todos os ouvintes
    private void notificar(String tipo, Object dados) {
        for (int i = 0; i < ouvintes.tamanho(); i++) {
            Listener listener = ouvintes.pegar(i);
            listener.aoDispararEvento(tipo, dados);
        }
    }

    // Inicia a simulação por tempoLimiteSegundos (em segundos)
    public void iniciar(int tempoLimiteSegundos) {
        System.out.println("Simulação iniciada por " + tempoLimiteSegundos + " segundos...");
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (!pausado) {
                    tempoSimulado++;
                    atualizarSimulacao();
                }
                if (tempoSimulado >= tempoLimiteSegundos) {
                    encerrar();
                    System.out.println("🚦 Simulação encerrada após " + tempoLimiteSegundos + " segundos.");
                }
            }
        }, 0, 1000);
    }

    public void pausar() {
        pausado = true;
    }

    public void continuarSimulacao() {
        pausado = false;
    }

    public void encerrar() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void gravar(String caminho) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(this);
        }
    }

    public static Simulador carregar(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            Simulador sim = (Simulador) ois.readObject();
            sim.timer = new Timer(); // recria o timer após desserialização
            return sim;
        }
    }

    // Aqui, a cada tick, notificamos os listeners (que podem ser, por exemplo, o controlador de semáforos e o gerador de veículos)
    private void atualizarSimulacao() {
        System.out.println("Segundo simulado: " + tempoSimulado);
        notificar("TICK", tempoSimulado);
    }
}
