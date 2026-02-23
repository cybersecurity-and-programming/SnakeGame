package snakeGame;

import java.util.Arrays;
import java.util.Comparator;

public class Record {
    
    /*
     * ########################################################
     * #                     Record                           #
     * ########################################################
     * # Record(Jugador[] iniciales);                         #
     * # Record ();                                           #
     * # nuevoRecord(Jugador jugador);                        # 
     * # mostrarResultado();                                  #  
     * ########################################################
     * # Asignatura: Programacion                             #
     * ########################################################
     */
    private static final int MAX_JUGADORES = 5;
    private final Jugador[] jugadores;
    private int num_jugadores;

    // Constructor con parámetros (copia defensiva)
    public Record(Jugador[] iniciales) {
        jugadores = new Jugador[MAX_JUGADORES];
        num_jugadores = 0;

        for (Jugador j : iniciales) {
            if (j != null) {
                nuevoRecord(j);
            }
        }
    }

    // Constructor por defecto
    public Record() {
        jugadores = new Jugador[MAX_JUGADORES];
        num_jugadores = 0;
    }

    public void nuevoRecord(Jugador jugador) {

        // Si aún no está lleno, lo añadimos directamente
        if (num_jugadores < MAX_JUGADORES) {
            jugadores[num_jugadores] = new Jugador(jugador.getNombre(), jugador.getPuntos());
            num_jugadores++;
        } else {
            // Si está lleno, solo entra si supera al último
            if (jugador.getPuntos() <= jugadores[num_jugadores - 1].getPuntos()) {
                return;
            }
            jugadores[num_jugadores - 1] = new Jugador(jugador.getNombre(), jugador.getPuntos());
        }

        // Ordenar de mayor a menor puntuación
        Arrays.sort(jugadores, 0, num_jugadores, Comparator.comparingInt(Jugador::getPuntos).reversed());
    }

    public void mostrarResultado() {
        System.out.println("=== TOP " + num_jugadores + " JUGADORES ===");
        for (int i = 0; i < num_jugadores; i++) {
            System.out.println((i + 1) + ". " + jugadores[i].getNombre() + " - " + jugadores[i].getPuntos());
        }
    }
}