package src.juegoDamas;
import java.util.*;
import src.jugador.VectorJugador;
import src.tablero.Tablero;
public class Principal {
    public static void main(String[] args){
        Principal inicio=new Principal();
    }
    private VectorJugador vectorJugador=new VectorJugador();
    public Principal(){
        Scanner scanner=new Scanner(System.in);
        vectorJugador.ingresarJugador();
        int op=0;
        do{
            vectorJugador.imprimirMensaje("\n\n\nEL JUEGO EMPIEZA");
            vectorJugador.datosjugador();
            vectorJugador.imprimirMensaje("\nSeleccione dos Jugadores\n");
            vectorJugador.jugadoresSeleccionados();
            vectorJugador.datosjugador();
            vectorJugador.imprimirMensaje("\n\nPara volver a jugar ingrese cualquier numero excepto el 0\n");
            op=scanner.nextInt();
        }while(op!=0);
    }
    
}
