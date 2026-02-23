package snakeGame;

public class Casilla {
    /*
     * ###############################################
     * #                  Casilla                    #
     * ###############################################
     * # Casilla (char tipo, Posicion posicion);     #
     * # Casilla();                                  #
     * # setTipo(char tipo);                         #
     * # char getTipo();                             #
     * # char obtenerSimbolo();                      #
     * ###############################################
     * # Asignatura: Programacion                    #
     * ###############################################
     */
    private char tipo;
    private Posicion posicion;
	
    public Casilla (char tipo, Posicion posicion){
	this.tipo = tipo;
	this.posicion = posicion;
    }

    public Casilla (){
        this.posicion = new Posicion(0,0);
        this.tipo = '#';	
    }
	
    public void setTipo(char tipo){
        this.tipo = tipo;
    }

    public char getTipo(){
        return tipo;
    }

    public char obtenerSimbolo(){
        return tipo;
    }
}
