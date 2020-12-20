
public class ArbolA
{
    NodoA ra=null;
    public boolean insertarREC(int pe){
        return insertarA(ra,pe);
    }
    
    public NodoA getRaiz(){
        return ra;
    }
    
    private NodoA agregaRepe(int r, NodoA nl){
        NodoA r2 = nl.getRepe();
        if(r2==null){
            nl.setRepe(new NodoA(null,r,null));
        }
        else
            return agregaRepe(r,r2);
        return nl;
    }
    
    private boolean insertarA(NodoA raiz, int pe){
        if(ra==null){
            NodoA n = new NodoA(null,pe,null); 
            ra=n;
            return true;
        }
        if(raiz==null) return false;
        if(raiz.getDato()==pe){
            raiz = agregaRepe(pe,raiz);
            return true;
        }
        if(raiz!=null){
            if(raiz.getDato()>pe){
                if(raiz.getIzq()==null){
                    raiz.setIzq(new NodoA(null,pe,null));
                    return true;
                }
                return insertarA(raiz.getIzq(),pe);
            }
            if(raiz.getDato()<pe){
                if(raiz.getDer()==null){
                    raiz.setDer(new NodoA(null,pe,null));
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
    private void posOrden2(NodoA raiz){
        if(raiz!=null){
            posOrden2(raiz.getIzq());
            posOrden2(raiz.getDer());
            System.out.println(raiz.getDato());
        }
    }
    public void inOrden(){
        inOrden2(ra);
    }
    private void inOrden2(NodoA raiz){
        if(raiz!=null){
            inOrden2(raiz.getIzq());
            System.out.print(raiz.getDato());
            inOrden2(raiz.getDer());
        }
    }
    
}