import java.io.*;
import java.util.Formatter;
public class Archivo
{
    public void renombra(){
        try{
            Formatter x = new Formatter("Lista.txt");
       }catch (Exception e){}
    }
    public ListaCDL cargar(){
        ListaCDL cl = null;
        try{
             File f = new File("Lista.txt");
             FileInputStream fi = new FileInputStream(f);
             ObjectInputStream oi = new ObjectInputStream(fi);
             cl = (ListaCDL)(oi.readObject());
        }catch(EOFException e){}
        catch(Exception e){
            System.out.println(e);
        }
        return cl;
    }
        public void regresaTxt(ListaCDL l){
        renombra();
        try{
            File f1 = new File("Lista.txt");
            FileOutputStream fo = new FileOutputStream(f1);
            ObjectOutputStream oo = new ObjectOutputStream(fo);     
                oo.writeObject(l);
            oo.close();
            fo.close();
        }catch(EOFException e){}
        catch(Exception e){
            System.out.println(e);
        }
    }
}