public class Cubiculo extends Construccion
{
    private String prof = "Alguien"; 
    private Lampara lam;
    private Switch boton1;
    public Cubiculo(){
        super(1,1);
        lam = new Lampara();
        boton1 = new Switch();
    } 
    public void setProf(String n){
        prof = n;
    }
    public String getProf(){
        return prof;
    }
     
    public void setBoton1(Switch s){
        this.boton1=s;
    }
    public Switch getBoton1(){
        return boton1;
    }   
    public void encender1(){
        boton1.setEstado(!boton1.getEstado());
        if(boton1.getEstado()){
                lam.setEstado(!lam.getEstado());
        }
        System.out.println((boton1.getEstado()==true)? "Lámpara cubículo encendida.": "Cubículo apagado.");
    }
}