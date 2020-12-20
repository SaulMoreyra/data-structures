public class Nodo
{
    private char dato;
    private Nodo sig;
    
    public Nodo(char dato, Nodo sig){
        this.dato=dato;
        this.sig=sig;
    }
    public void setDato(char dato){
        this.dato=dato;
    }
    public void setSig(Nodo sig){
        this.sig=sig;
    }
    public char getDato(){
        return dato;
    }
    public Nodo getSig(){
        return sig;
    }
}
