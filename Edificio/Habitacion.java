public abstract class Habitacion
{
    protected int nLam, nSwitch;
    public Habitacion(int nl, int ns){
        nLam = nl;
        nSwitch = ns;
    }  
    
    public void setNlam(int nl){
        this.nLam = nl;
    }
    public void setNswitch(int ns){
        this.nSwitch = ns;
    }
    public int getNlam(){
        return nLam;
    }
    public int getSwitch(){
        return nSwitch;
    }
    
}