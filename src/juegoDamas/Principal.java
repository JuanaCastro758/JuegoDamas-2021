package src.juegoDamas;
import src.jugador.VectorJugador;
import src.tablero.Tablero;
public class Principal {
    public static void main(String[] args){
        Principal inicio=new Principal();
    }
    private VectorJugador vectorJugador=new VectorJugador();
    private Tablero tablero=new Tablero();
    public Principal(){
        vectorJugador.ingresarJugador();
        vectorJugador.imprimirMensaje("\n\n\nEL JUEGO EMPIEZA");
        vectorJugador.datosjugador();
        vectorJugador.imprimirMensaje("\nSeleccione dos Jugadores\n");
        vectorJugador.jugadoresSeleccionados();
        tablero.pintarTablero(1,1,1);
        
    }
    
}
