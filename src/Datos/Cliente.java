package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cliente{

    private int idCliente;
    private String dni;
    private String nombre;
    private String apellido;
    private String numeroDeCelular;
    private int idProyecto;
    private int presupuesto;
    private int materialesNecesarios;
    private static List<Cliente> listaClientes = new ArrayList<>();

    Conexion con = new Conexion();

    Connection conexion = con.conectar();

    PreparedStatement stmt;

    public Cliente(int idCliente, String dni, String nombre, String apellido, String numeroDeCelular) {
        this.idCliente = idCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeCelular = numeroDeCelular;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getNumeroDeCelular() {
        return numeroDeCelular;
    }

    public void setNumeroDeCelular(String numeroDeCelular) {
        this.numeroDeCelular = numeroDeCelular;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getMaterialesNecesarios() {
        return materialesNecesarios;
    }

    public void setMaterialesNecesarios(int materialesNecesarios) {
        this.materialesNecesarios = materialesNecesarios;
    }

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public boolean guardarCliente() {

        String sql ="INSERT INTO `cliente`(`idcliente`,`nombre`, `apellido`,`dni`, `telefono`) VALUES (?,?,?,?,?)";

        try {

            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, this.getIdCliente());
            stmt.setString(2, this.getNombre());
            stmt.setString(3, this.getApellido());
            stmt.setString(4, this.getDni());
            stmt.setString(5,this.getNumeroDeCelular());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return false;
        }
    }

    public LinkedList<Cliente> TraerClientes() {
        LinkedList<Cliente> clientes = new LinkedList<Cliente>();
        String sql ="SELECT * FROM `cliente`";

        String[] datos = new String[5];
        try {

            stmt = conexion.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                datos[0]= result.getString(1);
                datos[1]= result.getString(2);
                datos[2]= result.getString(3);
                datos[3]= result.getString(4);
                datos[4]= result.getString(5);
                clientes.add(new Cliente(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3], datos[4]));
            }

            return clientes;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return null;
        }

    }
    public boolean EliminarCliente(String apellido) {

        String sql ="DELETE FROM `cliente` WHERE apellido = ?";

        try {

            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, apellido);
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return false;
        }
    }
    public boolean EditarClienteNombre(){

        String sql = "UPDATE `cliente` SET nombre = ? WHERE idcliente = ?";

        try{

            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, getNombre());
            stmt.setInt(2, getIdCliente());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return false;
        }
    }

    public boolean EditarClienteApellido(){

        String sql = "UPDATE `cliente` SET apellido = ? WHERE idcliente = ?";

        try{

            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, getApellido());
            stmt.setInt(2, getIdCliente());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return false;
        }
    }

    public boolean EditarClienteDni(){

        String sql = "UPDATE `cliente` SET dni = ? WHERE idcliente = ?";

        try{

            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, getDni());
            stmt.setInt(2, getIdCliente());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return false;
        }
    }
    public boolean EditarClienteTelefono(){

        String sql = "UPDATE `cliente` SET telefono = ? WHERE idcliente = ?";

        try{

            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, getNumeroDeCelular());
            stmt.setInt(2, getIdCliente());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return false;
        }
    }
    public boolean TraerTelefono(String numeroDeCelular) {
        String sql = "SELECT telefono FROM cliente WHERE telefono = ?";

        try {
            stmt = conexion.prepareStatement(sql);
            stmt.setString(1, numeroDeCelular);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                return true;
            }
        } catch (Exception excepcion) {
            System.out.println(excepcion.getMessage());
        }

        return false;
    }


    @Override
    public String toString() {
        return "Cliente Nro: " + getIdCliente() + " Nombre completo: " + getNombre() + " " + getApellido() + " DNI: "+ getDni() + " Telefono: "+ getNumeroDeCelular() + "\n\n";
    }
}