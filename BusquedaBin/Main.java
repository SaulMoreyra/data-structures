
public class Main
{
    public static void main(String [] ars){
        Archivo a = new Archivo(100000);
        BusquedaB b = new BusquedaB();
        
        String busq = "edad";
        String pers = "18";
        Persona [] x= a.cargarArb();
        Persona [] s = x;
        
        System.out.println("Ordenado por: "+busq);
        
        System.out.println("\nBusqueda Binaria");
        b.heapsort(x,x.length-1,busq);
        long TInicio, TFin, tiempo; 
        TInicio = System.currentTimeMillis();
        System.out.print(b.busquedaBinaria(x,pers,busq).toString());
        TFin = System.currentTimeMillis(); 
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " 
                            + tiempo+"    Elementos: "+ x.length);
        
        
        System.out.println("\n\n\nBusqueda Secuencial");
        long TInicio1, TFin1, tiempo1; 
        TInicio1 = System.currentTimeMillis();
        System.out.print(b.busquedaSecuancial(s,pers,busq).toString());
        TFin1 = System.currentTimeMillis(); 
        tiempo1 = TFin1 - TInicio1; 
        System.out.println("Tiempo de ejecución en milisegundos: "
                            + tiempo1+"    Elementos: "+ s.length);
           
    }
}
