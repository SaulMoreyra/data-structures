public class ListaCL
{
    public Nodo cab, fin;
    public ListaCL(){
        cab=fin=null;
    }
    
    private boolean isVacia(){
        return cab==null;
    }
    
    public Nodo getFin(){ return fin;}
    public Nodo getCab(){ return cab;}
    
    public boolean agregarCab(Object o){
        Nodo n = new Nodo(o,cab);
        if(n==null)
            return false;
        if(isVacia())
            cab=fin=n;
        else{
            n.setSig(cab);
            cab=n;
        }
        fin.setSig(cab);
        return true;
    }
    
    public boolean agregarFin(Object o){
        Nodo n = new Nodo(o,cab);
        if(n==null)
            return false;
        if(isVacia())
            return agregarCab(o);
        else{
            fin.setSig(n);
            fin=n;
        }
        return true;
    }
        
    public void imprimeDatos(){
        String s ="";
        int cont=0;
        if(!isVacia()){
            Nodo aux = cab;
            if(contar()>1){
                do{
                    s+=aux.getDato().toString();
                    aux = aux.getSig();
                }while(aux!=cab);
            }else{
                s=aux.getDato().toString();
            }
            
        }
        System.out.println((s=="")? "No hay nada": s);
    }
    
    public int contar(){
        int cont=0;
        if(!isVacia()){
            Nodo aux = cab;
            do{
                cont++;
                aux = aux.getSig();
            }while(aux!=cab);
                
        }
        return cont;
    }
    
    public Object eliminarCab(){
        Object s=null;
        if(!isVacia()){
            s = cab.getDato();
            if(contar()>1){
                cab = cab.getSig();
                fin.setSig(cab);
            }
            else{
                cab=fin=null;
            }
        }
        return s;
    }
    
    public Object eliminarFin(){
        Object s=null;
        Nodo aux = cab;
        if(!isVacia()){ 
            s = fin.getDato();
            if(contar()==1){
                fin=cab=null;
                return s;
            }
            if(contar()==2){
                cab.setSig(cab);
                fin=cab;
                return s;
            }else{
                do{
                    if(aux.getSig()==fin){
                        aux.setSig(cab);
                        fin=aux;
                        break;
                    }
                    aux = aux.getSig();
                }while(aux!=fin);
            }
        }
        return s;
    }    
    
    
     public Object eliminarEP(int p){
        if(p==1) return eliminarCab();
        if(p==contar()) return eliminarFin();
        Object s=null;
        Nodo aux = cab;
        int cont=0;
        do{
            cont++;
            if(cont==p-1){
                s=aux.getSig().getDato();
                aux.setSig(aux.getSig().getSig());
                break;
            }
            aux = aux.getSig();
        }while(aux!=fin);
        return s;
    }
    
    private int buscarDato(Object o){
        int cont=0;
        Nodo aux=cab;
        if(!isVacia()){
            do{
                cont++;
                if(aux.getDato()==o){
                    return cont;
                }
                aux = aux.getSig();
            }while(aux!=cab);
            
        }
        return cont;
    } 
    
    public Object eliminaDato(Object o){
        return eliminarEP(buscarDato(o));
    }
    
}