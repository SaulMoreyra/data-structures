public class Pila2
{
    private int tope = -1;
    private int max;
    private String []  arre;
    public Pila2(int max){
        if(max>0)
        this.max = max;
        arre = new String[max];
    }
    public boolean tavacia(){return tope==-1;}
    public boolean tallena(){return tope==max-1;}    
    public boolean push(String x){
        if(!tallena()){
            tope++;
            arre[tope]=x;
            return true;
        }
        return false;
    }
    public String pop(){
        if(!tavacia()){
            String aux = arre[tope];
            tope--;
            return aux;
        }
        return " ";
    }
    public String verTope(){
        if(!tavacia()){
            String x = arre[tope];
            return x;
        }
        return " ";
    }
    public int getTope(){
        return tope;
    }
}