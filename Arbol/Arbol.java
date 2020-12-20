import java.text.Normalizer;
import java.io.*;
public class Arbol implements Serializable
{
    NodoArbol ra=null;
    public boolean insertarREC(Persona pe){
        return insertarA(ra,pe);
    }
    
    public NodoArbol getRaiz(){
        return ra;
    }
    
    private boolean insertarA(NodoArbol raiz, Persona pe){
        if(ra==null){
            NodoArbol n = new NodoArbol(null,pe,null); 
            ra=n;
            return true;
        }
        if(raiz==null) return false;
        if(valida(raiz.getDato().getNomComp()).compareTo(valida(pe.getNomComp()))==0){
            return false;
        }
        if(raiz!=null){
            if(valida(raiz.getDato().getNomComp()).compareTo(valida(pe.getNomComp()))>0){
                if(raiz.getIzq()==null){
                    raiz.setIzq(new NodoArbol(null,pe,null));
                    return true;
                }
                return insertarA(raiz.getIzq(),pe);
            }
            if(valida(raiz.getDato().getNomComp()).compareTo(valida(pe.getNomComp()))<0){
                if(raiz.getDer()==null){
                    raiz.setDer(new NodoArbol(null,pe,null));
                    return true;
                }
                return insertarA(raiz.getDer(),pe);
            }
        }
        return true;
    }
    public boolean insertarPor(Persona p,String a){
        NodoArbol n = new NodoArbol(null,p,null);
        if(ra==null){
            ra=n;
            return true;
        }
        if(n==null) return false;
        NodoArbol aux = ra, ant = null;
        while(aux!=null && valida(aux.getDato().getAlgo(a)).compareToIgnoreCase(valida(p.getAlgo(a)))!=0){
            ant=aux;
            if(valida(aux.getDato().getAlgo(a)).compareToIgnoreCase(valida(p.getAlgo(a)))>0)
                aux=aux.getIzq();
            else
                aux=aux.getDer();
        }
        if(aux!=null)   return false;
        if(valida(ant.getDato().getAlgo(a)).compareToIgnoreCase(valida(p.getAlgo(a)))>0)
            ant.setIzq(n);
        else
            ant.setDer(n);
        return true;
    }   
    public String valida(String p){
        String s=null;
        p = Normalizer.normalize(p, Normalizer.Form.NFD);
        s = p.replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        return s;
    }
    public void posOrden(){
        posOrden2(ra);
    }
    private void posOrden2(NodoArbol raiz){
        if(raiz!=null){
            posOrden2(raiz.getIzq());
            posOrden2(raiz.getDer());
            System.out.println(raiz.getDato().toString());
        }
    }
    public void inOrden(){
        System.out.format("%-15s %-15s %-15s %-8s %-8s%n","Paterno","Materno","Nombre","Altura","Edad");
        System.out.println("--------------------------------------------------------------");
        inOrden2(ra);
        System.out.println("--------------------------------------------------------------");
    }
    private void inOrden2(NodoArbol raiz){
        if(raiz!=null){
            inOrden2(raiz.getIzq());
            System.out.print(raiz.getDato().toString());
            inOrden2(raiz.getDer());
        }
    }
    /*Para buscar como ingrese:
     "apaterno", "amaterno", "nombre", "edad","altura"*/
    /*public String buscarPor(String que, String como){
        Archivo a = new Archivo();
        Arbol x = a.cargarTempo(como);
        return buscaPor2(x.getRaiz(),valida(que),como);
    }
    
    public String buscaPor2(NodoArbol raiz, String que, String como){
        if(raiz!=null){
            if(raiz.getDato().getAlgo(como).compareToIgnoreCase(que)==0)
                return raiz.getDato().toString();
            if(raiz.getDato().getAlgo(como).compareToIgnoreCase(que)>0)
                return buscaPor2(raiz.getIzq(),que,como);
            else
                return buscaPor2(raiz.getDer(),que,como);
        }
        return null;
    }*/
}