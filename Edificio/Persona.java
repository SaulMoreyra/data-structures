public class Persona
{
    private String nom;
    
    public Persona(String n){
        nom = n;
    }
    
    public void setNombre(String n){
        nom = n;
    }
    public String getNombre(){
        return nom;
    }
    
    public void on_offSalonPlantaBaja(Edificio e,int id, int napa){
        if(e.getPast1().getEstado()){
            if(napa==1)
                e.getSalBaja(id).encender1();
            if(napa==2)
                e.getSalBaja(id).encender2();
        }
    }
    public void on_offSalonPlantaAlta(Edificio e,int id, int napa){
        if(e.getPast2().getEstado()){
            if(napa==1)
                e.getSalAlta(id).encender1();
            if(napa==2)
                e.getSalAlta(id).encender2();
        }
    }
    public void on_offBañosBaja(Edificio e, int id){
        if(e.getPast1().getEstado()){
            if(id==1)
                e.getBañBaja(id).encender1();
            if(id==2)
                e.getBañBaja(id).encender1();
        }
    }
    public void on_offBañosAlta(Edificio e, int id){
        if(e.getPast2().getEstado()){
            if(id==1)
                e.getBañAlta(id).encender1();
            if(id==2)
                e.getBañAlta(id).encender1();
        }
    }
    public void on_offBañosCubiculos(Edificio e, int id){
        if(e.getPast2().getEstado()){
            if(id==1)
                e.getBaño(id).encender1();
            if(id==2)
                e.getBaño(id).encender1();
        }
    }
    public void on_offBañoJef(Edificio e){
        if(e.getPast2().getEstado()){
            e.getJef().getBaño().encender1();
        }
    }
    public void on_offCubiculos(Edificio e, int n){
        if(e.getPast2().getEstado()){
            e.getCubi(n).encender1();
        }
    }
    public void on_offJefatura(Edificio e){
        if(e.getPast1().getEstado()){
            e.getJef().encenderApagar();
        }
    }
    public void on_offPasillo1(Edificio e, int n){
        if(e.getPast1().getEstado()){
            if(n==1)
                e.getPasillo1().encenderSec1();
            if(n==2)
                e.getPasillo1().encenderSec2();
            if(n==3)
                e.getPasillo1().encenderEntrada();
        }
        
    }
    public void on_offPastilla1(Edificio e){
        e.getPast1().setEstado(!e.getPast1().getEstado());
    }
    public void on_offPastilla2(Edificio e){
        e.getPast2().setEstado(!e.getPast1().getEstado());
    }
}
