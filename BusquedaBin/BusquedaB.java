class BusquedaB{
    public BusquedaB(){
    
    }
    public Persona busquedaBinaria(Persona  vector[], String dato, String tipo){
          int cont=0;
          int n = vector.length;
          int centro,inf=0,sup=n-1;
          while(inf<=sup){
              centro=(sup+inf)/2;
              if(vector[centro].getAlgo(tipo).compareTo(dato)==0){
                  System.out.println("Comparaciones: "+cont);
                  return vector[centro];
                }
              else if(dato.compareTo(vector[centro].getAlgo(tipo))<0 ){
                  sup=centro-1;
                }
                else {
                    inf=centro+1;
                }
              cont++;
          }
          return null;
    }
    
    public Persona busquedaSecuancial(Persona  vector[], String dato, String tipo){
        Persona aux=null;
        int x=0;
        for(int i=0;i<vector.length;i++){
            if(vector[i].getAlgo(tipo).compareTo(dato)==0){
                aux=vector[i];
                break;
            }
            x++;
        }
        System.out.println("Comparaciones: "+x);
        return aux;
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
    void heapsort (Persona A[], int N, String s)
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