package snakeGame;

public class Posicion {
    /*
    * ###############################################
    * #                 Posicion                    #
    * ###############################################
    * # Posicion(int posX,int posY);                #
    * # Posicion();                                 #
    * # setX(int posX);                             #
    * # int getX();                                 #
    * # setY(int posY);                             #
    * # int getY();                                 #
    * ###############################################
    * # Asignatura: Programacion                    #
    * ###############################################
    */
	
    private int posX;
    private int posY;

    public Posicion (int posX, int posY){
        this.posX=posX;
        this.posY=posY;
    }

    public Posicion(){
        this.posX=0;
        this.posY=0;
    }

    public void setX(int posX){
        this.posX=posX;
    }

    public int getX(){
        return posX;
    }

    public void setY(int posY){
        this.posY=posY;
    }

    public int getY(){
        return posY;
    }
}

