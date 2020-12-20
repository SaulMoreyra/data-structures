import java.io.*;
public class ListaCDL implements Serializable
{
    private NodoDoble cab, fin;
    private int total=0;
    
    public ListaCDL(){
        cab=fin=null;
    }
    
    private boolean tavacia(){
        return cab==null;
    }
    
    public int getTotal(){
        return total;
    }
    
    public boolean agregarCab(Object o){
        NodoDoble n = new NodoDoble(o,fin,cab);
        if(n==null)
            return false;
        if(tavacia())
            cab=fin=n;
        else
            cab=n;
        fin.setSig(cab);
        cab.getSig().setAnt(cab);
        total++;
        return true;
    }
    
    public boolean agregarFin(Object o){
        NodoDoble n = new NodoDoble(o,fin,cab);
        if(n==null)
            return false;
        if(tavacia())
            return agregarCab(o);
        else{
            fin.setSig(n);
            cab.setAnt(n);
            fin=n;
        }
        total++;
        return true;
    }
    
    public boolean agregarEP(Object o, int p){
        if(p>total+1) return false;
        if(p==1 || tavacia()) return agregarCab(o);
        if(p==total+1) return agregarFin(o);
        NodoDoble aux = cab;
        int cont=0;
        do{
            cont++;
            if(cont==p-1){
                aux.setSig(new NodoDoble(o,aux,aux.getSig()));
                aux.getSig().getSig().setAnt(aux.getSig());
                total++;
                return true;
            }
            aux = aux.getSig();
        }while(aux!=fin);
        return false;
    }
    
    public Object eliminarCab(){
        Object s=null;
        if(!tavacia()){
            s = cab.getDato();
            if(total==1){
                cab=fin=null;
                total=0;
                return s;
            }
            else{
                cab = cab.getSig();
                fin.setSig(cab);
                cab.setAnt(fin);
                total--;
                return s;
            }
        }
        return s;
    }
    
    
    public Object eliminarFin(){
        Object s=null;
        if(!tavacia()){ 
            s = fin.getDato();
            if(total==1){
                fin=cab=null;
                total=0;
                return s;
            }else{
                fin=fin.getAnt();
                fin.setSig(cab);
                cab.setAnt(fin);
                total--;
                return s;
            }    
        }        
        return s;
    }
    
    //  3. ELIMINAR EN POSICION
    public Object eliminarEP(int p){
        if(p==1 || tavacia()) return eliminarCab();
        if(p==total) return eliminarFin();
        NodoDoble aux = cab;
        Object s=null;
        int cont=0;
        do{
            cont++;
            if(cont==p){
                s=aux.getDato();
                aux.getAnt().setSig(aux.getSig());
                aux.getSig().setAnt(aux.getAnt());
                total--;
                return s;
                }
            aux = aux.getSig();
        }while(aux!=fin);
        return s;
    }
    
    public Object dameDatos(int p){
        NodoDoble aux = cab;
        Object s=null;
        int cont=0;
        do{
            cont++;
            if(cont==p){
                s=aux.getDato();
                return s;
                }
            aux = aux.getSig();
        }while(aux!=cab);
        return s;
    }
    
    
}
