import java.util.Scanner;
public class Main
{
    public static void main(String [] args){
        Scanner lee = new Scanner(System.in);
        System.out.println("Ejemplo de sintaxis \n\n((!true) && false) && (true ^ (!true)) \n\ntrue && false \n\n(true || (!false)) && (false ^ true)\n\n");
        System.out.println("Recueda separar por espacios los operadores a excepcion del NOT\nOperadores \t OR='||'\tAND='&&' \tXOR='^' \tNOT=(!...)");
        System.out.println("Para terminar ingrese 'Salir'\n\n");
        Evaluacion e = new Evaluacion();
        String y ="";
        while(y.compareTo("Salir")!=0){
            y=lee.nextLine();
            if(y.compareTo("Salir")!=0)
            e.intera("("+y+")");
            else break;
        }
    }
}