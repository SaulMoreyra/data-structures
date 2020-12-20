public class NumerosRe
{
    public int nRe(int x){
        if((x+"").length()==1)
            return x;
        else{
            int s=0;
            for(int i=0;i<(x+"").length();i++){
                s += Integer.parseInt((x+"").charAt(i)+"");
            }
            return nRe(s);
        }
    }
}
