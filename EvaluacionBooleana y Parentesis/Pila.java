public class Pila
{
    private int tope = -1;
    private int max;
    private char []  arre;
    public Pila(int max){
        if(max>0)
        this.max = max;
        arre = new char[max];
    }
    public boolean tavacia(){return tope==-1;}
    public boolean tallena(){return tope==max-1;}    
    public boolean push(char x){
        if(!tallena()){
            tope++;
            arre[tope]=x;
            return true;
        }
        return false;
    }
    public char pop(){
        if(!tavacia()){
            char aux = arre[tope];
            tope--;
            return aux;
        }
        return ' ';
    }
    public char verTope(){
        if(!tavacia()){
            char x = arre[tope];
            return x;
        }
        return ' ';
    }
    public int getTope(){
        return tope;
    }
}

