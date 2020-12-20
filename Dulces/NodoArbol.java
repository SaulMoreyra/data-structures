import java.io.*;
public class NodoArbol implements Serializable
{
    NodoArbol izq, der;
    int id, refe;
    
    public NodoArbol(NodoArbol izq, int id,int refe ,NodoArbol der){
        this.izq    =   izq;
        this.der    =   der;
        this.id     =   id;
        this.refe   =   refe;
    }    
    
    public void setDer(NodoArbol der){
        this.der=der;
    }
    public void setIzq(NodoArbol izq){
        this.izq=izq;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setRefe(int refe){
        this.refe=refe;
    }
    public NodoArbol getIzq(){
        return izq;
    }
    public NodoArbol getDer(){
        return der;
    }
    public int getId(){
        return id;
    }
    public int getRefe(){
        return refe;
    }
}
