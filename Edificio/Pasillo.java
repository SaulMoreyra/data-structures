public class Pasillo extends Construccion
{
    Lampara [] arreLam;
    Switch boton1;
    Switch boton2;
    Switch boton3;
    private String tipo;
    public Pasillo(){
        super(14,3);
        arreLam = new Lampara[14];
        boton1 = new Switch();
        boton2 = new Switch();
        boton3 = new Switch();
        creaLam();
    }
    
        public void setLampa(Lampara l, int i){
        if(i<12){
            arreLam[i]=l;
        }
    }
    public Lampara getLamp(int i){
        return arreLam[i];
    }    
    public void setTipo(String t){
        this.tipo=t;
    }    
    public void setBoton1(Switch s){
        this.boton1=s;
    }
    public void setBoton2(Switch s){
        this.boton2=s;
    }
    public String getTipo(){
        return tipo;
    }
    public Switch getBoton1(){
        return boton1;
    }
    public Switch getBoton2(){
        return boton2;
    }
    public void creaLam(){
        for(int i = 0; i<14; i++){
            arreLam[i]=new Lampara();
        }
    }
    public void encenderSec1(){
        boton1.setEstado(!boton1.getEstado());
        if(boton1.getEstado()){
            for(int i=0; i<6;i++){
                arreLam[i].setEstado(!arreLam[i].getEstado());
            }
        }
        System.out.println((boton1.getEstado()==true)? "Lámparas seccion 1 (pasillo) encendidas.": "No encendió el pasillo.");
    }
    public void encenderSec2(){
        boton2.setEstado(!boton2.getEstado());
        if(boton2.getEstado()){
            for(int i=6; i<12;i++){
                arreLam[i].setEstado(!arreLam[i].getEstado());
            }
        }
        System.out.println((boton1.getEstado()==true)? "Lámparas seccion 2 (pasillo) encendidas.": "No encendió el pasillo.");
    }
    public void encenderEntrada(){
        boton3.setEstado(!boton3.getEstado());
        if(boton3.getEstado()){
            for(int i=12; i<14;i++){
                arreLam[i].setEstado(!arreLam[i].getEstado());
            }
        }
        System.out.println((boton1.getEstado()==true)? "Lámparas entrada encendidas.": "Lámparas entrada apagadas.");
    }
}
