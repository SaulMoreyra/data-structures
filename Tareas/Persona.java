public class Persona
{
    protected String nombre, ap, am, sexo;
    protected int edad;
    
    public Persona(String nombre, String ap, String am, String sexo, int edad){
        setNombre(nombre);
        setAp(ap);
        setAm(am);
        setSexo(sexo);
        setEdad(edad);
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setSexo(String sexo){
        this.sexo=sexo;
    }
    public void setEdad(int edad){
        if(edad>0 && edad < 100){
            this.edad=edad;
        }
    }
    public void setAp(String ap){
        this.ap=ap;
    }
    public void setAm(String am){
        this.am=am;
    }
    public String getNombre(){
        return nombre;
    } 
    public String getAp(){
        return ap;
    }
    public String getAm(){
        return am;
    }
    public String getSexo(){
        return sexo;
    }
    public int getEdad(){
        return edad;
    }
    public String getAlgo(String s){
        if(s.equalsIgnoreCase("nombre"))
            return nombre;
        if(s.equalsIgnoreCase("apaterno"))
            return ap;
        if(s.equalsIgnoreCase("amaterno"))
            return am;
        if(s.equalsIgnoreCase("edad")){
            String x = Integer.toString(edad);
            return x;
        }
        return null;
    }
    public void tostring(){
        System.out.format("%-10s %-10s %-10s %-10s %-8s%n",nombre,ap,am,sexo,edad);
    }
}