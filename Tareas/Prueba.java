
public class Prueba
{
     public static String bomb(int []a,int m,int n)
    {
        int t = a.length,    // Tamaño del vector.
            h = t/2;         // Posición donde comienza la segunda parte del vector.
        // Control para que m se mantenga en la primera mitad del vector.
        if (m<h)
        {
            if(a[m]==a[n])    // Se encontró una coincidencia.
            {
                return m+"\t"+a[m]+"\t"+n+"\t"+ a[n]+"\n"+bomb(a,m+1,h);
                //System.out.format("A la posicion %d (interruptor %d) le corresponde "+
                                  //"la posicion %d (bomba %d)\n", m, a[m], n, a[n]);
                //bomb(a,m+1,h);    /* La posición m ya tuvo coincidencia con
                                     //la posición n, entonces se sigue buscando,
                                     //para las siguientes posiciones, comenzando en m+1 */
            }
            else if (n < t-1)     /* No hubo coincidencia, entonces se controla que
                                     haya posiciones disponibles en la segunda parte
                                     del vector para seguir buscando posibles
                                     coincidencias para la posición m */
                return bomb(a,m,n+1);
            else                  /* No hubo coincidencia y no quedan posiciones
                                     disponibles en la segunda mitad del vector,
                                     por lo que la búsqueda debe continuar desde m+1. */
                return bomb(a,m+1,h);
        }
        return "";
    }

    public static void main(String[] args) {
        int num[] = {1,2,3,3,1,2};

        System.out.println(bomb(num,0,num.length/2));
    }
}


