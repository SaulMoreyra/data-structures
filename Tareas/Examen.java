public class Examen
{
    public void impo(int n, int z){
        if(n==1)
        System.out.println("");
        System.out.println(gene(n," ")+gene(z,"*"));
        impo(n-1,z+2);
    }
    
    public String gene(int n, String z){
        if(n==0)  
        return "";
        return z+(gene(n-1,z));
    }
}