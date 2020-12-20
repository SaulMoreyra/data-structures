public class ListaCDL
{
    public NodoDoble cab, fin;
    public ListaCDL(){
        cab=fin=null;
    }
    
    private boolean tavacia(){
        return cab==null;
    }
    
    //CUENTA LOS ELEMENTOS EXISTENTES
    private int contar(){
        int cont=0;
        if(!tavacia()){
            NodoDoble aux = cab;
            do{
                cont++;
                aux = aux.getSig();
            }while(aux!=cab);
                
        }
        return cont;
    }
    
    //BUSCA EL DATO QUE SE LE INIDIQUE
    public int buscarDato(String o){
        int cont=0;
        NodoDoble aux=cab;
        if(!tavacia()){
            do{
                cont++;
                if(aux.getDato().getNombre().equalsIgnoreCase(o)){
                    return cont;
                }
                aux = aux.getSig();
            }while(aux!=cab);
            
        }
        return 0;
    } 
    
    
    //METODOS QUE SE PIDIERON
    
    //  1. AGREGA EN CABECERA 
    public boolean agregarCab(Persona o){
        NodoDoble n = new NodoDoble(o,fin,cab);
        if(n==null)
            return false;
        if(tavacia())
            cab=fin=n;
        else
            cab=n;
        fin.setSig(cab);
        cab.getSig().setAnt(cab);
        return true;
    }
    
    //  2. AGREGA AL FINAL
    public boolean agregarFin(Persona o){
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
        return true;
    }
    
    //  3. AGREGA EN LA POSICION QUE SE LE INDIQUE
    public boolean agregarEP(Persona o, int p){
        if(p>contar()+1) return false;
        if(p==1 || tavacia()) return agregarCab(o);
        if(p==contar()+1) return agregarFin(o);
        NodoDoble aux = cab;
        int cont=0;
        do{
            cont++;
            if(cont==p-1){
                aux.setSig(new NodoDoble(o,aux,aux.getSig()));
                aux.getSig().getSig().setAnt(aux.getSig());
                return true;
            }
            aux = aux.getSig();
        }while(aux!=fin);
        return false;
    }
    
    //  4. AGREGA ANTES DE CIERTO DATO
    public boolean agregarAD(String antesde, Persona dato){
        int x = buscarDato(antesde);
        if(x==0){
            System.out.println("El dato no existe en la lista");
            return false;
        }
        return agregarEP(dato,x);
    }
        
    
    //  1. ELIMINAR CABECERA
    public String eliminarCab(){
        String s=null;
        if(!tavacia()){
            s = cab.getDato().getNombre()+"";
            if(contar()==1){
                cab=fin=null;
                return s;
            }
            else{
                cab = cab.getSig();
                fin.setSig(cab);
                cab.setAnt(fin);
                return s;
            }
        }
        return s;
    }
    
    //  2. ELIMINAR FINAL
    public String eliminarFin(){
        String s=null;
        if(!tavacia()){ 
            s = fin.getDato().getNombre();
            if(contar()==1){
                fin=cab=null;
                return s;
            }else{
                fin=fin.getAnt();
                fin.setSig(cab);
                cab.setAnt(fin);
                return s;
            }    
        }        
        return s;
    }
    
    //  3. ELIMINAR EN POSICION
    public String eliminarEP(int p){
        if(p==1 || tavacia()) return eliminarCab();
        if(p==contar()) return eliminarFin();
        NodoDoble aux = cab;
        String s=null;
        int cont=0;
        do{
            cont++;
            if(cont==p){
                s=aux.getDato().getNombre();
                aux.getAnt().setSig(aux.getSig());
                aux.getSig().setAnt(aux.getAnt());
                return s;
                }
            aux = aux.getSig();
        }while(aux!=fin);
        return s;
    }
    
    // 4. ELIMINAR UN DATO
    public String eliminaDato(String s){
        int x=buscarDato(s);
        if(x==0)
            return "El dato no existe prueba con otro";
        return eliminarEP(x);
    }
    
    public void imprimeDatos(){
        String s ="\n";
        int cont=0;
        if(!tavacia()){
            NodoDoble aux = cab;
            if(contar()>1){
                do{
                    cont++;
                    s+=cont+".-  "+aux.getDato().getNombre()+"\n";
                    aux = aux.getSig();
                }while(aux!=cab);
            }else{
                s="\n"+(cont+1)+".-  "+aux.getDato().getNombre();
            }
            
        }
        System.out.println((s=="\n")? "No hay nada": s);
    }
    
    
}