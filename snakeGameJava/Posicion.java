/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakeGameJava;

/**
 *
 * @author cybersecurity-and-programming
 */
public class Posicion {
    private int x, y;//coordenadas de la posición del objeto.
    
    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Posicion(){
        this.x=0;
        this.y=0;
    }
    
    public void setX(int x){
        this.x=x;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setY(int x){
        this.x=x;
    }
    
    public int getY(){
        return this.y;
    }
}
