import java.util.Arrays;
import java.util.Scanner;
public class Formulario
{
    private ListaCDL l;
    private Archivo a;
    private double Pi = 3.1416;
    public Formulario(){
         a = new Archivo();
        l = a.cargar();
    }
    
    public ListaCDL getLista(){
        return l;
    }
    
    public boolean check(String x){
        boolean flag = true;
        int q=0, y=0;
        if(flag){
            for(int i=0;i<x.length();i++){
                if(x.charAt(i)=='('){
                    q++;
                }
                if(x.charAt(i)==')'){
                    y++;
                }
            }
        }else
            return false;
        if(y>q){
            return false;
        }
        if(y==q){
            return true;
        }
        return false;
    }
    
    public boolean agregar(Figura f){
        boolean x = l.agregarFin((Object)(f));
        a.regresaTxt(l);
        l = a.cargar();
        return x;
    }
    
    private int cuenta(String x){
        int q=0;
            for(int i=0;i<x.length();i++){
                if(x.charAt(i)=='('){
                    q++;
                }
            }
        return q;
    }
    
    private String extrae(String tex){
        int a=0,b=0;
        for(int i=0;i<tex.length();i++){
            if(tex.charAt(i)=='(')
                a=i;
            if(tex.charAt(i)==')'){
                b=i;
                break;
            }
        }
        return tex.substring(a+1,b);
    }
    private Figura buscarFig(String p){
        Figura aux=null;
        for(int i=1; i<=l.getTotal();i++){
            if((aux=(Figura)(l.dameDatos(i))).getNombre().equalsIgnoreCase(p)){
                return aux;
            }
        }
        return aux;
    }
    
    public String elimina(String p){
        Figura aux=null;
        int e = 0;
        for(int i=1; i<=l.getTotal();i++){
            if((aux=(Figura)(l.dameDatos(i))).getNombre().equalsIgnoreCase(p)){
                e=i;
            }
        }
        String x = ((Figura)(l.eliminarEP(e))).getNombre();
        a.regresaTxt(l);
        l = a.cargar();
        return x;
    }
    
    public void imp(){
        Figura aux=null;
        System.out.format("%-3s %-25s %-15s %-15s %-100s%n","Pos","Nombre","Ec. area","Ec. perimetro","Descripcion");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        for(int i=1; i<=l.getTotal();i++){
            aux=(Figura)(l.dameDatos(i));
            System.out.print(i+".- ");
            aux.tostring();
            }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public int cuentaVariables(String p){
        String [] arre = {"(",")","*","-","/","^","+","0","1","2","3","4","5","6","7","8","9","Pi"};
        int cont=0;
        for(int i=0; i<arre.length;i++){
            p = p.replace(arre[i]+"","");
        }
        char [] pa = p.toCharArray();
        Arrays.sort(pa);
        for(int x=0;x<pa.length-1;x++){
            if(pa[x]!=pa[x+1])
                cont++;
        }
        return cont+1;
    }
    
    private String formula(String p, String a){
        Figura x = buscarFig(p);
        String s = "";
        if(x!=null){
            if(a.equalsIgnoreCase("Area"))
                s = x.getFarea();
            if(a.equalsIgnoreCase("Perimetro"))
                s = x.getFperi();
        }
        return s;
    }
    
    private double evaluaEXP(double x, String op, double y){
        switch(op){
            case "/":
                return x/y;
            case "*":
                return x*y;
            case "+":
                return x+y;
            case "-":
                return x-y;
            case "^":
                return Math.pow(x,y);
            default: return 0;
        }        
    }
    
    private String sustituye(int [] a, String f, String q){
        String x = "("+formula(f,q)+")";
        x = x.replace("Pi",Pi+"");
        if(x!=null){
            for(int j=0;j<a.length;j++){
                for(int i=0;i<x.length();i++){
                    if((x.charAt(i)>='A' && x.charAt(i)<='Z') || (x.charAt(i)>='a' && x.charAt(i)<='z')){
                        x = x.replace(x.charAt(i)+"",a[j]+"");
                        break;
                    }
                }    
            }
        }  
        return x;
       
    }
    
    private int [] pide(String figura, String formula){
        Scanner lee = new Scanner(System.in);
        int [] x = new int[cuentaVariables(formula(figura,formula))];
        for(int i=0;i<x.length;i++){
            x[i]=lee.nextInt();
        }
        return x;
    }
    
    private String [] separa(String x){
        String [] arre = {"*","-","/","^","+"};
        int co = 0;
        String aux="";
        for(int i =0;i<arre.length;i++){
            for(int j =0;j<x.length();j++){
                if(arre[i].equalsIgnoreCase(x.charAt(j)+"")){
                    co=j;
                    aux=arre[i];
                    break;
                }
            }
        }
        String [] r = {x.substring(0,co),aux, x.substring(co+1)};
        return r;
    }
   

    private float intera(String x){
        try{
            while(cuenta(x)!=0){
                String x1 = extrae(x);
                String [] y = separa(x1);
                float res = (float)(evaluaEXP(Double.parseDouble(y[0]),y[1],Double.parseDouble(y[2])));
                x=x.replace(("("+x1+")"),res+"");
            }
            
        }catch(Exception e){
            System.out.println("Ha ocurrido un error, reviza tu formula");
            return 0;
        }
        return Float.parseFloat(x);
    }
    
    public float Area(String f){
        String x = sustituye(pide(f,"Area"),f,"Area");
        float r = intera(x);
        return r;
    }
    
    public float Perimetro(String f){
        String x = sustituye(pide(f,"Perimetro"),f,"Perimetro");
        float r = intera(x);
        return r;
    }
}
    

  