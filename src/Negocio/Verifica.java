package Negocio;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Datos.Cliente;

public class Verifica{


    Cliente nuevocliente = new Cliente(0,"","","","");

    public LinkedList<Cliente> verificaListaClientes(){

        return nuevocliente.TraerClientes();
    }


    public boolean EliminarCliente(String nombre) {
        if(nombre.length()>=3) {
            return nuevocliente.EliminarCliente(nombre);
        }else {
            return false;
        }
    }


    public boolean verificarAñadirCliente(String dni, String nombre , String apellido) {
        int flag=0;
        do {


            if (nombre.length()>=3 &&  nombre.length()<=15){
                if (apellido.length()>=3){
                    if (dni.length()==8){
                        flag=1;
                        nuevocliente.setDni(dni);
                        nuevocliente.setNombre(nombre);
                        nuevocliente.setApellido(apellido);
                        return nuevocliente.guardarCliente();
                    }else {
                        dni = JOptionPane.showInputDialog("Error al ingresar el dni debe tener 8 caracteres \n Ingrese el dni de la nueva persona a añadir");
                    }
                }else {
                    apellido = JOptionPane.showInputDialog("Error al ingresar el apellido debe tener entre 3 y 15 letras \n Ingrese el apellido de la nueva persona a añadir");
                }
            }else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva persona a añadir");
            }
        }while(flag==0);
        return false;

    }
}
