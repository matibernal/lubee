import javax.swing.JOptionPane;

public class Administrador{

    private int idUsuario;
    private String nombre;
    private String apellido;

    public Administrador(int idUsuario, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void llamarCliente(Cliente cliente){
        int nroCliente=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente para obtener su número de celular"));
        if(nroCliente==cliente.getIdCliente()){
            JOptionPane.showMessageDialog(null,"El número de celular del cliente " + cliente.getNombre() + " " + cliente.getApellido() + " es: "+ cliente.getNumeroDeCelular());
        }
        else{
            JOptionPane.showMessageDialog(null, "Ese cliente no existe");
        }
    }

}
