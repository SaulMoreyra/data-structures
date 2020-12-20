import java.util.Random;
public class JuegoSillas
{
    private ListaCL personas;
    private ListaCL sillas;
    
    public JuegoSillas(int cantidadPersonas){
        personas = new ListaCL();
        sillas = new ListaCL();
        crearPersonas(cantidadPersonas);
        crearSillas(cantidadPersonas - 1 );
    }
    
    public void crearPersonas(int cantidadPersonas){
        for(int i=0; i<cantidadPersonas; i++){
            personas.agregarFin(new Persona(i+1));
        }
    }
    
    public void crearSillas(int cantidadSillas){
        for(int i=0; i < cantidadSillas; i++){
            sillas.agregarFin(new Silla(i+1));
        }
    }
    
    
    public void comenzar(){
        int contador = 1;
        do{
            System.out.println("-------------- RONDA "+ contador + " --------------");
            sentarPersonas();
            eliminarUnLugar();
            pararPersonas();
            contador++;
        }while(personas.contar() > 1);
        
        Persona ganador = ((Persona) personas.getCab().getDato());
        System.out.println("GANADOR PERSONA "+ganador.getIdentificador());
    }
    
    public int getRandom(int tope){
        Random r = new Random();
        return r.nextInt(tope );
    }
    
    
    public void sentarPersonas(){
        int personaQueNoSeVaASentar = getRandom(personas.contar());
        int cont = 0;
        Nodo auxSilla = sillas.getCab();
        Nodo auxPersona = personas.getCab();
        do{
            Persona p = ((Persona)auxPersona.getDato());
            if(cont != personaQueNoSeVaASentar){
                p.sentarse(((Silla) auxSilla.getDato()));
                auxSilla = auxSilla.getSig();
            }
            auxPersona = auxPersona.getSig();
            cont++;
        }while(auxPersona!=personas.getCab());
        personas.imprimeDatos();
    }
    
    public void eliminarUnLugar(){
        Nodo auxPersona = personas.getCab();
        Persona eliminada = null;
        do{
            if(!((Persona)auxPersona.getDato()).estaSentada()){
                eliminada = (Persona) personas.eliminaDato(auxPersona.getDato());
            }
            auxPersona = auxPersona.getSig();
        }while(auxPersona!=personas.getCab());
        sillas.eliminarFin();
        System.out.println("Persona "+eliminada.getIdentificador() + " eliminada\n");
    }
    
    
    public void pararPersonas(){
        Nodo auxPersona = personas.getCab();
        do{
            ((Persona)auxPersona.getDato()).pararse();
            auxPersona = auxPersona.getSig();
        }while(auxPersona!=personas.getCab());
       
    }
}
