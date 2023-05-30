package Datos;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Operario { //falta implementar interfaz y hacer guardar y eliminar + editar
    int id;
    private String nombre;
    private String apellido;
    Materiales materiales;
    Maquinaria maquinaria;
    private LinkedList<Operario> listaInventario;
    LinkedList<Operario> listaOperarios = new LinkedList<Operario>();



    public Operario(int id, String nombre, String apellido) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setApelldio(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Operario: ID= " + id  + " nombre=" + nombre + "]";
    }

    Conexion con = new Conexion();
    Connection conexion = con.conectar();
    PreparedStatement stmt;


    public LinkedList<Operario> Mostrar() {
        String sql ="SELECT * FROM `operario`";

        String[] datos = new String[3];

        try {

            stmt = conexion.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                datos[0]= String.valueOf(result.getInt(1));
                datos[1]= result.getString(2);
                datos[2]= result.getString(3);
                listaOperarios.add(new Operario(Integer.parseInt(datos[0]),datos[1],datos[2]));
            }

            return listaOperarios;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return null;
        }

        }



    public boolean Ingreso() {
        String nombrei;
        int idi, a=0;

        idi=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID"));
        nombrei=JOptionPane.showInputDialog("Ingrese su nombre");

        if (!listaOperarios.isEmpty()){
                for (int i=0; i < listaOperarios.size() ; i++){
                    if (listaOperarios.get(i).getId()==idi && listaOperarios.get(i).getNombre().equalsIgnoreCase(nombrei)){
                            a=1;
                            i = listaOperarios.size();
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

        /*

    public boolean IngresoOperario() {
        //id = 1 2022 contra = 1010
        String nombrei;
        int idi;
        int exitoso=0; // ingreso exitoso
        int ide;


        nombrei= JOptionPane.showInputDialog("Ingrese su nombre");


        Operario operario = new Operario (1, "", "");

        do {

            ide=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su id"));


            if (ide== operario.getId() ){

                System.out.println("Datos.Usuario: " + nombre + " Ingreso correctamente ");
                exitoso = 0;
                return true;

            }else {
                System.out.println("Id Incorrecto, ingreseselo otra vez ");
                exitoso = 1;
                return false;
            }

        } while ( exitoso == 1);

    }

         */


    public void RealizarInvenario() {
        // hacer en el main porque hay q combinar materiales con maquinaria

        int a;
        String fechainventario;

        a=Integer.parseInt(JOptionPane.showInputDialog("Usted va a realizar el inventario. Se le mostraran los materiales y las maquinarias disponibles. Numero 1: si acepta. Numero 2: si desea salir"));
        if (a==1) {
           JOptionPane.showMessageDialog(null, "Los materiales disponibles en el inventario son: " );
           JOptionPane.showMessageDialog(null, "Las maquinarias disponibles en el inventario son: ");
        } else {

        }


        // los materialesson estos y mostrar cantidad con for y contador
        //las maquinarias son estas mostrar cantidad con for y contador
        //agregar inventario a linked list de inventario



    }

    public void HistorialInventarios() {
        JOptionPane.showMessageDialog(null, listaInventario);
    }




}
