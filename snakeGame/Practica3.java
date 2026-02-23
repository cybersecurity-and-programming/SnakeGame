package snakeGame;

public class Practica3 {
    /*
     * ######################################################
     * #       Practica 3: Juego de la serpiente            #
     * ######################################################
     * # Lenguaje: Java                                     #
     * # IDE: eclipse indigo.                               #
     * # Fecha de inicio: 9/08/2012                         #
     * # Fecha de finalizacion: 14/08/2012                  #
     * # archivos .java:                                    #
     * # 		-Practica_3.java                            #
     * # 		-Posicion.java                              #
     * # 		-Casilla.java                               #
     * # 		-Serpiente.java                             #
     * # 		-Raton.java                                 #
     * # 		-Jugador.java                               #
     * # 		-Record.java                                #
     * # 		-Laberinto.java                             #
     * ######################################################
     * # Asignatura: Programacion                           #
     * ######################################################
     */
    public static void main(String[] args) {
        Laberinto laberinto=new Laberinto();
	    do {
            laberinto.actualizar_laberinto();
	    } while (laberinto.getFlag()==1);
    }
}
