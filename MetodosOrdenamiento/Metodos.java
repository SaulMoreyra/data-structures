public class Metodos
{
    public Metodos(){}
    //nombre, apaterno, amaterno, edad, altura
    public void burbuja(Persona [] p, String ordena){
        Persona aux;
        if(p.length>1){
            for(int i = 0; i < p.length; i++){
                for(int j=i+1; j < p.length; j++){
                        if(p[i].getAlgo(ordena).compareToIgnoreCase(p[j].getAlgo(ordena))>0){
                            aux = p[i];
                            p[i] = p[j];
                            p[j] = aux;
                        }
                }
            }
        }
    }
    
    public void quicksortInt( Persona a[], int izq, int der, String s)
    {
        Persona pivote=a[(int)(der/2)];
        int i=izq;
        int j= der;
        Persona aux;
        while(i<j){
            while( a[i].getAlgo(s).compareTo(pivote.getAlgo(s))<=0 && i<j)
                i++;
            while (a[j].getAlgo(s).compareTo(pivote.getAlgo(s))>0)
                j--;
            if (i<j)
            {
                aux=a[i];
                a[i]=a[j];
                a[j]=aux;
            }
        }
        a[izq]=a[j];
        a[j]=pivote;
        if(izq<j-1)
        quicksortInt(a,izq,j-1,s);
        if(j+1<der)
        quicksortInt (a,j+1,der,s);
    }
    
    public void mergesort(Persona [] a, int primero, int ultimo, String algo)
    {
        int central;
        if(primero<ultimo)
        {
            central = (primero+ultimo)/2;
            mergesort(a,primero,central,algo);
            mergesort(a,central+1,ultimo,algo);
            mezcla(a,primero,central,ultimo,algo);
        }
    }
    private void mezcla(Persona [] a , int izda, int medio, int drcha, String s)
    {
        Persona [] tmp = new Persona[a.length];
        int x,y,z;
        x =z= izda;
        y= medio+1;
        // ciclo para la mezcla
        while(x<=medio && y<=drcha)
        {   
            if(a[x].getAlgo(s).compareTo(a[y].getAlgo(s))<=0)
            tmp[z++]=a[x++];
            else
            tmp[z++]=a[y++];
        }
        //ciclo para mover elementos que quedan en sublistas
        while(x<=medio)
        tmp[z++]= a[x++];
        while(y<=drcha)
        tmp[z++]=a[y++];
        //Copia de los elementos de tmp[] al array a[]
        System.arraycopy(tmp, izda,a,izda,drcha-izda+1);
        
    }
    public void shellSort(Persona arr[], String s) {
        int salto;
        int cambios;
        Persona aux;
        int i;
        for (salto=(arr.length/2); salto!=0; salto/=2) {
            for (cambios=1; cambios!=0;) {
                cambios=0;
                for (i=salto; i<arr.length; i++) {
                    if (arr[i-salto].getAlgo(s).compareTo(arr[i].getAlgo(s))>0) {
                        aux=arr[i];
                        arr[i]=arr[i-salto];
                        arr[i-salto]=aux;
                        cambios++;
                    }
                }
            }
        }
    }
    
    public void insertion(Persona[] arreglo, String s) {
        int in;
 
        for (int i = 1 ; i < arreglo.length ; i++) {
            Persona aux = arreglo[i];
            in = i;    
             
            while (in > 0 && arreglo[in - 1].getAlgo(s).compareTo(aux.getAlgo(s)) > 0) {
                arreglo[in] = arreglo[in - 1];  
                in--;
            }
 
            arreglo[in] = aux; 
        }
    }
    
    
    private void desc (Persona A[], int i, int N,String s)
    {
        Persona tmp = A[i];
        int hijo = 2 * i;
        if ((hijo < N) && (A[hijo + 1].getAlgo(s).compareTo(A[hijo].getAlgo(s)) > 0))
        hijo++;
        while ((hijo <= N) && (tmp.getAlgo(s).compareTo(A[hijo].getAlgo(s)) <0))
        {
         /* elijo bien el hijo */
         if ((hijo < N) && (A[hijo + 1].getAlgo(s).compareTo(A[hijo].getAlgo(s)) >0))
         hijo++;
         A[i] = A[hijo];
         i = hijo;
         hijo = 2 * i;
        }
        A[i] = tmp;
    }
    private void intercambiar (Persona A[], int i, int j)
    {
        Persona tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public void heapsort (Persona A[], int N, String s)
    {
        int i;
        /* meto los datos en el montículo (ordeno) */
        for (i = N / 2; i >= 0; i--)
        desc (A, i, N, s);
        /* saco los datos y los meto al final para obtener el array ordenado */
        for (i = N ; i > 0; i--)
        {
            intercambiar (A, 0, i);
            desc (A, 0, i - 1, s);
        }
    }
}
