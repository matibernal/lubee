package Negocio;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Datos.*;

public class Verifica {


    Obrero nuevoobrero = new Obrero(0,"","",true,0);

    Recursoshumanos nuevoTrabajador = new Recursoshumanos(0,"","",0);

    /*
    public LinkedList<Persona> verificaLista(){

        return nuevousuario.TraerUsuarios();
    }

     */


    public LinkedList<Recursoshumanos> verificaListaT(){
        return nuevoTrabajador.Mostrar();
    }

    public boolean EliminarT(int idTrabajdor){
        if (idTrabajdor >= 0) {
            return nuevoTrabajador.Eliminar(idTrabajdor);
        }else {
            return false;
        }
    }

    public boolean EditarT(int idTrabajador){
        if (idTrabajador >= 0) {
            return nuevoTrabajador.Editar(idTrabajador);
        }else{
            return false;
        }
    }

    public boolean VerificarAgregarT (int idTrabajador, String nombre, String apellido, int idSector){
        int flag = 0;
        do {

            if (nombre.length()>2 && nombre.length()<=15){
                if (apellido.length()>=3){
                    flag=1;
                    nuevoTrabajador.setIdTrabajador(idTrabajador);
                    nuevoTrabajador.setNombre(nombre);
                    nuevoTrabajador.setApellido(apellido);
                    nuevoTrabajador.setIdSector(idSector);
                    nuevoTrabajador.Agregar();
                    return true;

                }else {

                    apellido = JOptionPane.showInputDialog("Error al ingresar el apellido debe tener entre 3 y 15 letras \n Ingrese el apellido de la nueva persona a añadir");
                }
            }else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva persona a añadir");
            }
        }while(flag==0);
        return false;
    }

    public boolean verificarEliminar(int id) {
        if(id>0) {
            return nuevoobrero.Eliminar(id);
        }else {
            return false;
        }
    }


    public boolean verificarAgregar(int idobrero, String nombre , String apellido, boolean disponible, int idobra) {
        int dowhile=0;
        do {

            if (nombre.length()>2 && nombre.length()<=15){
                if (apellido.length()>=3){
                        dowhile=1;
                        nuevoobrero.setIdobrero(idobrero);
                        nuevoobrero.setNombre(nombre);
                        nuevoobrero.setApellidos(apellido);
                        nuevoobrero.setDisponible(disponible);
                        nuevoobrero.setId_obra(idobra);
                        nuevoobrero.Agregar();
                        return true;

                }else {
                    apellido = JOptionPane.showInputDialog("Error al ingresar el apellido debe tener entre 3 y 15 letras \n Ingrese el apellido de la nueva persona a añadir");
                }
            }else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva persona a añadir");
            }

        }while(dowhile==0);
        return false;

    }