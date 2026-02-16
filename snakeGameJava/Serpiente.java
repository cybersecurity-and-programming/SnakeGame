/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakeGameJava;

/**
 *
 * @author cybersecurity-and-programming
 */

public class Serpiente {
    private Posicion [] cuerpo;
    private byte direccion;
    protected static final byte ARRIBA = 0;
    protected static final byte DERECHA = 1;
    protected static final byte ABAJO = 2;
    protected static final byte IZQUIERDA = 3;
    private boolean comido;
    
    public Serpiente(Posicion [] pos, byte direccion){
        this.cuerpo = pos;
        this.direccion = direccion;
        this.comido = false;
    }
    
    public Serpiente(){
        this.direccion = ARRIBA;
        this.cuerpo = new Posicion[3];
        this.cuerpo[0] = new Posicion(5,5);
        this.cuerpo[1] = new Posicion(5,6);
        this.cuerpo[2] = new Posicion(5,7);
        this.comido = false;
    }
    
    public void cambiarDirecion(byte direccion){
        this.direccion = direccion;
    }
    
    public byte getDireccion(){
        return direccion;
    }
    
    public void setComido(boolean comido){
        this.comido = comido;
    }
    
    public boolean getComido(){
        return comido;
    }
    
    public int getLongitud(){
        return this.cuerpo.length;
    }
    
    public boolean coincideCabeza(int x, int y){
        return (cuerpo[0].getX() == x) && (cuerpo[0].getY() == y);
    }
    
    public boolean coincideCuerpo(int x, int y){
        for (Posicion posCuerpo : cuerpo) {
            if ((posCuerpo.getX() == x) && (posCuerpo.getY() == y)) {
                return true;
            }
        }
        return false;
    }
    
    public void muevete(){
        if(this.comido){
            Posicion newPosicion [] = new Posicion[getLongitud()+1];//al comerse un raton aumenta de tamaño
            System.arraycopy(cuerpo, 0, newPosicion, 0, cuerpo.length);
            newPosicion[newPosicion.length-1]= new Posicion();//Creacion de la nueva posicion en el array
            
            cuerpo = newPosicion;
            comido = false;
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
