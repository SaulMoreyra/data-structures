import java.util.Scanner;
import javax.swing.JOptionPane;
public class Main
{
    public static void main(String [] args){

        do{
            String p = JOptionPane.showInputDialog(null,"Para terminar el programa ingrese 'Salir'\nIngresa una frase\n");
            String x = p.replace(" ","");
            if(p!=null){
                if(x.compareTo("")==0){
                    JOptionPane.showMessageDialog(null,"\nEntrada incorrecta");
                    continue;
                }else if(x.equalsIgnoreCase("Salir")){
                    break;
                }
                Palindromo pali = new Palindromo(x);
                if(pali.evalua())
                    JOptionPane.showMessageDialog(null,"\nLa frase: >>' "+p+" '<< es palindromo");
                else    
                    JOptionPane.showMessageDialog(null,"\nLa frase: >>' "+p+" '<< NO es palindromo\nIntenta con otra");
            }
        }while(true);
    }
}