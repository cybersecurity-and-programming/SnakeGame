package snakeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Laberinto {
	
    /*
    * ######################################################
    * #                   Laberinto                        #
    * ######################################################
    * # Laberinto(int ancho, int alto,                     #
    * # Casilla [][] casillas, Serpiente serpiente,        #
    * # Raton [] raton, int puntuacion, Record record);    #
    * # Laberinto ();                                      #
    * # come_raton();                                      #
    * # crea_raton(int num);                               #
    * # gameOver();                                        #
    * # String toString();                                 #
    * # setDireccion ();                                   #
    * # actualizarLaberinto ();                            #
    * # int getSeguir();                                   #
    * ######################################################
    * # Asignatura: Programacion                           #
    * ######################################################

    */
    private int ancho;
    private int alto;
    private Casilla [][] casillas;
    private Serpiente snake;
    private Raton [] mouse;
    private int puntuacion;
    private Record records;
    private int flag;
	
    public Laberinto(int ancho, int alto, Casilla [][] casillas, Serpiente snake, Raton [] mouse, int puntuacion, Record records){
        this.ancho = ancho;
        this.alto = alto;
        this.casillas = casillas;
        this.snake = snake;
        this.mouse = mouse;
        this.puntuacion = puntuacion;
        this.records = records;		
    }

    public Laberinto (){
		this.ancho = 29;
		this.alto = 31;
		this.records = new Record();
		this.puntuacion = 0;
		this.flag=1;

        Posicion [] locSnake = new Posicion [3];
		locSnake[0]= new Posicion(14,15);
		locSnake[1]= new Posicion(14,16);
        locSnake[2]= new Posicion(14,17);
        this.snake = new Serpiente (locSnake,Serpiente.ARRIBA);
        
        Posicion [] locMouse = new Posicion[4];
        locMouse[0]= new Posicion(2,2);
		locMouse[1]= new Posicion(26,2);
		locMouse[2]= new Posicion(2,29);
		locMouse[3]= new Posicion(26,29);
        
        this.mouse = new Raton[4];
        for (int i =0;i<mouse.length;i++) {
            this.mouse[i] = new Raton(locMouse[i]);
        }
        
		this.casillas = new Casilla[alto][ancho];
        char [][] tablero = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ','#','#','#','#','#','#','#','#',' ',' ',' ',' ',' ','#','#','#','#','#','#','#','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ','#','#','#','#','#','#','#','#',' ',' ',' ',' ',' ','#','#','#','#','#','#','#','#',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };
	
        for (int filas = 0; filas<alto; filas++){
            for (int columnas = 0; columnas<ancho; columnas++){
                casillas[filas][columnas]= new Casilla(tablero[filas][columnas],new Posicion (columnas,filas));
            }
        }
    }

    private void isEatMouse() {
        for (int i = 0; i < mouse.length; i++) {
            if (mouse[i] == null) continue; // evita NPE
            
            if (snake.coincideCabeza(mouse[i].getPosicion().getX(),mouse[i].getPosicion().getY())) {
                snake.setComido(true);
                puntuacion += 100;
                ratonAleatorio(i); // recoloca el ratón comido
                return; // ya no hace falta seguir
            }
        }
    }
 
    public boolean ratonAleatorio(int numero) {
        if (numero < 0 || numero >= mouse.length) {
            return false;
        }

        Random rnd = new Random();
        int maxIntentos = ancho * alto;

        for (int i = 0; i < maxIntentos; i++) {

            int posX = rnd.nextInt(ancho);
            int posY = rnd.nextInt(alto);

            // 1. Casilla bloqueada
            if (casillas[posY][posX].getTipo() == '#') {
                continue;
            }

            // 2. Coincide con la serpiente
            if (snake.coincideCabeza(posX, posY) || snake.coincideCuerpo(posX, posY)) {
                continue;
            }

            // 3. Coincide con otro ratón
            boolean ocupado = false;
            for (Raton r : mouse) {
                if (r != null && r.getPosMouse(posX, posY)) {
                    ocupado = true;
                    break;
                }
            }
            if (ocupado) {
                continue;
            }

            // Si llega aquí, la posición es válida
            mouse[numero] = new Raton(new Posicion(posX, posY));
            return true;
        }

        // No se encontró posición válida
        return false;
    }

    private boolean game_Over() {
        int x = snake.getPosicion()[0].getX();
        int y = snake.getPosicion()[0].getY();

        if (snake.coincideCuerpo(x, y)) {
            return true;
        }
        return casillas[y][x].getTipo() == '#';
    }

    private String leeTeclado() {
        try {
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            System.out.println("Error al leer del teclado");
            return "";
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

            for (int y = 0; y < alto; y++) {
                for (int x = 0; x < ancho; x++) {

                // Cabeza
                if (snake.coincideCabeza(x, y)) {
                    ret.append("@");
                    continue;
                }

                // Cuerpo
                if (snake.coincideCuerpo(x, y)) {
                    ret.append("O");
                    continue;
                }

                // Ratón
                boolean hayRaton = false;
                for (Raton r : mouse) {
                    if (r != null && r.getPosicion().getX() == x && r.getPosicion().getY() == y) {
                        ret.append("*");
                        hayRaton = true;
                        break;
                    }
                }
                if (hayRaton) continue;

                // Casilla normal
                ret.append(casillas[y][x].obtenerSimbolo());
            }
            ret.append("\n");
        }

        ret.append("PUNTUACIÓN: ").append(puntuacion);
        return ret.toString();
    }

    public boolean nuevaDireccion() {
        System.out.println("Nuevo movimiento (P derecha, O izquierda, Q salir):");
        String tecla = leeTeclado().toUpperCase();

        if (tecla.equals("Q")) {
            System.out.println("Gracias por jugar");
            return false;
        }

        int direccion = snake.getDireccion();

        if (tecla.equals("O")) direccion--;
        if (tecla.equals("P")) direccion++;

        if (direccion > 3) direccion = Serpiente.ARRIBA;
        if (direccion < 0) direccion = Serpiente.IZQUIERDA;

        snake.cambiaDireccion(direccion);
        return true;
    }
    
    public void actualizar_laberinto() {
        System.out.println(toString());
        if (!nuevaDireccion()) {
            flag = 0; // salir voluntariamente
            return;
        }

        snake.muevete();
        isEatMouse();

        if (game_Over()) {

            flag = -1; // estado de game over
            System.out.println("GAME OVER");
            System.out.println("Introduzca un nombre para el jugador:");

            String nombre = leeTeclado();

            records.nuevoRecord(new Jugador(nombre, puntuacion));
            records.mostrarResultado();

            return;
        }

        flag = 1; // seguimos jugando
    }

    public int getFlag(){
        return flag;
    }
}
