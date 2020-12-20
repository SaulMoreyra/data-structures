public class Cola
{
    private char [] datos;
    private int inicio, fin, max;
    public Cola(int max){
        this.max=max;
        datos = new char[max];
        inicio=0;
        fin=-1;
    }
    public boolean tavacia(){ return fin==-1;}
    public boolean tallena(){ return fin==max-1; }
    public boolean agregar(char o){
        if(!tallena()){
            fin++;
            datos[fin]=o;
            return true;
        }
        return false;
    }
    public char verfrente(){
        if(!tavacia())  return datos[inicio];
        return ' ';
    }
    public char eliminar(){
        if(tavacia())
        return ' ';
        char x = datos[inicio];
        for(int i=0;i<fin;i++)
            datos[i]=datos[i+1];
        fin--;
        return x;
    }
    public String toString(){
        String s ="";
        for(int i=inicio;i<=fin;i++)
            s+=datos[i]+" ";
        return s;
    }
}
