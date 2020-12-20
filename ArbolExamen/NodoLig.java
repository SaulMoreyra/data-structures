public class NodoLig
{
    private int dato;
    private NodoLig sig;
    
    public NodoLig(int dato, NodoLig sig){
        this.dato=dato;
        this.sig=sig;
    }
    public void setDato(int dato){
        this.dato=dato;
    }
    public void setSig(NodoLig sig){
        this.sig=sig;
    }
    public int getDato(){
        return dato;
    }
    public NodoLig getSig(){
        return sig;
    }
}
