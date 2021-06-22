package src.tablero;
public class Tablero{
    private int jugadasGanadas;
    private int jugadasPerdidas;
    
    public Tablero(int jugadasGanadas,int jugadasPerdidas){
        this.jugadasGanadas=jugadasGanadas;
        this.jugadasPerdidas=jugadasPerdidas;
    }
    
    public int getJugadasGanadas() {
        return jugadasGanadas;
    }

    public void setJugadasGanadas(int jugadasGanadas) {
        this.jugadasGanadas = jugadasGanadas;
    }

    public int getJugadasPerdidas() {
        return jugadasPerdidas;
    }

    public void setJugadasPerdidas(int jugadasPerdidas) {
        this.jugadasPerdidas = jugadasPerdidas;
    }
    
    public String jugadasInfo(){
        return "Juegos Ganados: "+jugadasGanadas+"  Juegos Perdidas: "+jugadasPerdidas;
    }
}

