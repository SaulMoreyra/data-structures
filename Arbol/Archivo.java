import java.io.*;
import java.util.*;
import java.text.*;
public class Archivo
{
    private String [] nom, ape;
    int max;
    Persona [] arre;
    public Archivo(int max){
        this.max=max;
        arre = new Persona[max];
    }
    
    public Archivo(){
    }
    
    private String valida(String p){
        String s=null;
        p = Normalizer.normalize(p, Normalizer.Form.NFD);
        s = p.replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        return s;
    }
    
    private void crearNom() 
    {
        try 
        {
            FileReader fi = new FileReader("Nombres.txt");
            BufferedReader bu= new BufferedReader(fi);
            String no;
            int c=0;
            nom= new String [100];
            while((no=bu.readLine())!=null){
                nom[c]=no.replace("\n","");
                nom[c]=nom[c].replace(" ","");
                nom[c]=nom[c].replace("\t","");
                nom[c]=valida(nom[c]);
                c++;
            }
        }
        catch(Exception e)
        {
            System.out.print("Error." + e.getMessage());
        }
    }
    
    private void crearApe()
    {
        try
        {
            FileReader fil = new FileReader("Apellidos.txt");
            BufferedReader buf= new BufferedReader(fil);
            String a;
            int v=0;
            ape = new String [100];
            while((a=buf.readLine())!=null){
                ape[v]=a.replace("\n","");
                ape[v]=ape[v].replace(" ","");
                ape[v]=ape[v].replace("\t","");
                ape[v]=valida(ape[v]);
                v++;
            }
        }
        catch(Exception e)
        {
            System.out.print("Error." + e.getMessage());
        }
    }
    
    public void generaPersonas()
    {
        crearNom();
        crearApe();
        Random r= new Random();
        for(int x=0; x<max; x++)
        {
            Persona p= new Persona (nom[(int)(r.nextDouble()*100)],
            ape[(int)(r.nextDouble()*100)],
            ape[(int)(r.nextDouble()*100)],
            (int)(r.nextDouble()*(80-18)+18),
            (int)(r.nextDouble()*(200-150)+150));
            arre[x]=p;
        }
    }
    
    private void renombra(){
        try{
            Formatter x = new Formatter("ArbolPersonas.txt");
       }catch (Exception e){}
    }
    
    public void guardaTxt(){
        renombra();
        try{
            File f1 = new File("ArbolPersonas.txt");
            FileOutputStream fo = new FileOutputStream(f1,true);
            ObjectOutputStream oo = new ObjectOutputStream(fo);   
            for(int i=0; i<max; i++){
                oo.writeObject(arre[i]);
            }
                
            oo.close();
            fo.close();
            }catch(Exception e){ }
    }
    
    public Arbol cargarArb(){
        Arbol cl = new Arbol();
        try{
                
             File f = new File("ArbolPersonas.txt");
             FileInputStream fi = new FileInputStream(f);
             ObjectInputStream oi = new ObjectInputStream(fi);
             Persona pe=null;
             while(((pe=(Persona)(oi.readObject()))!=null)){
                cl.insertarREC(pe);
             }
        }catch(EOFException e){}
        catch(Exception e){
            System.out.println(e);
        }
        return cl;
    }
    
    public Arbol cargarTempo(String x){
        Arbol cl = new Arbol();
        try{
                
             File f = new File("ArbolPersonas.txt");
             FileInputStream fi = new FileInputStream(f);
             ObjectInputStream oi = new ObjectInputStream(fi);
             Persona pe=null;
             while(((pe=(Persona)(oi.readObject()))!=null)){
                cl.insertarPor(pe,x);
             }
        }catch(EOFException e){}
        catch(Exception e){
            System.out.println(e);
        }
        return cl;
    }
}