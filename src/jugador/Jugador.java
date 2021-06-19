package src.jugador;
public class Jugador {
    private String nombre;
    
    public Jugador(String nombre){
        this.nombre=nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getInformacion(){
        return "Nombre: "+nombre;
    }
}
