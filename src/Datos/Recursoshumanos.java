package Datos;

import Interfaces.Interfaces;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class Recursoshumanos implements Interfaces {


        private int idTrabajador;
        private String nombre;
        private String apellido;
        private int idSector;
        private LinkedList<Recursoshumanos> listaTrabajadores = new LinkedList<>();


    public Recursoshumanos(int idTrabajador, String nombre, String apellido, int idSector) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idSector = idSector;

    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
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

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public LinkedList<Recursoshumanos> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(LinkedList<Recursoshumanos> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    @Override
    public String toString() {
        return "Recursoshumanos: " +
                "idTrabajador=" + idTrabajador +
                "\n nombre='" + nombre + '\'' +
                "\n apellido='" + apellido + '\'' +
                "\n idSector=" + idSector;
    }

    Conexion con = new Conexion();
    Connection conexion = con.conectar();
    PreparedStatement stmt;

    public boolean Agregar() {
        String sql = "INSERT INTO `recursoshumanos`(`idtrabajador`, `nombre`, `apellido`, `idsector`) VALUES (?,?,?,?)";

        try{
            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, this.getIdTrabajador());
            stmt.setString(2, this.getNombre());
            stmt.setString(3, this.getApellido());
            stmt.setInt(4, this.getIdSector());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion) {
            System.out.println("Hubo un error" + excepcion.getMessage());
            return false;
        }
    }


    public LinkedList<Recursoshumanos> Mostrar() {
        String sql ="SELECT * FROM `recursoshumanos`";

        String[] datos = new String[4];

        try {

            stmt = conexion.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                datos[0]= String.valueOf(result.getInt(1));
                datos[1]= result.getString(2);
                datos[2]= result.getString(3);
                datos[3]= String.valueOf(result.getInt(4));
                listaTrabajadores.add(new Recursoshumanos(Integer.parseInt(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3])));
            }

            return listaTrabajadores;

        }catch(Exception excepcion){
            System.out.println(excepcion.getMessage());
            return null;
        }

    }

    public boolean Editar(int id) {
        String sql = "UPDATE `recursoshumanos` SET `idtrabajador`=?,`nombre`=?,`apellido`=?,`idsector`=? WHERE 1";

        try{
            stmt = conexion.prepareStatement(sql);
            stmt.setLong(1, this.getIdTrabajador());
            stmt.setString(2, this.getNombre());
            stmt.setString(3, this.getApellido());
            stmt.setLong(4, this.getIdSector());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion) {
            System.out.println("Hubo un error" + excepcion.getMessage());
            return false;
        }
    }

    public boolean Eliminar(int id) {
        String sql = "DELETE FROM `recursoshumanos` WHERE id = ?";

        try{
            stmt = conexion.prepareStatement(sql);
            stmt.setLong(1, this.getIdSector());
            stmt.executeUpdate();
            return true;

        }catch(Exception excepcion) {
            System.out.println("Hubo un error" + excepcion.getMessage());
            return false;
        }
    }


    public boolean Ingreso() {
        String ingresante;
        int idi, a=0;

        idi=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID"));
        ingresante=JOptionPane.showInputDialog("Ingrese su nombre");

        if (!listaTrabajadores.isEmpty()){
            for (int i=0; i < listaTrabajadores.size() ; i++){
                if (listaTrabajadores.get(i).getIdTrabajador()==idi && listaTrabajadores.get(i).getNombre().equalsIgnoreCase(ingresante)){
                    a=1;
                    i = listaTrabajadores.size();
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


