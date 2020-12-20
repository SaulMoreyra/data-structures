public class Edificio
{
    Salon [] sbaja; 
    Salon [] salta; 
    BañoEstu [] bbaja;
    BañoEstu [] balta;
    Baño [] bcubis;
    Cubiculo [] cubis;
    Pasillo pa1, pa2;
    Jefatura jef;
    Pastilla p1, p2;
    public Edificio(int sb, int sa, int cu, int ba, int bb,int bc, String encar){
        sbaja = new Salon[sb];
        salta = new Salon[sa];
        cubis = new Cubiculo[cu];
        bbaja = new BañoEstu[bb];
        balta = new BañoEstu[ba];
        bcubis = new Baño[bc];
        jef = new Jefatura(encar);
        p1 = new Pastilla(false);
        p2 = new Pastilla(false);
        pa1 = new Pasillo();
        pa2 = new Pasillo();
        creaBCubis();
        creaBaAl();
        creaBaBa();
        creaBaCu();
        creaSA();
        creaSB();
    }
    
    public void setSalBaja(Salon s, int i){
        sbaja[i]=s;
    }
    public void setSalAlta(Salon s, int i){
        salta[i]=s;
    }
    public void setBañBaja(BañoEstu b, int i){
        bbaja[i]=b;
    }
    public void setBañAlta(BañoEstu b, int i){
        balta[i]=b;
    }
    public void setBañCubi(Baño b, int i){
        bcubis[i]=b;
    }
    public void setCubi(Cubiculo b, int i){
        cubis[i]=b;
    }
    public void setJefa(Jefatura j){
        jef = j;
    }
    public void setPast1(Pastilla p){
        p1 = p;
    }
    public void setPast2(Pastilla p){
        p2 = p;
    }
    public void setPasillo1(Pasillo p){
        pa1 = p;
    }
    public void setPasillo2(Pasillo p){
        pa2 = p;
    }
    public Salon getSalBaja(int i){
        return sbaja[i];
    }
    public Salon getSalAlta(int i){
        return salta[i];
    }
    public BañoEstu getBañBaja(int i){
        return bbaja[i];
    }
    public BañoEstu getBañAlta(int i){
        return balta[i];
    }
    public Baño getBaño(int i){
        return bcubis[i];
    }
    public Jefatura getJef(){
        return jef;
    }
    public Pastilla getPast1(){
        return p1;
    }
    public Pastilla getPast2(){
        return p2;
    }
    public Cubiculo getCubi(int i){
        return cubis[i];
    }
    public Pasillo getPasillo1(){
        return pa1;
    }
    public Pasillo getPasillo2(){
        return pa2;
    }
        
    public void creaSB(){
        for(int i = 0; i<sbaja.length; i++){
            sbaja[i]= new Salon("i"+(i+1));
        }
    }
    public void creaSA(){
        for(int i = 0; i<salta.length; i++){
            salta[i]= new Salon("i"+((i+1)+salta.length));
        }
    }
    public void creaBCubis(){
        for(int i=0; i<cubis.length; i++){
            cubis[i]= new Cubiculo();
        }
    }  
    public void creaBaBa(){
        for(int i=0; i<bbaja.length; i++){
            bbaja[i]= new BañoEstu();
        }
    }  
    public void creaBaAl(){
        for(int i=0; i<balta.length; i++){
            bbaja[i]= new BañoEstu();
        }
    } 
    public void creaBaCu(){
        for(int i=0; i<bcubis.length; i++){
            bcubis[i]= new Baño(1);
        }
    } 
} 
