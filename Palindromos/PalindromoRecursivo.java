import java.text.Normalizer;
public class PalindromoRecursivo
{
    public PalindromoRecursivo(){
    }
    public boolean evalua(String p){
        p = valida(p).replace(" ","").toLowerCase();
        return pali(p,0,p.length()-1);
    }
    private String valida(String p){
        String s=null;
        p = Normalizer.normalize(p, Normalizer.Form.NFD);
        s = p.replaceAll("\\p{InCombiningDiacriticalMarks}+","");
        return s;
    }
     private boolean pali(String cad, int i, int j){
         if(i>=j)
         return true;
         if(cad.charAt(i)==cad.charAt(j))
           return pali(cad,i+1,j-1);
         return false;
    }
}