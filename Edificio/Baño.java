public class Baño extends Construccion
{
    private String planta, sexo;
    protected int nlam;
    Lampara lam;
    Switch boton1;
    public Baño(int nl){
        super(nl,1);
        nlam = nl;
        boton1 = new Switch();
        lam = new Lampara();
    }
    public void setPlanta(String n){
        this.planta=n;
    }    
    public void setSexo(String n){
        this.sexo=n;
    }  
    public void setBoton1(Switch s){
        this.boton1=s;
    }
    public String getPlanta(){
        return planta;
    }
    public String getSexo(){
        return sexo;
    }
    public Switch getBoton1(){
        return boton1;
    }   
    public void setLampara(Lampara l){
        lam = l;
    }
    public Lampara getLampara(){
        return lam;
    }
    public void encender1(){
        boton1.setEstado(!boton1.getEstado());
        if(boton1.getEstado()){
                lam.setEstado(!lam.getEstado());
        }
        System.out.println((boton1.getEstado()==true)? "Lámpara baño encendida.": "Baño apagado.");
    }
}
