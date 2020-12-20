import java.io.*;
public class ArbolAvl
{
    private NodoAvl Raiz;
    public ArbolAvl(){
        Raiz=null;
    }
    public void InsertarNum(int Numero)throws Exception{
        Logical h=new Logical(false);//intercambia un valor booleano
        Raiz=InsertarAvl(Raiz, Numero, h);
    }
    private NodoAvl InsertarAvl(NodoAvl raiz, int valor, Logical h)throws Exception{
        NodoAvl n1;
        if(raiz==null) 
        { 
            raiz= new NodoAvl(null,valor,null);
            h.setLogical(true);
        }else if(valor<raiz.getDato())
        {
            NodoAvl iz;
            iz=InsertarAvl((NodoAvl) raiz.getIzq(), valor, h);
            raiz.setIzq(iz);
            if(h.booleanValue())
            {
                //decrementa
                switch(raiz.fe)
                {
                    case 1: raiz.fe=0;
                    h.setLogical(false);
                    break;
                    case 0: raiz.fe=-1;
                    break;
                    case -1: //aplicar rot iz
                    n1=(NodoAvl)raiz.getIzq();
                    if(n1.fe==-1)
                    {
                        raiz=rotacionII(raiz, n1);
                    }
                    else
                    {
                        raiz=rotacionID(raiz,n1); 
                    }
                    h.setLogical(false);
                }
            }
        }else if(valor >raiz.getDato()) 
        {
            NodoAvl dr;
            dr= InsertarAvl((NodoAvl)raiz.getDer(), valor, h);
            raiz.setDer(dr);//regreso por los nodos del camino bu
            if(h.booleanValue())
            {
                //incrementa el fe
                switch(raiz.fe) 
                {
                    case 1: // rotación a la der
                    n1=(NodoAvl)raiz.getDer();
                    if(n1.fe==+1)
                    {
                        raiz=rotacionDD(raiz, n1); 
                    }
                    else
                    {
                        raiz= rotacionDI(raiz, n1); 
                    }
                    h.setLogical(false);
                    break;
                    case 0: raiz.fe=+1;
                    break;
                    case-1: raiz.fe=0;
                    h.setLogical(false);
                }
            }
        }
        else
        { 
            throw new Exception ("No puede haber claves repetidas");
        }
        return raiz;
    }
    private NodoAvl rotacionII(NodoAvl n, NodoAvl n1){
        n.setIzq(n1.getDer());
        n1.setDer(n);//actualización de los factores de equilibrio
        if(n1.fe==-1){//se cumple en la inserción
            n.fe=0;
            n1.fe=0;
        }else{
            n.fe=-1;
            n1.fe=1;
        }
        return n1;
    }//fi rotacion II
    private NodoAvl rotacionDD(NodoAvl n, NodoAvl n1){
        n.setDer(n1.getIzq());
        n1.setIzq(n);
        //actualización de los factores de equilibrio
        if(n1.fe==+1){
            n.fe=0;
            n1.fe=0;
        }else{
            n.fe=+1;
            n1.fe=-1;
          }
        return n1;
    }//fin rotacion DD
    private NodoAvl rotacionID(NodoAvl n, NodoAvl n1){
        NodoAvl n2;
        n2=(NodoAvl)n1.getDer();
        n.setIzq(n2.getDer());
        n2.setDer(n);
        n1.setDer(n2.getIzq());
        n2.setIzq(n1);
        //actualizacón de factores de equilibrio;
        if(n2.fe==+1){
            n1.fe=-1;
        }else{
            n1.fe=0;
        }
        if(n2.fe==-1){
            n.fe=1;
        }else{
            n.fe=0;
        }
        n2.fe=0;
        return n2;
    }//fin de la rotación ID
    private NodoAvl rotacionDI(NodoAvl n, NodoAvl n1){
        NodoAvl n2;
        
        n2=(NodoAvl)n1.getIzq();
        n.setDer(n2.getIzq());
        n2.setIzq(n);
        n1.setIzq(n2.getDer());
        n2.setDer(n1);
        //actualización de los facteres de equilibrio;
        if(n2.fe==+1){
            n.fe=-1;
        }else{
            n.fe=0;
        }
        if(n2.fe==-1){
            n1.fe=1;
        }else{
            n1.fe=0;
        }
        n2.fe=0;
        return n2;
    }//fin de la rotación DI
    public void EliminarNum(int valor)throws Exception{
        Logical flag=new Logical(false);
        Raiz=Borrar(Raiz, valor, flag);
    }
    private NodoAvl Borrar(NodoAvl r, int clave, Logical cambiaAltura) throws Exception{
        if(r==null){
            throw new Exception("Nodo no encontrado");
        }
        else if(clave<r.getDato())
        {
            NodoAvl iz;
            iz=Borrar((NodoAvl) r.getIzq(), clave, cambiaAltura);
            r.setIzq(iz);
            if(cambiaAltura.booleanValue()) 
            {
                r=equilibrar1(r,cambiaAltura);
            }
        }
        else if(clave>r.getDato())
        {
            NodoAvl dr;
            dr=Borrar((NodoAvl) r.getDer(), clave, cambiaAltura);
            r.setDer(dr);
            if(cambiaAltura.booleanValue())
            {
                r=equilibrar2(r,cambiaAltura);
            }
        }
        else//Nodo encontrado
        {
            NodoAvl q;
            q= r;//Nodo a quitar del árbol;
            if(q.getIzq()==null)
            {
                r=(NodoAvl)q.getDer();
                cambiaAltura.setLogical(true);
            }
            else if(q.getDer()==null)
            {
                r=(NodoAvl)q.getIzq();
                cambiaAltura.setLogical(true);
            }
            else
            {
                //Tiene rama iz y der
                NodoAvl iz;
                iz= reemplazar(r,(NodoAvl)r.getIzq(),cambiaAltura);
                r.setIzq(iz);
                if(cambiaAltura.booleanValue())
                {
                    r=equilibrar1(r, cambiaAltura);
                }
            }
            q=null;
        }
        return r;
    }
    
    private NodoAvl reemplazar(NodoAvl n, NodoAvl act, Logical cambiaAltura)
    {
        if(act.getDer()!=null)
        {
            NodoAvl d;
            d=reemplazar(n,(NodoAvl) act.getDer(),cambiaAltura);
            act.setDer(d);
            if(cambiaAltura.booleanValue())
            {
                act=equilibrar2(act, cambiaAltura);
            }
        }
        else 
        {
            n.setDato(act.getDato());
            n=act;
            act=(NodoAvl)act.getIzq();
            n=null;
            cambiaAltura.setLogical(true);
        }
        return act;
    }        
    
    private NodoAvl equilibrar1(NodoAvl n, Logical cambiaAltura)
    {
        NodoAvl n1;
        switch(n.fe)
        {
            case -1:
            n.fe=0;
            break;
            case 0:
            n.fe=1;
            cambiaAltura.setLogical(false);
            break;
            case+1://Se aplica rot der
            n1=(NodoAvl)n.getDer();
            if(n1.fe>=0)
            {
                if(n1.fe==0)//la altura no vuelve a disminuir
                {
                    cambiaAltura.setLogical(false);
                }
                n=rotacionDD(n,n1);
            }
            else 
            {
                n=rotacionDI(n,n1);
            }
            break;
        }
        return n;
    }
    private NodoAvl equilibrar2(NodoAvl n, Logical cambiaAltura)
    {
        NodoAvl n1;
        switch(n.fe)
        {
            case -1:// se aplica rot a la iz
            n1=(NodoAvl)n.getIzq();
            if(n1.fe<=0)
            {
                if(n1.fe==0)
                {
                    cambiaAltura.setLogical(false);
                }
                n=rotacionII(n,n1);
            }
            else
            {
                n=rotacionID(n,n1);
            }
            break;
            case 0:
            n.fe=-1;
            cambiaAltura.setLogical(false);
            break;
            case+1:
            n.fe=0;
            break;
        }
        return n;
    }
    public void masIzquierda(){
        masIzquierda2(Raiz);
    }
    private void masIzquierda2(NodoAvl r){
        if(r!=null){
            NodoAvl r2 = r.getIzq();
            if(r2==null){
                System.out.println(r.getDato());
            }
            else
                masIzquierda2(r2);
        }
    }                
}

                                