public abstract class Construccion
{
    protected int nLam, nSwitch;
    public Construccion(int nl, int ns){
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
    public int getNswitch(){
        return nSwitch;
    }
    
}