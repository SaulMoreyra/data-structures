public class NodoAvl
{
    NodoAvl izq, der;
    int dato;
    int fe=0;
    
    public NodoAvl(NodoAvl izq, int dato, NodoAvl der){
        this.izq=izq;
        this.der=der;
        this.dato=dato;
    }    
    
    public void setDer(NodoAvl der){
        this.der=der;
    }
    public void setIzq(NodoAvl izq){
        this.izq=izq;
    }
    public void setDato(int dato){
        this.dato=dato;
    }
    public NodoAvl getIzq(){
        return izq;
    }
    public NodoAvl getDer(){
        return der;
    }
    public int getDato(){
        return dato;
    }
}
