package Negocio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import Datos.*;

public class Verifica {


    Obrero nuevoobrero = new Obrero(0, "", "", true, 0);
    Maquinaria nuevamaquinaria = new Maquinaria(0,"",true,"",0);
    Materiales nuevomaterial = new Materiales (0,"",0,0);
    Recursoshumanos nuevoTrabajador = new Recursoshumanos(0, "", "", 0);
    Administrador nuevoAdmi = new Administrador(0,"","");
    Operario nuevoOpe = new Operario(0,"","");

    public LinkedList<Operario> verificaListaO(){
        return nuevoOpe.MostrarO();
    }

    public boolean EditarO(int id) {
        if (id >= 0) {
            return nuevoOpe.EditarO(id);
        } else {
            return false;
        }
    }
    public boolean EliminarO(int id) {
        if (id >= 0) {
            return nuevoOpe.EliminarO(id);
        } else {
            return false;
        }
    }

    public boolean VerificarAgregarO(int id, String nombre, String apellido) {
        int flag = 0;
        do {

            if (nombre.length() > 2 && nombre.length() <= 15) {
                if (apellido.length() >= 3) {
                    flag = 1;
                    nuevoOpe.setId(id);
                    nuevoOpe.setNombre(nombre);
                    nuevoOpe.setApellido(apellido);
                    nuevoOpe.AgregarO();
                    return true;

                } else {

                    apellido = JOptionPane.showInputDialog("Error al ingresar el apellido debe tener entre 3 y 15 letras \n Ingrese el apellido de la nueva persona a añadir");
                }
            } else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva persona a añadir");
            }
        } while (flag == 0);
        return false;
    }



    public List<Administrador> verificaListaA(){
        return nuevoAdmi.MostrarA();
    }

    public boolean EditarA(int idUsuario) {
        if (idUsuario >= 0) {
            return nuevoAdmi.EditarA(idUsuario);
        } else {
            return false;
        }
    }

    public boolean EliminarA(int idUsuario) {
        if (idUsuario >= 0) {
            return nuevoAdmi.EliminarA(idUsuario);
        } else {
            return false;
        }
    }
    public boolean VerificarAgregarA(int idUsuario, String nombre, String apellido) {
        int flag = 0;
        do {

            if (nombre.length() > 2 && nombre.length() <= 15) {
                if (apellido.length() >= 3) {
                    flag = 1;
                    nuevoAdmi.setIdUsuario(idUsuario);
                    nuevoAdmi.setNombre(nombre);
                    nuevoAdmi.setApellido(apellido);
                    nuevoAdmi.AgregarA();
                    return true;

                } else {

                    apellido = JOptionPane.showInputDialog("Error al ingresar el apellido debe tener entre 3 y 15 letras \n Ingrese el apellido de la nueva persona a añadir");
                }
            } else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva persona a añadir");
            }
        } while (flag == 0);
        return false;
    }




    /*
    public LinkedList<Persona> verificaLista(){

        return nuevousuario.TraerUsuarios();
    }

     */


    public LinkedList<Recursoshumanos> verificaListaT() {
        return nuevoTrabajador.Mostrar();
    }

    public boolean EliminarT(int idTrabajdor) {
        if (idTrabajdor >= 0) {
            return nuevoTrabajador.Eliminar(idTrabajdor);
        } else {
            return false;
        }
    }

    public boolean EditarT(int idTrabajador) {
        if (idTrabajador >= 0) {
            return nuevoTrabajador.Editar(idTrabajador);
        } else {
            return false;
        }
    }

    public boolean VerificarAgregarT(int idTrabajador, String nombre, String apellido, int idSector) {
        int flag = 0;
        do {

            if (nombre.length() > 2 && nombre.length() <= 15) {
                if (apellido.length() >= 3) {
                    flag = 1;
                    nuevoTrabajador.setIdTrabajador(idTrabajador);
                    nuevoTrabajador.setNombre(nombre);
                    nuevoTrabajador.setApellido(apellido);
                    nuevoTrabajador.setIdSector(idSector);
                    nuevoTrabajador.Agregar();
                    return true;

                } else {

                    apellido = JOptionPane.showInputDialog("Error al ingresar el apellido debe tener entre 3 y 15 letras \n Ingrese el apellido de la nueva persona a añadir");
                }
            } else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva persona a añadir");
            }
        } while (flag == 0);
        return false;
    }

    public boolean verificarEliminar(int id) {
        if (id > 0) {
            return nuevoobrero.Eliminar(id);
        } else {
            return false;
        }
    }


    public boolean verificarAgregar(int idobrero, String nombre, String apellido, boolean disponible, int idobra) {
        int dowhile = 0;
        do {

            if (nombre.length() > 2 && nombre.length() <= 15) {
                if (apellido.length() >= 3) {
                    dowhile = 1;
                    nuevoobrero.setIdobrero(idobrero);
                    nuevoobrero.setNombre(nombre);
                    nuevoobrero.setApellidos(apellido);
                    nuevoobrero.setDisponible(disponible);
                    nuevoobrero.setId_obra(idobra);
                    nuevoobrero.Agregar();
                    return true;

                } else {
                    apellido = JOptionPane.showInputDialog("Error al ingresar el apellido debe tener entre 3 y 15 letras \n Ingrese el apellido de la nueva persona a añadir");
                }
            } else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva persona a añadir");
            }

        } while (dowhile == 0);
        return false;

    }

    public boolean verificarEditar(Obrero obrero) {
        if (obrero.getiIdobrero() > 0) {
            obrero.EditarObrero(obrero);
            return true;
        } else {
            return false;
        }
    }

    //VERIFICACION DE CLIENTE

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


    public boolean verificarAnadirCliente(String dni, String nombre , String apellido, String numeroDeCelular) {
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
    public boolean verificarEditarNombre(String apellidoSeleccionado, String nombreNuevo) {
        int flag = 0;
        do {
            if (nombreNuevo.length() >= 3 && nombreNuevo.length() <= 15) {
                flag = 1;
                LinkedList<Cliente> listaClientes = nuevocliente.TraerClientes();
                for (Cliente cliente : listaClientes) {
                    if (cliente.getApellido().equals(apellidoSeleccionado)) {
                        cliente.setNombre(nombreNuevo);
                        return cliente.EditarClienteNombre();
                    }
                }
                return false;
            }else{
                nombreNuevo = JOptionPane.showInputDialog("Error al ingresar el nombre, debe tener entre 3 y 15 letras\n Ingrese el nombre del cliente a modificar");
            }
        } while (flag == 0);
        return false;
    }



    public boolean verificarEditarApellido(String apellidosSeleccionado, String apellidoNuevo) {
        int flag = 0;
        do {
            if (apellidoNuevo.length() >= 3 && apellidoNuevo.length() <= 30) {
                flag = 1;
                LinkedList<Cliente> listaClientes = nuevocliente.TraerClientes();
                for (Cliente cliente : listaClientes) {
                    if (cliente.getApellido().equals(apellidosSeleccionado)) {
                        cliente.setApellido(apellidoNuevo);
                        return cliente.EditarClienteApellido();
                    }
                }
                return false;
            }else{
                apellidoNuevo = JOptionPane.showInputDialog("Error al ingresar el apellido, debe tener entre 3 y 30 letras\n Ingrese el apellido del cliente a modificar");
            }
        }while(flag==0);
        return false;
    }
    public boolean verificarEditarDni(String apellidosSeleccionado, String dniNuevo) {
        int flag = 0;
        do {
            if (dniNuevo.length()==8) {
                flag = 1;
                LinkedList<Cliente> listaClientes = nuevocliente.TraerClientes();
                for (Cliente cliente : listaClientes) {
                    if (cliente.getApellido().equals(apellidosSeleccionado)) {
                        cliente.setDni(dniNuevo);
                        return cliente.EditarClienteDni();
                    }
                }
                return false;
            }else{
                dniNuevo = JOptionPane.showInputDialog("Error al ingresar el DNI, debe tener entre 8 digitos exactos\n Ingrese el DNI del cliente a modificar");
            }
        }while(flag==0);
        return false;
    }
    public boolean verificarEditarTelefono(String apellidosSeleccionado, String numeroDeCelularNuevo) {
        int flag = 0;
        do {
            if (numeroDeCelularNuevo.length()>=9 && numeroDeCelularNuevo.length()<=14) {
                flag = 1;
                LinkedList<Cliente> listaClientes = nuevocliente.TraerClientes();
                for (Cliente cliente : listaClientes) {
                    if (cliente.getApellido().equals(apellidosSeleccionado)) {
                        cliente.setNumeroDeCelular(numeroDeCelularNuevo);
                        return cliente.EditarClienteTelefono();
                    }
                }
                return false;
            }
            else{
                numeroDeCelularNuevo = JOptionPane.showInputDialog("Error al ingresar el telefono, debe tener entre 9 y 14 digitos\n Ingrese el telefono del cliente a modificar");
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

    //VERIFICA MAQUINARIA
    public boolean verificarAgregarMaquinaria(int idmaquinaria, String tipo, boolean disponiblem, String patente, int cantidaddisponible) {
        int dowhile = 0;
        do {
            if (patente.length() > 3 && patente.length() <= 6) {
                    dowhile = 1;
                    nuevamaquinaria.setIdmaquinaria(idmaquinaria);
                    nuevamaquinaria.setTipo(tipo);
                    nuevamaquinaria.setDisponible(disponiblem);
                    nuevamaquinaria.setPatente(patente);
                    nuevamaquinaria.setCantidadDisponible(cantidaddisponible);
                    nuevamaquinaria.Agregar();
                    return true;

                } else {
                    patente = JOptionPane.showInputDialog("Error al ingresar la patente debe tener entre 3 y 6 caracteres \n Ingrese la patente nuevamente");
                }

        } while (dowhile == 0);
        return false;

    }


    //VERIFICA MATERIALES
    public boolean verificarAgregarMaterial(int id,String nombre,  int cantidaddisp, double precio) {
        int dowhile = 0;
        do {

            if (nombre.length() > 2 && nombre.length() <= 15) {
                if (precio > 0) {
                    dowhile = 1;
                    nuevomaterial.setId(id);
                    nuevomaterial.setNom(nombre);
                    nuevomaterial.setCantidaddisp(cantidaddisp);
                    nuevomaterial.setPrecio(precio);
                    nuevomaterial.Agregar();
                    return true;

                } else {
                    precio = Double.parseDouble(JOptionPane.showInputDialog("Error al ingresar el precio, debe tser mayor a 0 \n Ingrese el precio nuevamente"));
                }
            } else {
                nombre = JOptionPane.showInputDialog("Error al ingresar el nombre debe tener entre 3 y 15 letras \n Ingrese el nombre de la nueva persona a añadir");
            }

        } while (dowhile == 0);
        return false;

    }


}