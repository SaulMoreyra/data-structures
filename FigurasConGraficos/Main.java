import java.util.Scanner;
public class Main
{
    public static void main(String [] args){
        Formulario f = new Formulario();
        Scanner lee = new Scanner(System.in);
        System.out.println("\f");
        while(true){
            System.out.println("\f");
            System.out.println("1 (uno) Figura que se desee calcular\n"+
                                "2 (dos) para agregar un nuevo elemento\n"+
                                "3 (tres) para Eliminar\n"+
                                "4 (cuatro) para Salir\n");
            int pos1 = 0;
            pos1 = Integer.parseInt(lee.nextLine());
            if(pos1==2){
                f.imp();
                System.out.println("Ingrese nombre");
                String n = lee.nextLine();
                String fa;
                do{
                    System.out.println("Ingrese formula area \nEJ: a*(b*h)");
                    fa = lee.nextLine();
                }while(!f.check(fa));
                String fp;
                do{
                    System.out.println("Ingrese formula perimetro \nEJ: (p*9)+2");
                    fp = lee.nextLine();
                }while(!f.check(fp));
                System.out.println("Ingrese descripcion");
                String de = lee.nextLine();
                f.agregar(new Figura(n,fa,fp,de));
                System.out.println("\n\n-------------------------------");
                System.out.println("Haz agregado a: "+n);
                System.out.println("-------------------------------\n\n");
                f.imp();
                String entra = null;
                do{
                    System.out.println("¡¡Presiona enter para continuar!!");
                    entra = lee.nextLine();
                }while(entra==null);
            }
            if(pos1==4) break;
            if(pos1==3) {
                f.imp();
                System.out.println("Ingresa poscicion a eliminar");
                int eli = Integer.parseInt(lee.nextLine());
                System.out.println("\n\n-------------------------------");
                System.out.println((eli>0 && eli<=f.getLista().getTotal())? "Haz eliminado a: "+f.elimina(((Figura)f.getLista().dameDatos(eli)).getNombre()):"No existe la posicion");
                System.out.println("-------------------------------\n\n");
                f.imp();
                String entra=null;
                do{
                    System.out.println("¡¡Presiona enter para continuar!!");
                    entra = lee.nextLine();
                }while(entra==null);
            }
            if(pos1==1){
                System.out.println("\f");
                f.imp();
                System.out.println("Ingresa la posicion de la figura");
                int pos=Integer.parseInt(lee.nextLine());
                while(pos>0 && pos<=f.getLista().getTotal()){
                    System.out.println("--------------");
                    System.out.println("| 1.-Area      |\n| 2.-Perimetro |");
                    System.out.println("--------------");
                    int aop= Integer.parseInt(lee.nextLine());
                    while(aop==1 || aop==2){
                        String x = (((Figura)f.getLista().dameDatos(pos)).getNombre());
                        if(aop==1){
                            String m = (((Figura)f.getLista().dameDatos(pos)).getFarea());
                            System.out.println("Ingresa: "+f.cuentaVariables(m)+ " variable(s)");
                            System.out.println("------------------------------------");
                            System.out.println("El area de: "+x+ " es "+ f.Area(x)+" cm²");
                            System.out.println("------------------------------------\n\n");
                            String entra =null;
                            do{
                                System.out.println("¡¡Presiona enter para continuar!!");
                                entra = lee.nextLine();
                            }while(entra==null);
                            break;
                        }
                        else if(aop==2){
                            String m = (((Figura)f.getLista().dameDatos(pos)).getFperi());
                            System.out.println("Ingresa: "+f.cuentaVariables(m)+ " variable(s)");
                            System.out.println("------------------------------------");
                            System.out.println("El perimetro de: "+x+ " es "+ f.Perimetro(x)+" cm");
                            System.out.println("------------------------------------\n\n");
                            String entra =null;
                            do{
                                System.out.println("¡¡Presiona enter para continuar!!");
                                entra = lee.nextLine();
                            }while(entra==null);
                            break;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("\f¡¡Byeeeeee!!");
        System.exit(6);
    }
}