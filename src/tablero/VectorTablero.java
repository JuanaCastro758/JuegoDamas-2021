package src.tablero;
import java.util.*;
public class VectorTablero {
    //color de jugadores y espacios vacios
     //signo del sugador 1
        String ju_1="\u001B[31m\u001B[43m X \u001B[0m";
        //spacio vacio
        String vacio="\u001B[31m\u001B[43m   \u001B[0m";
        //signo jugador 2
        String ju_2="\u001B[31m\u001B[43m O \u001B[0m";
        //espacio sin usar
        String b="\u001B[47m   \u001B[0m";
        static Scanner scanner=new Scanner(System.in);
        private String[][] tablero= new String[8][8];
    //llenar la matriz con los espacios
    public VectorTablero (){
         boolean resultado;
       tablaInicio();
       mostrarInfoTabla();
       do{
            mensaje("\nfichas X");
            movidasJugador(ju_1);
            mostrarInfoTabla();
            resultado=verificarGanador();
            if(resultado==false){
                mensaje("fichas O");
                movidasJugador(ju_2);
                mostrarInfoTabla();
                resultado=verificarGanador();
            }
       }while(resultado==false);
    }
    public int retornarGanador(){
        int fichasX=0;
        int fichasO=0;
        for(int f=0;f<8;f++){
            for(int c=0;c<8;c++){
                if(tablero[f][c]==ju_1){
                    fichasX++;
                }
                if(tablero[f][c]==ju_2){
                    fichasO++;
                }
            }
        }
        if(fichasO==0){
            //gana el jugador de las fichas X
            return 1;
        }else if(fichasX==0){
            //gana el jugador de las fichas O
            return 2;
        }
        return 0;
    }
    public void tablaInicio(){
        for(int i=0;i<8;i++){
            int par=0;
            int im=1;
            String aux=ju_1;
            ju_1=b;
            b=aux;
            //espacio del Jugador 1
            for(int j=0;j<8;j++){
                if(j==par && i==3){
                    ju_1=vacio;
                    
                }
                if(j==par && i==5){
                    ju_1=ju_2;
                }
                if(j==par ){
                    par=par+2;
                    tablero[i][j]=ju_1;
                    
                }
                if(j==im){
                    im=im+2;
                    tablero[i][j]=b;
                }
            }
        }
        //restaurar valores
        ju_1="\u001B[31m\u001B[43m X \u001B[0m";
        ju_2="\u001B[31m\u001B[43m O \u001B[0m";
    }
    public void mostrarInfoTabla(){
        mensaje("   0  1  2  3  4  5  6  7\n");
        for(int i=0;i<8;i++){
            //espacio del Jugador 1
            mensaje(i+" ");
            for(int j=0;j<8;j++){
                mensaje(tablero[i][j]);
            }
            System.out.println();
        }
    }
    public void movidasJugador(String jugador){
        int c1,f1,c2,f2;
        boolean resultado=false;
        do{
            do{
                mensaje("\n\nIngrese la posicion actual");
                mensaje("\ncolumna: ");
                c1=scanner.nextInt();
                mensaje("fila: ");
                f1=scanner.nextInt();
            }while(tablero[f1][c1]==vacio || tablero[f1][c1]==b || jugador!=tablero[f1][c1]);
            
            mensaje("\n\nIngrese la posicion nueva");
            mensaje("\ncolumna: ");
            c2=scanner.nextInt();
            mensaje("fila: ");
            f2=scanner.nextInt();  
            resultado=comerFichas(f1, c1, f2, c2);
        }while(tablero[f2][c2]==b || resultado==false);
        tablero[f1][c1]=vacio;
    }
    public boolean comerFichas(int f1, int c1,int f2,int c2){
        if(tablero[f2][c2]==vacio){ 
            tablero[f2][c2]=tablero[f1][c1];
           return true; 
        }else if(tablero[f1][c1]!=tablero[f2][c2]){
            if(c1>c2 && f1<f2){
                if(tablero[f2+1][c2-1]==vacio){
                    tablero[f2+1][c2-1]=tablero[f1][c1];
                    tablero[f2][c2]=vacio;
                    return true;
                }else{return false;}
            }else if(c1>c2 && f1>f2){
                if(tablero[f2-1][c2-1]==vacio){
                    tablero[f2-1][c2-1]=tablero[f1][c1];
                    tablero[f2][c2]=vacio;
                    return true;
                }else{return false;}
            }else if(c1<c2 && f1>f2){
                if(tablero[f2-1][c2+1]==vacio){
                    tablero[f2-1][c2+1]=tablero[f1][c1];
                    tablero[f2][c2]=vacio;
                    return true;
                }else{return false;}
                
            }else{ 
                if(tablero[f2+1][c2+1]==vacio){
                    tablero[f2+1][c2+1]=tablero[f1][c1];
                    tablero[f2][c2]=vacio;
                    return true;
                }else{return false;}
            }
        }else{
            return false;
        }
    }
    public boolean verificarGanador(){
        int fichasX=0;
        int fichasO=0;
        for(int f=0;f<8;f++){
            for(int c=0;c<8;c++){
                if(tablero[f][c]==ju_1){
                    fichasX++;
                }
                if(tablero[f][c]==ju_2){
                    fichasO++;
                }
            }
        }
        if(fichasO==0){
            return true;
        }else if(fichasX==0){
            return true;
        }else {
            return false;
        }
    }
    public void mensaje(String mensaje){
        System.out.print(mensaje);
    }
    
}

