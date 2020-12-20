public class Nodo
{
    private Object dato;
    private Nodo sig;
    
    public Nodo(Object dato, Nodo sig){
        this.dato=dato;
        this.sig=sig;
    }
    public void setDato(Object dato){
        this.dato=dato;
    }
    public void setSig(Nodo sig){
        this.sig=sig;
    }
    public Object getDato(){
        return dato;
    }
    public Nodo getSig(){
        return sig;
    }
}

