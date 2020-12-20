public class Lista
{
    int max, cont;
    char [] datos;
    public Lista(int max){
        if(max>0){
            this.max=max;
            datos = new char[max];
            cont=-1;
        }
    }
    public boolean tallena(){ return cont==max-1;}
    public boolean tavacia(){ return cont==-1;}
    public boolean push(char x){
        if(!tallena()){
            cont++;
            datos[cont]=x;
            ordenar();
            return true;
        }
        return false;
    }    
    public void ordenar(){
        char aux;
        for(int i=0;i<cont;i++)
              for(int j=0;j<cont-1;j++)
                   if(datos[j+1]<datos[j]){
                      aux=datos[j+1];
                      datos[j+1]=datos[j];
                      datos[j]=aux;
                   }
    }    
    public String eliminar(int x){
        String s="";
        if(!tavacia()){
            if(x==cont){
                s=datos[cont]+"";
                cont--;
                ordenar();
                s=datos[cont]+"";
                for(int i=x;i<datos.length-1;i++){
                    datos[i]=datos[i+1];
                }
                cont--;
                ordenar();
            }
        }
        return s;
    }
    public String toString(){
        String s ="";
        for(int i=0;i<=cont;i++)
            s+=datos[i]+" ";
        return s;
    }
}