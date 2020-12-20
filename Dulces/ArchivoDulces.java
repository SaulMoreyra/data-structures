import java.util.*;
import java.io.*;
public class ArchivoDulces
{
    int max;
    String [] marca = {"Sonrics","Ricolino","Vero","Lillopon","La-Giralda","La-Rosa","Adams","Ferrero","Coronado","La-Corona","Miguelito","Wonka"};
    String [] sabor = {"Fresa","Chocolate","Sandia","Limon","Tamarindo","Menta","Mandarina","Uva","Naranja","Tutifruti","Coco","Crereza","Frambuesa","Platano","Mango","Melon","Coca"};
    String [] present = {"Paleta","Caramelo-masizo","Dulce-suave","Chicloso","Chicle"};
    String [] contenido = {"20 grs.","30 grs.","40 grs.","50 grs.","60 grs."};
    Dulce [] dulces;
    public ArchivoDulces(int max){
        this.max = max;
        dulces = new Dulce [max];
    }
    public ArchivoDulces(){
    }

    private boolean busca(Dulce x){
        for(Dulce d : dulces){
            if(d==null)break;
            if(x.getDesc().equalsIgnoreCase(d.getDesc()))
                return true;
        }
        return false;
    }    

    private boolean busca(int x){
        for(Dulce d : dulces){
            if(d==null)break;
            if(x==d.getId())
                return true;
        }
        return false;
    } 
    
    private void fabrica(){
        int x = 0;
        Random rnd = new Random();
        while(true){
            if(x==max) break;
            int un = (int)(rnd.nextDouble() * 10 + 0);
            int dos = (int)(rnd.nextDouble() * 10 + 0);
            int tr = (int)(rnd.nextDouble() * 10 + 0);
            int cu = (int)(rnd.nextDouble() * 10 + 0);
            int id = Integer.parseInt(un+""+dos+""+tr+""+cu);
            String m = marca[(int)(rnd.nextDouble() * (marca.length-1) + 0)];
            String s = sabor[(int)(rnd.nextDouble() * (sabor.length-1) + 0)];
            String p = present[(int)(rnd.nextDouble() * (present.length-1) + 0)];
            String c = contenido[(int)(rnd.nextDouble() * (contenido.length-1) + 0)];
            Dulce d = new Dulce(id,m,s,p,c);
            if(!busca(d) && !busca(d.getId())){
                dulces[x]=d;
                x++;
            }
        }
    }
    
    public void escrirTxt(){
        fabrica();
        try{
            File f = new File("DulcesT.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
         
            for(int i=0; i<dulces.length;i++){
                bw.write(dulces[i].getEscribe()+"\n");
                
            }
            bw.close();
        }catch(Exception e){ }
    }
    
    public void imprimir(){
        System.out.println("\n-------------------------------------------------------------------");
        System.out.print(String.format("%-9s %-14s %-14s %-16s %-14s%n","ID","Marca","Sabor","Presentacion","Contenido"));
        System.out.println("-------------------------------------------------------------------");
        try{
            File f = new File("DulcesT.txt");
            FileReader fo = new FileReader(f);
            BufferedReader oo = new BufferedReader(fo);
            String c;
            while((c = oo.readLine())!=null){
                System.out.println(getDulce(c).toString());
            }
            
            fo.close();
            oo.close();
        }catch(Exception e){ }
        System.out.println("-------------------------------------------------------------------");
    }
    private void imprimir2(){
        try{
            File f = new File("DulcesT2.txt");
            FileReader fo = new FileReader(f);
            BufferedReader oo = new BufferedReader(fo);
            String c;
            while((c = oo.readLine())!=null){
                System.out.println(c);
            }
            
            fo.close();
            oo.close();
        }catch(Exception e){ }
    }
    /*public void renombra(){
        try{
            File f = new File("DulcesT.txt");
            File f1 = new File("DulcesT2.txt");
            
            f.renameTo(f1);
            
            System.out.println(f.toString());
       }catch (Exception e){}
    }*/
    
    private String tamañoArchi(){
        String x = null;
        try{
            File f = new File ("DulcesT.txt");
            RandomAccessFile fichero = new RandomAccessFile(f, "r");
            x= (int)(fichero.length()/77)+"";
        }catch(Exception e){ 
            System.out.println(e);
        }
        return x;
    } 
    
    public Arbol cargarArbol() throws Exception{ 
        Arbol a = new Arbol();
        RandomAccessFile fich = null;
        try{
                fich = new RandomAccessFile ("DulcesT.txt", "r");
                int i =1;
                String d;
                while(( d = fich.readLine())!=null){
                    String [] r = d.replace(" ","").split("/");
                    a.insertarREC(Integer.parseInt(r[0]),i);  
                    i=i+1;
                    fich.seek((i-1)*77);
                }
        }catch(Exception e){}
        return a;
        }
    public Dulce mostrarDulce(int i) throws Exception{ 
        Dulce a = null;
        RandomAccessFile fich = null;
        try{
                fich = new RandomAccessFile ("DulcesT.txt", "r");
                fich.seek((i-1)*77);
                String d = fich.readLine();
                String [] r = d.replace(" ","").split("/");
                a = new Dulce(Integer.parseInt(r[0]),r[1],r[2],r[3],r[4]);    
        }catch(Exception e){}
        fich.close();
        if(a==null){
            System.out.println("Ingresa un numero entre 0 y "+tamañoArchi());
        }
        return a;
    }
    
    private Dulce getDulce(String d){
        String [] r = d.replace(" ","").split("/");
        Dulce a = new Dulce(Integer.parseInt(r[0]),r[1],r[2],r[3],r[4]);  
        return a;
    }
    
    public void depuraTx(Arbol a){
        try{
            File f = new File("DulcesT.txt");
            FileReader fo = new FileReader(f);
            BufferedReader oo = new BufferedReader(fo);
            
            File f2 = new File("DulcesT2.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f2,true));
            String c;
            
            while((c = oo.readLine())!=null){
                String [] r = c.replace(" ","").split("/");
                if(a.buscarA(Integer.parseInt(r[0]))){
                    bw.write(c+"\n");
                }
            }
            
            fo.close();
            oo.close();
            
            bw.close();
            Formatter x = new Formatter("DulcesT.txt");
            f2.renameTo(f);
        }catch(Exception e){ }
    }
    
    public void Agrega(Dulce dul){
        
        try{
            File f = new File("DulcesT.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
         
            
                bw.write(dul.getEscribe()+"\n");
                
            
            bw.close();
        }catch(Exception e){ }
    }
}
   