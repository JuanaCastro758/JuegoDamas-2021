package src.jugador;
import java.util.*;
import src.tablero.*;
public class VectorJugador {
    static Scanner scanner=new Scanner(System.in);
    private Jugador[] jugador=new Jugador[5];
    InicioJuego inicioJuego=new InicioJuego();
    private int contador;
    
    public void VectorJugador(){
        contador=0;
    }
    public void registroJugador(String nombre){
        jugador[contador]=new Jugador(nombre);
        contador++;
    }
    public void ingresarJugador(){
        imprimirMensaje("\n\nRegistro de los 5 Jugadores\n");
        for(int i=0;i<5;i++){
            imprimirMensaje("Ingresar nombre del jugador "+(i+1)+": ");
            String nombre=scanner.next();
            registroJugador(nombre);
        }
    }
    public void datosjugador(){
        imprimirMensaje("\n\nJugadores Registrados\n");     
        for(int i=0;i<5;i++){
            imprimirMensaje(i+1+".- "+jugador[i].getInformacion()+"\n");
        }
    }
    public void jugadoresSeleccionados(){
        int j1=0;
        int j2=0;
        imprimirMensaje("\nNOTA: no se puede seleccionar un jugador dos veces\n");
        do{
        imprimirMensaje("---Jugador 1: ");
        j1=scanner.nextInt();
        imprimirMensaje("---Jugador 2: ");
        j2=scanner.nextInt();
        }while(j1==j2 || j1<=0 || j2<=0 || j1>=6 || j2>=6);
        inicioJuego.recibirJugadores(j1, j2);
    }
    public void imprimirMensaje(String mensaje){
        System.out.print(mensaje);    
    }
}
