import java.io.*;
public class NodoA implements Serializable
{
    NodoA izq, der, repe=null;
    int dato;
    
    public NodoA(NodoA izq, int dato, NodoA der){
        this.izq=izq;
        this.der=der;
        this.dato=dato;
    }    
    
    public void setRepe(NodoA repe){
        this.repe=repe;
    }
    public void setDer(NodoA der){
        this.der=der;
    }
    public void setIzq(NodoA izq){
        this.izq=izq;
    }
    public void setDato(int dato){
        this.dato=dato;
    }
    public NodoA getRepe(){
        return repe;
    }
    public NodoA getIzq(){
        return izq;
    }
    public NodoA getDer(){
        return der;
    }
    public int getDato(){
        return dato;
    }
}
