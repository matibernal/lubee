package Negocio;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import Datos.Cliente;

public class Verifica{


    Cliente nuevocliente = new Cliente(0,"","","","");

    public LinkedList<Cliente> verificaListaClientes(){

        return nuevocliente.TraerClientes();
    }


    public boolean EliminarCliente(String apellido) {
        if(apellido.length()>=3 && apellido.length()<=30){
            return nuevocliente.EliminarCliente(apellido);
        }else {
            return false;
        }
    }


    public boolean verificarAñadirCliente(String dni, String nombre , String apellido, String numeroDeCelular) {
        int flag=0;
        do {
            if (nombre.length()>=3 &&  nombre.length()<=15){
                if (apellido.length()>=3 && apellido.length()<=30){
                    if (dni.length()==8){
                        if(numeroDeCelular.length()>=9 && numeroDeCelular.length()<=14) {
                            flag = 1;
                            nuevocliente.setDni(dni);
                            nuevocliente.setNombre(nombre);
                            nuevocliente.setApellido(apellido);
                            nuevocliente.setNumeroDeCelular(numeroDeCelular);
                            return nuevocliente.guardarCliente();
                        }else{
                            numeroDeCelular = JOptionPane.showInputDialog("Error al ingresar el telefono, debe tener entre 9 y 14 caracteres\n Ingre el telefono del cliente a añadir");
                        }
                    }else {
                        dni = JOptionPane.showInputDialog("Error al ingresar el dni debe tener 8 caracteres \n Ingrese el dni del cliente a añadir");
                    }
                }else {
                    apellido = JOptionPane.showInputDialog("Error al ingresar el apellido debe tener entre 3 y 15 letras \n Ingrese el apellido del cliente a añadir");
                }
            }else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombrel cliente a añadir");
            }
        }while(flag==0);
        return false;

    }
    public boolean verificarEditarNombre(String nombreNuevo) {
        int flag = 0;
        do {
            if (nombreNuevo.length() >= 3 && nombreNuevo.length() <= 15) {
                flag = 1;
                nuevocliente.setNombre(nombreNuevo);
                return nuevocliente.EditarClienteNombre();
            }
            else{
                nombreNuevo = JOptionPane.showInputDialog("Error al ingresar el nombre, debe tener entre 3 y 15 letras\n Ingrese el nombre del cliente a modificar");
            }
        }while(flag==0);
        return false;
    }
    public boolean verificarEditarApellido(String apellidoNuevo) {
        int flag = 0;
        do {
            if (apellidoNuevo.length() >= 3 && apellidoNuevo.length() <= 30) {
                flag = 1;
                nuevocliente.setApellido(apellidoNuevo);
                return nuevocliente.EditarClienteApellido();
            }
            else{
                apellidoNuevo = JOptionPane.showInputDialog("Error al ingresar el nombre, debe tener entre 3 y 15 letras\n Ingrese el nombre del cliente a modificar");
            }
        }while(flag==0);
        return false;
    }
    public boolean verificarEditarDni(String dniNuevo) {
        int flag = 0;
        do {
            if (dniNuevo.length()==8) {
                flag = 1;
                nuevocliente.setDni(dniNuevo);
                return nuevocliente.EditarClienteDni();
            }
            else{
                dniNuevo = JOptionPane.showInputDialog("Error al ingresar el nombre, debe tener entre 3 y 15 letras\n Ingrese el nombre del cliente a modificar");
            }
        }while(flag==0);
        return false;
    }
    public boolean verificarEditarTelefono(String numeroDeCelularNuevo) {
        int flag = 0;
        do {
            if (numeroDeCelularNuevo.length()>=9 && numeroDeCelularNuevo.length()<=14) {
                flag = 1;
                nuevocliente.setNumeroDeCelular(numeroDeCelularNuevo);
                return nuevocliente.EditarClienteTelefono();
            }
            else{
                numeroDeCelularNuevo = JOptionPane.showInputDialog("Error al ingresar el nombre, debe tener entre 3 y 15 letras\n Ingrese el nombre del cliente a modificar");
            }
        }while(flag==0);
        return false;
    }
    public boolean verificarCelular(String numeroDeCelular) {
        if (numeroDeCelular.length() >= 9 && numeroDeCelular.length() <= 14) {
            return nuevocliente.TraerTelefono(numeroDeCelular);
        } else {
            return false;
        }
    }




}
