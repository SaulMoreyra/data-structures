public class NodoDoble
{
    private int dato;
    private NodoDoble sig,ant;
    
    public NodoDoble(int dato,NodoDoble ant, NodoDoble sig){
        this.dato=dato;
        this.sig=sig;
        this.ant=ant;
    }
    public void setDato(int dato){
        this.dato=dato;
    }
    public void setSig(NodoDoble sig){
        this.sig=sig;
    }
    public void setAnt(NodoDoble ant){
        this.ant=ant;
    }
    public NodoDoble getAnt(){
        return ant;
    }
    public int getDato(){
        return dato;
    }
    public NodoDoble getSig(){
        return sig;
    }
}
