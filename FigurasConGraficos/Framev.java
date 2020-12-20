import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
public class Framev extends JFrame {
    //Botones
    private JButton btn_calcular;
    private JButton btn_agregar;
    private JButton btn_eliminar;
    private JButton btn_area;
    private JButton btn_perimetro;
    
    //Menu
    private Menu barraMenu;
    private MenuBar tiene = new MenuBar();
    private MenuItem archivo;
    
    //Pantallas
    private JTextArea pant_datos;
    private JTextArea pant_resus;
    private JScrollPane scroll,scroll2;
    
    //Label y textField
    private JTextField cajita;
    private JLabel frase;
    
    private ImageIcon imag=new ImageIcon ("lupa.png");
    
    
    public Framev()
    {
        super("Figuras");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(imag.getImage());
        
     
        btn_area = confArea();
        btn_perimetro = confPerimetro();
        btn_calcular = confCalcular();
        btn_agregar = confAgregar();
        btn_eliminar = confEliminar();
        barraMenu = confArchivo();
        archivo = confMSalir();
        barraMenu.add(archivo);
        tiene.add(barraMenu);
        frase=confJLabel();
        cajita=confiText();
        scroll=confdesliza();
        scroll2=confResus();
        //lo agrego al frame 
        add(scroll2);
        add(scroll);
        add(frase);
        add(cajita);
        setMenuBar(tiene);
        add(btn_calcular);
        add(btn_agregar);
        add(btn_eliminar);
        add(btn_area);
        add(btn_perimetro);
    }
     

        
    //@Override
    /*
    public void actionPerformed(ActionEvent hace){
           if(hace.getSource()== archivo){
               System.exit(0);
            }else if(hace.getSource()== botonCargar){
               arc.llenar();
               botonCargar.setEnabled(false);
            }else if(hace.getSource()== botonImprimir){
               pantalla.setText(arc.imprimirAl());
            }else if(hace.getSource()== botonBusqueda){
                try{
               pantalla.setText(arc.buscar(cajita.getText()));
                }
                catch(Exception er){
                pantalla.setText("\n\n\n¡INGRESASTE MAL LOS DATOS!");
                }
            }
    }*/
    
    //BOTONES
    public JButton confCalcular(){
       JButton algo = new JButton("Calcular Figura");
       algo.setBounds(40, 20,150,50);
       //algo.addActionListener(this);
       return algo;
    }
    
    public JLabel confJLabel(){
        JLabel temp=new JLabel("Posicion de figura");
        temp.setSize(200,20);
        temp.setLocation(40,75);
        return temp;
        
    }
        
    public JTextField confiText(){
       JTextField caja= new JTextField();
       caja.setSize(150,20);
       caja.setLocation(40,100);
       return caja;
    }
        
    public JButton confArea(){
       JButton btnSearch=new JButton("Area");
       btnSearch.setSize(120,40);
       btnSearch.setLocation(40,130);
      // btnSearch.addActionListener(this);
       return btnSearch;
    }
    
    public JButton confPerimetro(){
       JButton btnSearch=new JButton("Perimetro");
       btnSearch.setSize(120,40);
       btnSearch.setLocation(40,200);
       //btnSearch.addActionListener(this);
       return btnSearch;
    }
    
    public JButton confAgregar(){
      JButton btn=new JButton("Agregar Figura");
      btn.setSize(150,50);
      btn.setLocation(40,500);
      //btn.addActionListener(this);
      
      return btn;
    }

   
    public JButton confEliminar(){
       JButton btnSearch=new JButton("Eliminar Figura");
       btnSearch.setSize(150,50);
       btnSearch.setLocation(40,600);
       //btnSearch.addActionListener(this);
       return btnSearch;
    }
    
    
    public Menu confArchivo(){
        Menu archivo = new Menu("Archivo");
        return archivo;
    }
    
    public MenuItem confMSalir(){
        MenuItem algo = new MenuItem("Salir");
        //algo.addActionListener(this);
        return algo;
    }
    

    
    // configuracion del scroll con textarea
    public JScrollPane confdesliza(){
        pant_datos =new JTextArea();
        pant_datos.setEditable(false);
        JScrollPane scroll=new JScrollPane(pant_datos);
         scroll.setBounds(270,20,700,200);
         scroll.setVisible(true);
        return scroll;
    
    }
    
    public JScrollPane confResus(){
        pant_resus =new JTextArea();
        pant_resus.setEditable(false);
        JScrollPane scroll=new JScrollPane(pant_resus);
         scroll.setBounds(270,250,700,200);
         scroll.setVisible(true);
        return scroll;
     
    } 
   
    
}