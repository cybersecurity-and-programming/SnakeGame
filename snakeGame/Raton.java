package snakeGame;

public class Raton {

    /*
     * ########################################################
     * #                     Raton                            #
     * ########################################################
     * # Raton (String id, int puntuacion, Posicion posicion);#
     * # Raton (Posicion posicion);                           #
     * # Posicion getPosicion();                              # 
     * # boolean getPosMouse();                               # 
     * ########################################################
     * # Asignatura: Programacion                             #
     * ########################################################
     */

    private String id;
    private int puntuacion;
    protected static int ratones=0;
    private Posicion pos;
    private int direccion;

    public Raton (String id, int puntuacion, Posicion posicion){
        this.id =id;
        this.puntuacion = puntuacion;
        this.pos = posicion;
        ratones++;
    }

    public Raton (Posicion posicion){
        this.id = "Raton"+ratones;
        this.puntuacion = 100;
        this.pos = posicion;
        ratones++;
    }

    public Posicion getPosicion(){
        return pos;
    }
    
    public boolean getPosMouse(int x, int y) {
        return x == pos.getX() && y == pos.getY();
    }
}