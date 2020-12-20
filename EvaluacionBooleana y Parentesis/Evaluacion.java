public class Evaluacion
{
    public boolean check(String x){
        Pila pila= new Pila(10);
        boolean flag = false;
        for(int j=0;j<x.length();j++){
            if(x.charAt(j)=='(')
                flag=true;
        }
        int q=0, y=0;
        if(flag){
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
        }else
            return false;
        if(!pila.tavacia() || y>q){
            return false;
        }
        if(pila.tavacia() && y==q){
            return true;
        }
        return false;
    }
    public int cuenta(String x){
        int q=0;
        if(check(x)){
            for(int i=0;i<x.length();i++){
                if(x.charAt(i)=='('){
                    q++;
                }
            }
        }
        return q;
    }
    
    public String evaluacion(String text){
        
        switch(text){
            //&&
            case "(true && true)":
                return "true";
            case "(false && false)":
                return "false";
            case "(true && false)":
                return "false";
            case "(false && true)":
                return "false";
                
            //OR
            case "(true || true)":
                return "true";
            case "(false || false)":
                return "false";
            case "(true || false)":
                return "true";
            case "(false || true)":
                return "true";
                
            //XOR
            case "(true ^ true)":
                return "false";
            case "(false ^ false)":
                return "false";
            case "(true ^ false)":
                return "true";
            case "(false ^ true)":
                return "true";
                
            //NOT
            case "(!true)":
                return "false";
            case "(!false)":
                return "true";
            default:
                return "Mal planteada";
        }
    }
    public String extrae(String tex){
        int a=0,b=0;
        for(int i=0;i<tex.length();i++){
            if(tex.charAt(i)=='(')
                a=i;
            if(tex.charAt(i)==')'){
                b=i;
                break;
            }
        }
        return tex.substring(a,b+1);
    }
    public void intera(String x){
        if(check(x)){
            Pila2 p = new Pila2(cuenta(x));
            System.out.println(x);
            while(cuenta(x)!=0){
                if(cuenta(x)==1){
                    x = evaluacion(x);
                    System.out.println(x);
                }else{
                    p.push(x);
                    String y = evaluacion(extrae(x));
                    x = p.pop().replace(extrae(x),y);
                    System.out.println(x);
                }
            }
            System.out.println("\n\n");            
        }else 
            System.out.println("Esta mal planteada");
    }
}