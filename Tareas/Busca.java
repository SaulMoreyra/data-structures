import java.io.*;
public class Busca{
    
    public Busca(){
        
    }
    public void Buscar1(String palabra){
        try{
            File f = new File("Palabras.txt");
            if(f.exists()){
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr); 
                System.out.println(mete(br,palabra,0));
            }else { System.err.println("Fatality error"); }        
            }catch(Exception e){            System.err.println(e);        
        }
    }
    public String mete(BufferedReader br,String pa,int i){
        try{
            String n;
            if((n = br.readLine())!=null){
                String []a = n.split(" ");
                return buscale(a,pa,0,i+1,"")+"\n"+mete(br,pa,i+1);
            } 
            }catch(Exception e){            System.err.println(e);
        }
        return "";
    }
    public String buscale(String [] a,String p,int i,int x,String s){
        String aux ="";
        if(i==a.length)
            return "";
        if(a[i].equalsIgnoreCase(p)==true)
            return "Palabra: '"+ a[i]+"' Posicion: "+(i+1)+" Linea: "+x+"\n"+buscale(a,p,(i+1),x,aux);  
       return buscale(a,p,(i+1),x,aux);
    }
}

