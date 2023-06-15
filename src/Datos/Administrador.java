package Datos;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Administrador{

    private int idUsuario;
    private String nombre;
    private String apellido;
    private static List<Administrador> listaAdministradores = new ArrayList<>();

    public Administrador(int idUsuario, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        listaAdministradores.add(this);
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

    public static List<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void llamarCliente(int idCliente) {

        Cliente cliente = buscarClienteId(idCliente);

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Llamando al cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        }
        else {
            JOptionPane.showMessageDialog(null, "No se encontró un cliente con el ID ingresado.");
        }
    }

    private Cliente buscarClienteId(int idCliente) {
        for (Cliente cliente : Cliente.getListaClientes()) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public void calcularPresupuesto() {
        int mat = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de materiales utilizados en la obra"));
        int presupuesto = mat * 20;
        JOptionPane.showMessageDialog(null, "El presupuesto por la cantidad de materiales utilizados es: " + presupuesto);
    }


    public void crearProyecto(int idCliente){

        Cliente cliente = buscarClienteId(idCliente);
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "El proyecto es para el cliente: " + cliente.getNombre() + " " + cliente.getApellido());
            int idProyecto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un ID para registrar el proyecto"));
            cliente.setIdProyecto(idProyecto);
            JOptionPane.showMessageDialog(null, "Al proyecto se le asigno el número: " + cliente.getIdProyecto());
            int cantMat = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de materiales para calcular el presupuesto"));
            cliente.setPresupuesto(cantMat*20);
            cliente.setMaterialesNecesarios(cantMat);
            JOptionPane.showMessageDialog(null, "El proyecto de " + cliente.getNombre() + " " + cliente.getApellido() +
                    "\n\nID: " + cliente.getIdProyecto()
                    + "\nCantidad de materiales: " +cliente.getMaterialesNecesarios()
                    + "\nPresupuesto total: " + cliente.getPresupuesto() + "$");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se encontró un cliente con el ID ingresado.");
        }
    }
    Conexion con = new Conexion();
    Connection conexion = con.conectar();
    PreparedStatement stmt;

    public boolean AgregarA() {
        String sql = "INSERT INTO `administrador`(`idUsuario`, `nombre`, `apellido`) VALUES (?,?,?)";

        try{
            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, this.getIdUsuario());
            stmt.setString(2, this.getNombre());
            stmt.setString(3, this.getApellido());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion) {
            System.out.println("Hubo un error" + excepcion.getMessage());
            return false;
        }
    }

    public List<Administrador> MostrarA() {
        String sql ="SELECT * FROM `recursoshumanos`";

        String[] datos = new String[4];

        try {

            stmt = conexion.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                datos[0]= String.valueOf(result.getInt(1));
                datos[1]= result.getString(2);
                datos[2]= result.getString(3);
                listaAdministradores.add(new Administrador(Integer.parseInt(datos[0]),datos[1],datos[2]));
            }

            return listaAdministradores;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return null;
        }

    }

    public boolean EditarA(int id) {
        String sql = "UPDATE `administrador` SET `idUsuario`=?,`nombre`=?,`apellido`=? WHERE 1";

        try{
            stmt = conexion.prepareStatement(sql);
            stmt.setLong(1, this.getIdUsuario());
            stmt.setString(2, this.getNombre());
            stmt.setString(3, this.getApellido());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion) {
            System.out.println("Hubo un error" + excepcion.getMessage());
            return false;
        }
    }

    public boolean EliminarA(int id) {
        String sql = "DELETE FROM `administrador` WHERE id = ?";

        try{
            stmt = conexion.prepareStatement(sql);
            stmt.setLong(1, this.getIdUsuario());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion) {
            System.out.println("Hubo un error" + excepcion.getMessage());
            return false;
        }
    }


    public boolean IngresoA() {
        String ingresante;
        int idi, a=0;

        idi=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID"));
        ingresante=JOptionPane.showInputDialog("Ingrese su nombre");

        if (!listaAdministradores.isEmpty()){
            for (int i=0; i < listaAdministradores.size() ; i++){
                if (listaAdministradores.get(i).getIdUsuario()==idi && listaAdministradores.get(i).getNombre().equalsIgnoreCase(ingresante)){
                    a=1;
                    i = listaAdministradores.size();
                } else {
                    a=0;
                }
            }


        } else  {
            JOptionPane.showMessageDialog(null, "La lista esta vacia, no hay operarios");
            a=0;
        }

        if (a==1){
            return true;
        } else {
            return false;
        }

    }




}


