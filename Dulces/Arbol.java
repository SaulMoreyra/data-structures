import java.text.Normalizer;
import java.io.*;
public class Arbol implements Serializable
{
    NodoArbol ra=null;
    public boolean insertarREC(int pe,int refe){
        return insertarA(ra,pe,refe);
    }
    
    public NodoArbol getRaiz(){
        return ra;
    }
    
    private boolean insertarA(NodoArbol raiz, int id, int refe){
        if(ra==null){
            NodoArbol n = new NodoArbol(null,id,refe,null); 
            ra=n;
            return true;
        }
        if(raiz==null) return false;
        if(raiz.getId()==id){
            return false;
        }
        if(raiz!=null){
            if(raiz.getId()>id){
                if(raiz.getIzq()==null){
                    raiz.setIzq(new NodoArbol(null,id,refe,null));
                    return true;
                }
                return insertarA(raiz.getIzq(),id,refe);
            }
            if(raiz.getId()<id){
                if(raiz.getDer()==null){
                    raiz.setDer(new NodoArbol(null,id,refe,null));
                    return true;
                }
                return insertarA(raiz.getDer(),id,refe);
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
            System.out.println(String.format("%-10s %-10s%n",raiz.getId(),raiz.getRefe()));
        }
    }
    public void inOrden(){
        System.out.println("\n------------------------");
        System.out.print(String.format("%-10s %-10s%n","ID","Posicion"));
        System.out.println("------------------------");
        inOrden2(ra);
        System.out.println("------------------------");
    }
    private void inOrden2(NodoArbol raiz){
        if(raiz!=null){
            inOrden2(raiz.getIzq());
               System.out.print(String.format("%-10s %-10s%n",raiz.getId(),raiz.getRefe()));
            inOrden2(raiz.getDer());
        }
    }
    public boolean buscarA(int i){
        return buscarArbol(ra,i);
    }
    private boolean buscarArbol(NodoArbol r, int i){
        if(r != null){
            if(r.getId()==i) return true;
            if(r.getId()>i){
                return buscarArbol(r.getIzq(),i);
            }
            else{
                return buscarArbol(r.getDer(),i);
            }
        }
        return false;
    }
    
    public boolean Eliminar(int x)
    {
        NodoArbol aux=ra;
        NodoArbol ant=null;
        
        while(aux!=null&& aux.getId()!=x)
        {
            ant=aux;
            if(aux.getId()>x)
                aux=aux.getIzq();
            else
                aux=aux.getDer();
        }
        
        if(aux!=null)
        {
            if(aux==ra)
                ra=BorrarNodo(aux);
            else
            {
                if(ant.getIzq()==aux)
                    ant.setIzq(BorrarNodo(aux));
                else
                    ant.setDer(BorrarNodo(aux));
            }
            return true;
        }
        return false;
    }
    
    private NodoArbol BorrarNodo(NodoArbol n)
    {
        if(n.getIzq()==null)
        return n.getDer();
        else
        {
            if(n.getDer()==null)
            return n.getIzq();
            else
            {
                NodoArbol aux= n.getDer(), ante=null;
                while(aux.getIzq()!=null)
                {
                    ante=aux;
                    aux=aux.getIzq();
                }
                n.setId(aux.getId());
                if(ante!=null)
                ante.setIzq(aux.getDer());
                else
                n.setDer(aux.getDer());
                return n;
            }
        }
    }
    
    public boolean Eliminar2(int x)
    {
        NodoArbol aux=ra;
        NodoArbol ant=null;
        
        while(aux!=null&& aux.getId()!=x)
        {
            ant=aux;
            if(aux.getId()>x)
                aux=aux.getIzq();
            else
                aux=aux.getDer();
        }
        
        if(aux!=null)
        {
            if(aux==ra)
                ra=BorrarNodo2(aux);
            else
            {
                if(ant.getIzq()==aux)
                    ant.setIzq(BorrarNodo2(aux));
                else
                    ant.setDer(BorrarNodo2(aux));
            }
            return true;
        }
        return false;
    }
      
    private NodoArbol BorrarNodo2(NodoArbol n)
    {
        if(n.getIzq()==null)
        return n.getDer();
        else
        {
            if(n.getDer()==null)
            return n.getIzq();
            else
            {
                NodoArbol aux= n.getIzq(), ante=null;
                while(aux.getDer()!=null)
                {
                    ante=aux;
                    aux=aux.getDer();
                }
                n.setId(aux.getId());
                if(ante!=null)
                ante.setDer(aux.getIzq());
                else
                n.setIzq(aux.getIzq());
                return n;
            }
        }
    }
    
    public int buscarCod(int i){
        return buscarArbolCod(ra,i);
    }
    private int buscarArbolCod(NodoArbol r, int i){
        if(r != null){
            if(r.getId()==i) return r.getRefe();
            if(r.getId()>i){
                return buscarArbolCod(r.getIzq(),i);
            }
            else{
                return buscarArbolCod(r.getDer(),i);
            }
        }
        return 0;
    }
}