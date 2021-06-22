package src.jugador;
import java.util.*;
import src.tablero.*;
public class VectorJugador {
    static Scanner scanner=new Scanner(System.in);
    private Jugador[] jugador=new Jugador[10];
    private int contador;
    private Tablero[] tableros=new Tablero[10];
    
    public void VectorJugador(){
        contador=0;
    }
    public void registroJugador(String nombre){
        jugador[contador]=new Jugador(nombre);
        tableros[contador]=new Tablero(0,0);
        contador++;
    }
    public void ingresarJugador(){
        imprimirMensaje("\n\nRegistro de los 10 Jugadores\n");
        for(int i=0;i<10;i++){
            imprimirMensaje("Ingresar nombre del jugador "+i+": ");
            String nombre=scanner.next();
            registroJugador(nombre);
        }
    }
    public void datosjugador(){
        imprimirMensaje("\n\nJugadores Registrados\n");     
        for(int i=0;i<10;i++){
            imprimirMensaje(i+".- "+jugador[i].getInformacion()+"-------"+tableros[i].jugadasInfo()+"\n");
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
        }while(j1==j2 || j1<0 || j2<0 || j1>9 || j2>9);
        int ganador=piedraPapelTijera(j1,j2);
        imprimirMensaje("al jugador "+ganador+" le corresponden las fichas X\n");
        imprimirMensaje("al otro jugador le corresponden las fichas O\n");
        //empieza el juego
        VectorTablero vectorTablero=new VectorTablero();
        if(ganador==j1){
            if(vectorTablero.retornarGanador()==1){
                guardaJugadasGanadas(j1,j2);
            }else if(vectorTablero.retornarGanador()==2){
                guardaJugadasGanadas(j2,j1);
            }
        }else if(ganador==j2){
            if(vectorTablero.retornarGanador()==1){
                guardaJugadasGanadas(j2,j1);
            }else if(vectorTablero.retornarGanador()==2){
                guardaJugadasGanadas(j1,j2);
            }
        }
        
    }
    public void guardaJugadasGanadas(int ganador,int perdedor){
        tableros[ganador].setJugadasGanadas(tableros[ganador].getJugadasGanadas()+1);
        tableros[perdedor].setJugadasPerdidas(tableros[perdedor].getJugadasPerdidas()+1);
    }
    public int piedraPapelTijera(int j1 , int j2){
         Random random=new Random();
        //jego
        //1.- piedra 2.- papel  3.- tijera
        int contador1=0;
        int contador2=0;
        while(contador1<3 && contador2<3){
            int x1=random.nextInt(3+1-1)+1;
            int x2=random.nextInt(3+1-1)+1;
            if((x1==1 && x2==3) || (x1==2 && x2==1) || (x1==3 && x2==2)){
                contador1++;
            }else if((x1==3 && x2==1) || (x1==1 && x2==2) || (x1==2 && x2==3)){
                contador2++;
            }
        }
        if(contador1>contador2){
            return j1;
        }else if(contador2>contador1){
            return j2;
        }else{
            return 0;
        }
    }
    public void imprimirMensaje(String mensaje){
        System.out.print(mensaje);    
    }
}
