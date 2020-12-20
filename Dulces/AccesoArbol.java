public class AccesoArbol
{
    ArchivoDulces ad;
    Arbol a;
    public AccesoArbol() throws Exception{
        ad = new ArchivoDulces();
        a = ad.cargarArbol();
    }
    
    public void inOrder(){
        a.inOrden();
    }
    public void imprimir(){
        ad.imprimir();
    }
    public void buscarDulce(int i)throws Exception{
        if(a.buscarA(i)){
            System.out.println(ad.mostrarDulce(a.buscarCod(i)).toString());
        }else
            System.out.println("No existe el codigo");
    }
    public void eliminar(int codigo) throws Exception{
        if(a.buscarA(codigo)){
            Dulce x = ad.mostrarDulce(a.buscarCod(codigo));
            
            a.Eliminar(codigo);
            ad.depuraTx(a);
            System.out.println("\n\nElimino");
            System.out.println(x.toString());
        }
        else{
            System.out.println("No existe el codigo");
        }
    }
    public void agrega(Dulce d)throws Exception{
        if(!a.buscarA(d.getId())){
            ad.Agrega(d);
            a = ad.cargarArbol();
            System.out.println("\n\nAgrego");
            System.out.println(d.toString());
        }
        else{
            System.out.println("El codigo se repite");
        }
    }
}
