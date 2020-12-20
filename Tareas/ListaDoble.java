public class ListaDoble
{
    private NodoDoble fin, cab;
    public ListaDoble(){
        fin=cab=null;
    }
    public boolean agregarCab(int o){
        NodoDoble n = new NodoDoble(o,null,cab);
        if(n==null) return false;
        if(cab==null) fin=cab=n;
        else{
            cab.setAnt(n);
            cab=n;
        }
        return true;
    }
    
    public boolean agregarFin(int o){
        NodoDoble n = new NodoDoble(o,fin,null);
        if(n==null) return false;
        if(cab==null){
            cab=fin=n;
            return true;
        }else{
            fin.setSig(n);
            fin=n;
        }
        return true;
    
    }
    
    public int contar(){
        NodoDoble aux = cab;
        int cont =0;
        while(aux!=null){
            cont++;
            aux=aux.getSig();
        }
        return cont;
    }
    
    public boolean agregarEnX(int o,int pos){
        if(pos<=1)  return agregarCab(o);
        if(pos>=contar()) return agregarFin(o);
        NodoDoble aux = cab;
        int cont =0;
        while(aux!=null){
            cont++;
            if(cont==pos-1){
                NodoDoble n = new NodoDoble(o,aux,aux.getSig());
                if(n!=null){
                    aux.setSig(n);
                    aux.getSig().getSig().setAnt(n);
                    return true;
                }
            }
            aux=aux.getSig();
        }
        return false;
    }
    
    public boolean agregarAD(int o,int pos){
        if(pos<=1)  return agregarCab(o);
        if(pos>contar()) return agregarFin(o);
        NodoDoble aux = cab;
        int cont =0;
        while(aux!=null){
            cont++;
            if(cont==pos-1){
                NodoDoble n = new NodoDoble(o,aux,aux.getSig());
                if(n!=null){
                    aux.setSig(n);
                    aux.getSig().getSig().setAnt(n);
                    return true;
                }
            }
            aux=aux.getSig();
        }
        return false;
    }
    
    public boolean agregarAntesDe(int dato,int da){
        int cont=0;
        NodoDoble aux = cab;
        while(aux!=null){
            cont++;
            if(aux.getDato()==dato){
                break;
            }
            aux=aux.getSig();
        }
        return agregarAD(da,cont);
    }
    
    public String toString(){
        NodoDoble aux = cab;
        String cad = "";
        while(aux!=null){
            cad+=aux.getDato()+" ";
            aux=aux.getSig();
        }
        return cad;
    }
}

