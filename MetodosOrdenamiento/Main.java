public class Main
{
    public static void main(String [] args){
        
        int np=1000000;
        CreaPersonas c = new CreaPersonas(np);
        Metodos m = new Metodos();
        Persona [] pes = c.generaPersonas();
        
        System.out.println("Arreglo desordenado");
        for(int i=0; i<pes.length;i++){
            pes[i].tostring();
        }
        
        System.out.println("\n\nArreglo Ordenado");
        
        
        
        long TInicio, TFin, tiempo; 
        TInicio = System.currentTimeMillis();
        //m.burbuja(pes,"apaterno");
        m.quicksortInt(pes,0,pes.length-1,"apaterno");
        //m.heapsort(pes,pes.length-1,"apaterno");
        //m.mergesort(pes,0,pes.length-1,"apaterno");
        //m.shellSort(pes,"apaterno");
        //m.insertion(pes,"apaterno");
        
        for(int i=0; i<pes.length;i++){
            pes[i].tostring();
        }
        TFin = System.currentTimeMillis(); 
        tiempo = TFin - TInicio; 
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo+"\nElementos: "+ pes.length);
    }
}
