import java.io.*;
public class Figura implements Serializable
{
    String nombre, farea, fperi, desc;
    public Figura(String nombre, String farea, String fperi, String desc){
        this.nombre=nombre;
        this.farea=farea;
        this.fperi=fperi;
        this.desc=desc;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setFarea(String farea){
        this.farea=farea;   
    }
    public void setFperi(String fperi){
        this.fperi=fperi;  
    }
    public void setDesc(String desc){
        this.desc = desc;   
    }
    public String getNombre(){ 
        return nombre;   
    }
    public String getFarea(){ 
        return farea;    
    }
    public String getFperi(){    
        return fperi;      
    }
    public String getDesc(){   
        return desc;     
    }
    
    public void tostring(){
        System.out.format("%-25s %-15s %-15s %-100s%n",nombre,farea,fperi,desc);
        /*System.out.println("Figura:\t\t"+nombre);
        System.out.println("Formula Area:\t"+farea);
        System.out.println("Formula fperi:\t"+fperi);
        System.out.println("Descripción:\n"+desc);*/
    }
}
