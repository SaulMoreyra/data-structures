import java.io.*;
public class Dulce implements Serializable
{
    private int id;
    private String marca, sabor, present, cont;
    
    public Dulce(int id, String marca, String sabor, String present, String cont){
        setId(id);
        setMarca(marca);
        setSabor(sabor);
        setPresent(present);
        setCont(cont);
    }
    
    public void setId(int id){
        this.id=id;
    }
    public void setMarca(String marca){
        if(marca.length()<25){
            this.marca = String.format("%-15s%n",marca).replace("\n","");
        }
        else{
            this.marca = marca.substring(0,15);
        }
    }
    public void setSabor(String sabor){
        if(sabor.length()<25){
            this.sabor = String.format("%-15s%n",sabor).replace("\n","");
        }
        else{
            this.sabor = sabor.substring(0,15);
        }
    }
    public void setPresent(String present){
        if(present.length()<25){
            this.present = String.format("%-17s%n",present).replace("\n","");
        }
        else{
            this.present = present.substring(0,17);
        }
    }
    public void setCont(String cont){
        if(cont.length()<25){
            this.cont = String.format("%-15s%n",cont).replace("\n","");
        }
        else{ 
            this.cont = cont.substring(0,15);
        }
    } 
    
    public int getId(){ 
        return id;
    }
    public String getMarca(){
        return marca;
    }
    public String getSabor(){
        return sabor;
    }
    public String getPresent(){
        return present;
    }
    public String getCont(){
        return cont;
    } 
    public String getDesc(){
        return marca.replace(" ","")+" "+sabor.replace(" ","")+" "+present.replace(" ","")+" "+cont.replace(" ","");
    }
    public String getEscribe(){
        return (String.format("%-10s%n",id)+"/"+marca+"/"+sabor+"/"+present+"/"+cont).replace("\n","");
    }
    public String toString(){
        return (String.format("%-10s%n",id)+""+marca+""+sabor+""+present+""+cont).replace("\n","");
    }
}