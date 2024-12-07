import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PP13_5 {
    static class Auto {
        private static int count = 0;
        private int id;

        public Auto() {
            this.id = ++count;
        }

        public int getId() {
            return id;
        }
    }

    static class Ampel {
        private boolean istGruen; // true = grün, false = rot

        public Ampel() {
            this.istGruen = false; // Startzustand ist rot
        }

        public void wechsleAmpel() {
            istGruen = !istGruen;
        }

        public boolean istGruen() {
            return istGruen;
        }
    }

    private Queue<Auto> warteschlange;
    private Ampel ampel;
    private Random random;
    private Timer autoTimer;
    private Timer ampelTimer;

    public PP13_5() {
        this.warteschlange = new LinkedList<>();
        this.ampel = new Ampel();
        this.random = new Random();
    }

    public void autoAnkommen() {
        Auto neuesAuto = new Auto();
        warteschlange.add(neuesAuto);
        System.out.println("Ein Auto mit ID " + neuesAuto.getId() + " ist angekommen.");
    }

    public void autoDurchlassen() {
        if (ampel.istGruen() && !warteschlange.isEmpty()) {
            Auto auto = warteschlange.poll();
            System.out.println("Das Auto mit ID " + auto.getId() + " fährt vorbei.");
        } else if (!ampel.istGruen()) {
            System.out.println("Die Ampel ist rot, kein Auto kann fahren.");
        }
    }

    public void starten() {
        autoTimer = new Timer();
        autoTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                autoAnkommen();
            }
        }, 0, 3000); // Alle 3 Sekunden kommt ein neues Auto

        ampelTimer = new Timer();
        ampelTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ampel.wechsleAmpel();
                if (ampel.istGruen()) {
                    System.out.println("Die Ampel ist jetzt grün.");
                } else {
                    System.out.println("Die Ampel ist jetzt rot.");
                }
                autoDurchlassen();
            }
        }, 0, 5000); // Alle 5 Sekunden wechselt die Ampel
    }

    public void stoppen() {
        if (autoTimer != null) {
            autoTimer.cancel();
        }
        if (ampelTimer != null) {
            ampelTimer.cancel();
        }
        System.out.println("Simulation gestoppt.");
    }

    public static void main(String[] args) {
        PP13_5 simulation = new PP13_5();
        simulation.starten();

        // Beispiel für das Stoppen der Simulation nach 30 Sekunden
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        simulation.stoppen();
    }
}
