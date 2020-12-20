public class BañoEstu extends Baño
{
    private String planta, sexo;
    Lampara [] arrelam;
    Switch boton1;
    public BañoEstu(){
        super(3);
        boton1 = new Switch();
        arrelam = new Lampara[3];
        creaLam();
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
    public void creaLam(){
        for(int i = 0; i<3; i++){
            arrelam[i]=new Lampara();
        }
    }
    public void encender1(){
        boton1.setEstado(!boton1.getEstado());
        if(boton1.getEstado()){
                lam.setEstado(!lam.getEstado());
        }
        System.out.println((boton1.getEstado()==true)? "Lámpara baño encendida.": "Baño apagado.");
    }
}

