package snakeGame;

public class Serpiente {

    /**
     * #################################################
     * # 		         Serpiente                     #
     * #################################################
     * # Serpiente();                                  #
     * # Serpiente (Posicion [] cuerpo, int direccion);#
     * # cambiaDireccion (int direccion);              #
     * # int getDireccion();                           #
     * # setComido(boolean comido);                    #
     * # boolean getComido();                          #
     * # int getLongitud();                            #
     * # boolean coincideCabeza (int posX, int posY);  #
     * # boolean coincideCuerpo (int posX, int posY);  #
     * # muevete ();                                   #
     * #################################################
     * # Asignatura: Programacion                      #
     * #################################################
    */

    protected static final int ARRIBA = 0;
    protected static final int DERECHA = 1;
    protected static final int ABAJO = 2;
    protected static final int IZQUIERDA = 3;
    private Posicion [] cuerpo;
    private int direccion;
    private boolean comido;

    public Serpiente(){
        this.cuerpo = new Posicion [3];
        this.cuerpo[0] = new Posicion (5,5);
        this.cuerpo[1] = new Posicion (5,6);
        this.cuerpo[2] = new Posicion (5,7);
        this.direccion = ARRIBA;
    }

    public Serpiente (Posicion [] cuerpo, int direccion){
        this.cuerpo = cuerpo;
        this.direccion = direccion;
        this.comido = false;
    }

    public void cambiaDireccion (int direccion){
        this.direccion = direccion;
    }

    public int getDireccion(){
        return direccion;
    }

    public void setComido(boolean comido){
        this.comido = comido;
    }

    public boolean getComido(){
        return comido;
    }

    public int getLongitud(){
        return cuerpo.length;
    }

    public boolean coincideCabeza (int posX, int posY){
        return (cuerpo[0].getX()==posX)&&(cuerpo[0].getY()==posY);
    }

    public Posicion[] getPosicion(){
        return cuerpo;
    }

    public boolean coincideCuerpo (int posX, int posY){
        for(int i=1;i<cuerpo.length;i++){
            if((cuerpo[i].getX()==posX)&&(cuerpo[i].getY()==posY)){
                return true;
            }
        }
        return false;
    }

    public Posicion[] cuerpo(){
        return cuerpo;
    }

    public void muevete (){
        if (comido){
            Posicion [] new_snake = new Posicion[cuerpo.length+1];
            System.arraycopy(cuerpo,0, new_snake,0,cuerpo.length);
            
            new_snake[new_snake.length-1]=new Posicion();
            cuerpo=new_snake;
            comido=false;
        }
	
        for (int i=cuerpo.length-1; i>0; i--){
            cuerpo[i].setX(cuerpo[i-1].getX());
            cuerpo[i].setY(cuerpo[i-1].getY());
        }

        switch (direccion){
            case ARRIBA -> cuerpo[0].setY(cuerpo[0].getY()-1);
            case DERECHA -> cuerpo[0].setX(cuerpo[0].getX()+1);
            case ABAJO -> cuerpo[0].setY(cuerpo[0].getY()+1);
            case IZQUIERDA -> cuerpo[0].setX(cuerpo[0].getX()-1); 
        }
    }
}
	


