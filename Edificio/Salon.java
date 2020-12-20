public class Salon extends Construccion
{
    private String nomAula;
    Lampara [] arreLam;
    Switch boton1; 
    Switch boton2;
    public Salon(String n){
        super(12,2);
        arreLam = new Lampara[12];
        boton1 = new Switch();
        boton2 = new Switch();
        nomAula = n;
        creaLam();
    }  
    
    public void setNomAula(String n){
        this.nomAula=n;
    }    
    public void setBoton1(Switch s){
        this.boton1=s;
    }
    public void setBoton2(Switch s){
        this.boton2=s;
    }
    public void setLampa(Lampara l, int i){
        if(i<12){
            arreLam[i]=l;
        }
    }
    public String getNomAula(){
        return nomAula;
    }
    public Switch getBoton1(){
        return boton1;
    }
    public Switch getBoton2(){
        return boton2;
    }
    public Lampara getLamp(int i){
        return arreLam[i];
    }
    public void creaLam(){
        for(int i = 0; i<12; i++){
            arreLam[i]=new Lampara();
        }
    }
    public void encender1(){
        boton1.setEstado(!boton1.getEstado());
        if(boton1.getEstado()){
            for(int i=0; i<6;i++){
                arreLam[i].setEstado(!arreLam[i].getEstado());
            }
        }
        System.out.println((boton1.getEstado()==true)? "Lámparas 1 a 6 encendidas del salon "+nomAula: "Lámparas 1 a 6 apagadas.");
    }
    public void encender2(){
        boton2.setEstado(!boton2.getEstado());
        if(boton2.getEstado()){
            for(int i=6; i<12;i++){
                arreLam[i].setEstado(!arreLam[i].getEstado());
            }
        }
        System.out.println((boton1.getEstado()==true)? "Lámparas 6 a 12 encendidas del salon "+nomAula: "Lámparas 6 a 12 apagadas.");
    }
}
