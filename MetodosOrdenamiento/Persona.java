public class Persona
{
    protected String nombre, ap, am;
    protected int edad, altura;
    
    public Persona(String nombre, String ap, String am,int edad, int altura){
        setNombre(nombre);
        setAp(ap);
        setAm(am);
        setEdad(edad);
        setAltura(altura);
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setAltura(int altura){
        this.altura=altura;
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
    public int getAltura(){
        return altura;
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
        if(s.equalsIgnoreCase("altura")){
            String x = Integer.toString(altura);
            return x;
        }
        return null;
    }
    public void tostring(){
        System.out.format("%-15s %-15s %-15s %-8s %-8s%n",nombre,ap,am,edad,altura);
    }
}
