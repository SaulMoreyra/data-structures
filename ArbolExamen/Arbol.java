import java.text.Normalizer;
import java.io.*;
public class Arbol implements Serializable
{
    NodoArbol ra=null;
    public boolean insertarREC(int pe){
        return insertarA(ra,pe);
    }
    
    public NodoArbol getRaiz(){
        return ra;
    }
    
    private NodoLig agregaRepe(int r, NodoLig nl){
        NodoLig r2 = nl.getSig();
        if(r2==null){
            nl.setSig(new NodoLig(r,null));
        }
        else
            return agregaRepe(r,r2);
        return nl;
    }
    
    private boolean insertarA(NodoArbol raiz, int pe){
        if(ra==null){
            NodoArbol n = new NodoArbol(null,new NodoLig(pe,null),null); 
            ra=n;
            return true;
        }
        if(raiz==null) return false;
        if(raiz.getDato().getDato()==pe){
            raiz.setDato(agregaRepe(pe,raiz.getDato()));
            return true;
        }
        if(raiz!=null){
            if(raiz.getDato().getDato()>pe){
                if(raiz.getIzq()==null){
                    raiz.setIzq(new NodoArbol(null,new NodoLig(pe,null),null));
                    return true;
                }
                return insertarA(raiz.getIzq(),pe);
            }
            if(raiz.getDato().getDato()<pe){
                if(raiz.getDer()==null){
                    raiz.setDer(new NodoArbol(null,new NodoLig(pe,null),null));
                    return true;
                }
                return insertarA(raiz.getDer(),pe);
            }
        }
        return true;
    }
    public void posOrden(){
        posOrden2(ra);
    }
    private void posOrden2(NodoArbol raiz){
        if(raiz!=null){
            posOrden2(raiz.getIzq());
            posOrden2(raiz.getDer());
            System.out.println(raiz.getDato().getDato());
        }
    }
    public void inOrden(){
        inOrden2(ra);
    }
    private void inOrden2(NodoArbol raiz){
        if(raiz!=null){
            inOrden2(raiz.getIzq());
            System.out.print(raiz.getDato().getDato());
            inOrden2(raiz.getDer());
        }
    }
    
}