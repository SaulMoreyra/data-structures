public class ListaLig
{
    private Nodo cab, ultimo;
   
    public ListaLig(){
        cab=ultimo=null;
    }
    
    public boolean tavacia(){
        return cab==null;
    }
    
    public boolean agregarInicio(int a){
        Nodo n = new Nodo(a,cab);
        if(n==null)  return false;
        cab=n;
        if(ultimo==null)  ultimo=n;
        return true;
    }
    
    public boolean agregarUltimo(int a){
        Nodo n = new Nodo(a,null);
        if(n==null)  return false;
        if(ultimo==null)  cab=ultimo=n;
        else  ultimo.setSig(n);
        ultimo = n;
        return true;
    }
    
    public String toString(){
        Nodo aux = cab;
        String cad = "";
        while(aux!=null){
            cad+=aux.getDato()+" ";
            aux=aux.getSig();
        }
        return cad;
    }
    
    public int contar(){
        int cont = 0;
        Nodo aux = cab;
        while(aux!=null){
            cont++;
            aux=aux.getSig();
        }
        return cont;
    }
    
    public boolean agregarPos(int x,int pos){
        int cont = 0;
        if(pos<=1){
            agregarInicio(x);
            return true;}
        if(pos>contar()){
            agregarUltimo(x);
            return true;}
        if(pos>1 && pos<=contar()){
            Nodo aux = cab;
            while(aux!=null){
                cont++;
                if(cont == pos-1)  
                aux.setSig(new Nodo(x,aux.getSig()));
                aux=aux.getSig();
            }
            return true;
        }
        return false;
    }
    
    public boolean agregarAntesDe(int x,int pos){
        int cont = 0;
        pos=pos-1;
        if(pos<=1){
            agregarInicio(x); return true;}
        if(pos>contar()){
            agregarUltimo(x); return true;}
        if(pos>1 && pos<=contar()){
            Nodo aux = cab;
            while(aux!=null){
                cont++;
                if(cont == pos-1)
                    aux.setSig(new Nodo(x,aux.getSig()));
                aux=aux.getSig();
            }
            return true;
        }
        return false;
    }
    
    public boolean agregarDespuesDe(int x,int pos){
        int cont = 0;
        pos=pos+1;
        if(pos<=1){  agregarInicio(x);  return true;}
        if(pos>contar()){  agregarUltimo(x);   return true;}
        if(pos>1 && pos<=contar()){
            Nodo aux = cab;
            while(aux!=null){
                cont++;
                if(cont == pos-1)   
                aux.setSig(new Nodo(x,aux.getSig()));
                aux=aux.getSig();
            }
            return true;
        }
        return false;
    }
    
    public String eliminarPos(int pos){
        String r = "";
        int cont = 0;
        if(pos==1){ r=cab.getDato()+""; cab=cab.getSig();}
        if(pos==contar()){
            Nodo aux = cab;
            while(aux!=null){
                cont++;
                if(cont==pos-1){
                    r=ultimo.getDato()+"";
                    aux.setSig(null);
                    ultimo = aux;
                }
                aux=aux.getSig();
            }
            return r;
            }
        if(pos>1 && pos<contar()){
            Nodo aux = cab;
            while(aux!=null){
                cont++;
                if(cont == pos-1){
                    r = aux.getSig().getDato()+"";
                    aux.setSig(aux.getSig().getSig());
                }
                aux=aux.getSig();
            }
            return r;
        }
        return "No hay";
    }
    
    public String eliminarDato(int dato){
        int cont=0;
        Nodo aux = cab;
        while(aux!=null){
            cont++;
            if(aux.getDato()==dato)
                return eliminarPos(cont);
            aux=aux.getSig();
        }
        return "No existe";
    }
    
    public String getCab(){
        return cab.getDato()+"";
    }
    
    public String getUltimo(){
        return ultimo.getDato()+"";
    }
}