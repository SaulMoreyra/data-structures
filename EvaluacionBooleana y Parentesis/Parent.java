public class Parent
{
    public Parent(){
    }
    public void check(String x){
        Pila pila= new Pila(x.length());
        int q=0, y=0;
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)=='('){
                pila.push('(');
                q++;
            }
            if(x.charAt(i)==')'){
                pila.pop();
                y++;
            }
        }
        if(!pila.tavacia() || y>q){
            System.out.println("INCORRECTO");
        }
        if(pila.tavacia() && y==q){
            System.out.println("CORRECTO");
        }
    }
}