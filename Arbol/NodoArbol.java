import java.io.*;
public class NodoArbol implements Serializable
{
    NodoArbol izq, der;
    Persona dato;
    
    public NodoArbol(NodoArbol izq, Persona dato, NodoArbol der){
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
    public void setDato(Persona dato){
        this.dato=dato;
    }
    public NodoArbol getIzq(){
        return izq;
    }
    public NodoArbol getDer(){
        return der;
    }
    public Persona getDato(){
        return dato;
    }
}
