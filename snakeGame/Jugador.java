package snakeGame;


public final class Jugador {
    /*
     * ###############################################
     * #                  Jugador                    #
     * ###############################################
     * # Jugador(String nombre, int puntuacion);     #
     * # Jugador();                                  #
     * # String getNombre();                         #
     * # int getPuntos();                            #
     * # setNombre();                                #
     * # setPuntos();                                #
     * # String toString();                          #
     * ###############################################
     * # Asignatura: Programacion                    #
     * ###############################################
     */
    private String nombre;
    private int puntuacion;

    public Jugador(String nombre, int puntuacion) {
        this.nombre = (nombre != null) ? nombre : "Jugador";
        this.puntuacion = Math.max(0, puntuacion);
    }

    public Jugador() {
        this("Jugador", 0);
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    public String getNombre() {
        return nombre;
    }
    public void setPuntos(int puntuacion) {
        if (puntuacion >= 0) {
            this.puntuacion = puntuacion;
        }
    }

    public int getPuntos() {
        return puntuacion;
    }
    
    @Override
    public String toString() {
        return nombre + " - " + puntuacion + " puntos";
    }
}
