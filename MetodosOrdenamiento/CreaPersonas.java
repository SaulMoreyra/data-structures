
import java.io.*;
import java.util.Random;
public class CreaPersonas
{
    private String [] nom, ape;
    private Persona [] arre;
    int max;
    public CreaPersonas(int max){
        this.max=max;
        arre=new Persona[max];
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
                nom[c]=nom[c].replace("\n","");
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
                v++;
            }
        }
        catch(Exception e)
        {
            System.out.print("Error." + e.getMessage());
        }
    }
    
    public Persona [] generaPersonas()
    {
        crearNom();
        crearApe();
        Random r= new Random();
        for(int x=0; x<max; x++)
        {
            Persona p= new Persona (ape[(int)(r.nextDouble()*100)]+ " ",
            ape[(int)(r.nextDouble()*100)]+ " ", 
            nom[(int)(r.nextDouble()*100)] ,
            (int)(r.nextDouble()*(80-18)+18),
            (int)(r.nextDouble()*(200-150)+150));
            arre[x]=p;
        }
        return arre;
    }
}
