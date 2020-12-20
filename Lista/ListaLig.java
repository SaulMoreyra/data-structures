public class ListaLig
{
    private Nodo cab, ultimo;
   
    public ListaLig(){
        cab=ultimo=null;
    }
    
    public boolean tavacia(){
        return cab==null;
    }
    
    public boolean AgregarIni(char a){
        Nodo n = new Nodo(a,cab);
        if(n==null)  return false;
        cab=n;
        if(ultimo==null)  ultimo=n;
        return true;
    }
    
    public boolean AgregarUlt(char a){
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
    
    public int cuenta(){
        int cont = 0;
        Nodo aux = cab;
        while(aux!=null){
            cont++;
            aux=aux.getSig();
        }
        return cont;
    }
    
    public boolean AgregarEnPos(char x,int pos){
        int cont = 0;
        if(pos<=1){
            AgregarIni(x);
            return true;}
        if(pos>cuenta()){
            AgregarUlt(x);
            return true;}
        if(pos>1 && pos<=cuenta()){
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
    
    public boolean AgregarAntesDe(char x,int pos){
        int cont = 0;
        pos=pos-1;
        if(pos<=1){
            AgregarIni(x); return true;}
        if(pos>cuenta()){
            AgregarUlt(x); return true;}
        if(pos>1 && pos<=cuenta()){
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
    
    public boolean AgregarDespuesDe(char x,int pos){
        int cont = 0;
        pos=pos+1;
        if(pos<=1){  AgregarIni(x);  return true;}
        if(pos>cuenta()){  AgregarUlt(x);   return true;}
        if(pos>1 && pos<=cuenta()){
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
    
    public String EliminarEnPos(int pos){
        String r = "";
        int cont = 0;
        if(pos==1){ r=cab.getDato()+""; cab=cab.getSig();}
        if(pos==cuenta()){
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
        if(pos>1 && pos<cuenta()){
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
    
    public String eliminarDato(char dato){
        int cont=0;
        Nodo aux = cab;
        while(aux!=null){
            cont++;
            if(aux.getDato()==dato)
                return EliminarEnPos(cont);
            aux=aux.getSig();
        }
        return "";
    }
    
    public String getCab(){
        return cab.getDato()+"";
    }
    
    public String getUltimo(){
        return ultimo.getDato()+"";
    }
}