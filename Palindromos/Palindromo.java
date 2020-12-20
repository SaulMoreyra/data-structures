import java.text.Normalizer;
public class Palindromo
{
    private PilaLig pila1, pila2;
    private String pal;
    public Palindromo(String p){
        this.pal = valida(p);
        //Meto los datos en la pila, en una la palabra en orden y en otra al revez
        pila1 = llenaPila(pal);
        pila2 = pilaReverse(pal);
    }
    
    public String impPila(PilaLig un){
        PilaLig d = un;
        String t ="";
        for(int i=0;i<un.length();i++)
            t+=d.pop()+" ";
        return t;
    }
    
    public boolean evalua(){ 
        boolean flag = true;
        /**Comparo cada nodo de la pila ejemplo con palabra hola
           h    a
           o    l
           l    o
           a    h
           
           Si alguna palabra no coincide se vuelve false la bandera y arroja falso;
           **/
        for(int i=0;i<pal.length();i++){
            if(!pila1.tavacia() && !pila2.tavacia()){
                String a1 = pila1.pop()+"";
                String a2 = pila2.pop()+"";
                if(!(a1.equalsIgnoreCase(a2))){
                    flag =  false;
                }
            }
            else
                flag = false;
        }
        return flag;
    }
    
    public PilaLig pilaReverse(String p){
        PilaLig temp = new PilaLig();
        for(int i=pal.length()-1;i>=0;i--)
            temp.push(p.charAt(i));
        return temp;
    }
    
    //Aqui entra el arreglo de char a la 
    public PilaLig llenaPila(String p){
        PilaLig temp = new PilaLig();
        for(int i=0;i<p.length();i++)
            temp.push(p.charAt(i));
        return temp;
    }
    
    //Normalizer sirve para quitar caracteres especiales, acentos por ejemplo
    public String valida(String p){
        String s=null;
        p = Normalizer.normalize(p, Normalizer.Form.NFD);
        s = p.replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        return s;
    }
    
}