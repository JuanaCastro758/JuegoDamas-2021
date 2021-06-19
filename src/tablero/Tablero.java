package src.tablero;
public class Tablero{
    
    
    //espacios en el tablero
    public void pintarTablero(int jugador,int fila,int columna){
        //signo del sugador 1
        String ju_1="\u001B[31m\u001B[43m X \u001B[0m";
        //spacio vacio
        String vacio="\u001B[31m\u001B[43m   \u001B[0m";
        //signo jugador 2
        String ju_2="\u001B[31m\u001B[43m O \u001B[0m";
        String b="\u001B[47m   \u001B[0m";
        for(int i=0;i<8;i++){
            int par=0;
            int im=1;
            String aux=ju_1;
            ju_1=b;
            b=aux;
            for(int j=0;j<8;j++){
                if(j==par && i==3){
                    ju_1=vacio;
                }
                if(j==par && i==5){
                    ju_1=ju_2;
                }
                if(j==par ){
                    System.out.print(ju_1);
                    par=par+2;
                    
                }
                if(j==im){
                    System.out.print(b);
                    im=im+2;
                }
            }
            System.out.println();
        }
    }
}
