public class PilaLig
{
    private Nodo tope;
    public PilaLig(){
        tope=null;
    }
    
    public boolean push(Object o){
        Nodo n = new Nodo(o,tope);
        if(n==null)
            return false;
        tope=n;
        return true;
    }
    
    public boolean tavacia(){
        return tope==null;
    }
    
    public Object pop(){
        if(tope==null)
            return null;
            
        Object o = tope.getDato();
        tope = tope.getSig();
        return o;
    }
    
    public int length(){
        Nodo b = tope;
        int cont = 0;
        while(b!=null){
            cont++;
            b = b.getSig();
        }
        return cont;
    }   
    
    public String toString(){
        Nodo b = tope;
        String cont = "";
        while(b!=null){
            cont += b.getDato()+" ";
            b = b.getSig();
        }
        return cont;
    }
}
 