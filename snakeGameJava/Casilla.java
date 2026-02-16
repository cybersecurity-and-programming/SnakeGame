/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakeGameJava;

/**
 *
 * @author cybersecurity-and-programming
 */
public class Casilla {
    //guardar el tipo de casilla (muro/vacía).
    private Posicion pos;
    private char tipo; 
    
    public Casilla(char tipo, Posicion pos){
        this.tipo = tipo;
        this.pos = new Posicion(pos.getX(), pos.getY());
    }
    
    public Casilla (){
        this.pos = new Posicion();
	this.pos.setX(0);
	this.pos.setY(0);
	this.tipo = ' ';	
    }
    
    private void setTipo(char tipo){
        this.tipo=tipo;
    }
    
    private char getTipo(){
        return tipo;
    }
    
    private char obtenerSimbolo(){
        return tipo;
    }
}
