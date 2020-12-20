public class Jefatura extends Construccion
{
    private String encargado;
    Lampara [] arreLam;
    Switch boton;
    Baño baño1;
       
    public Jefatura(String n)
    {
        super(2,1);
        arreLam = new Lampara [2];
        boton= new Switch();
        baño1 = new Baño(1);
        encargado= n;
        creaLam();
    }
    
    public void setLamp(Lampara l, int i){
        if(i<2){
            arreLam[i]=l;
        }
    }
    public Lampara getLamp(int i){
        return arreLam[i];    
    }
    
    public void setBaño(Baño b){
        baño1 = b;
    }
    public Baño getBaño(){
        return baño1;
    }
        
    public void setEncargado(String n)
    {
        this.encargado=n;
    }
    
    public String getEncargado()
    {
        return encargado;
    }
    
    public void setBoton(Switch s){
        this.boton=s;
    }
    
    public Switch getBoton(){
        return boton;
    }
    
    public void creaLam(){
        for(int i = 0; i<2; i++){
            arreLam[i]=new Lampara();
        }
    }
    
    
    public void encenderApagar(){
        boton.setEstado(!boton.getEstado());
        if(boton.getEstado()){
            for(int i=0; i<2;i++){
                arreLam[i].setEstado(!arreLam[i].getEstado());
            }
        }
        System.out.println((boton.getEstado()==true)? "Lámparas jefatura encendidas." : "Jefatura apagada.");
    }
    
}