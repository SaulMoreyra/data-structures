import java.io.*;
public class NodoDoble implements Serializable
{
    private Object dato;
    private NodoDoble sig,ant;
    
    public NodoDoble(Object dato,NodoDoble ant, NodoDoble sig){
        this.dato=dato;
        this.sig=sig;
        this.ant=ant;
    }
    public void setDato(Object dato){
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
    public Object getDato(){
        return dato;
    }
    public NodoDoble getSig(){
        return sig;
    }
}
