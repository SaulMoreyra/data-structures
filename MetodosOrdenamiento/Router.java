import java.util.Scanner;
/**
 * Write a description of class Router here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Router
{
    public static void getEnrutamientoSerial(String ips){
        String acum = "";
        String [] ip = ips.split(",");
        String [] t;
        for(int i=0; i<ip.length; i++){
            acum = "";
            t = ip[i].split(" ");
            acum += "\n interface serial" + " "+t[0]+ "\n";
            acum += "ip address "+ t[1] + " 255.255.255.252\n";
            acum += "no shutdown \n";
            acum += "exit \n";
            
            System.out.println(acum);
        }
    }
    
    public static void main(String [] args){
        Scanner lee = new Scanner(System.in);
        System.out.println("Serial   IP   Mascara");
        getEnrutamientoSerial(lee.nextLine());
    }
}
