public class ColaCircular
{
    private int cont, inicio, max, fin;
    char [] datos;    
    public ColaCircular(int max){
        this.max=max;
        inicio = cont = 0;
        fin=-1;
        datos = new char[max];
    }    
    public boolean tavacia(){  return cont==0; }
    public boolean tallena(){  return cont == max;}
    public boolean agregar(char o){
        if(!tallena()){
            if(fin==max-1)
                fin=0;
            else
                fin++;
            datos[fin]=o;
            cont++;
            return true;
        }
        return false;
    }    
    public char eliminar(){
        if(!tavacia()){
            char o = datos[inicio];
            if(inicio==max-1)
                inicio=0;
            else
                inicio++;
            cont--;
            if(tavacia()){
                fin=-1;
                inicio = 0;
            }
            return o;
        } return ' ';
    }
}
