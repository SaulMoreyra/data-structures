public class Lista
{
    int max, cont;
    Persona [] p;
    String a;
    public Lista(int max){
        if(max>0){
            this.max=max;
            p = new Persona[max];
            cont=-1;
            a="nombre";
        }
    }
    public boolean tallena(){
        return cont==max-1;
    }
    public boolean tavacia(){
        return cont==-1;
    }
    public void setOrdenamiento(String a){
        this.a=a;
    }
    public String getOrdenamiento(){
        return a;
    }
    public void ordenar(){
        Persona aux;
        if(cont>1){
            for(int i = 0; i < cont+1; i++){
                for(int j=i+1; j < cont+1; j++){
                        if(p[i].getAlgo(getOrdenamiento()).compareToIgnoreCase(p[j].getAlgo(getOrdenamiento()))>0){
                            aux = p[i];
                            p[i] = p[j];
                            p[j] = aux;
                        }
                }
            }
        }
    }
    
    public void imprime(){
        for(int i = 0; i <= cont; i++){
                p[i].tostring();
        }
    }
    public boolean push(Persona x){
        if(!tallena()){
            cont++;
            p[cont]=x;
            ordenar();
            return true;
        }
        return false;
    }
    public void eliminar(int x){
        if(!tavacia()){
            if(x==cont){
                cont--;
                ordenar();
            }else{
                for(int i=x;i<p.length-1;i++){
                    p[i]=p[i+1];
                }
                cont--;
                ordenar();
            }
        }
    }
}
