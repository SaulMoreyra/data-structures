import java.io.*;
public class NodoArbol implements Serializable
{
    NodoArbol izq, der;
    NodoLig dato;
    
    public NodoArbol(NodoArbol izq, NodoLig dato, NodoArbol der){
        this.izq=izq;
        this.der=der;
        this.dato=dato;
    }    
    
    public void setDer(NodoArbol der){
        this.der=der;
    }
    public void setIzq(NodoArbol izq){
        this.izq=izq;
    }
    public void setDato(NodoLig dato){
        this.dato=dato;
    }
    public NodoArbol getIzq(){
        return izq;
    }
    public NodoArbol getDer(){
        return der;
    }
    public NodoLig getDato(){
        return dato;
    }
}
