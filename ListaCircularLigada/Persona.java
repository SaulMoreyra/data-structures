public class Persona
{
    private int identificador;
    private Silla silla;
    public Persona(int identificador){
        this.identificador = identificador;
    }
    
    public void setIdentificador(int identificador){
       this.identificador = identificador;
    }
    
    public int getIdentificador(){ 
        return identificador;
    }
    
    public void sentarse(Silla s){
        this.silla = s;
    }
    
    public void pararse(){
        this.silla = null;
    }
    
    public boolean estaSentada(){
        return this.silla != null;
    }
    
    public String toString(){
        return "Persona "+identificador + " esta " + (estaSentada() ? "sentada" : "parada") + "\n";
    }
}