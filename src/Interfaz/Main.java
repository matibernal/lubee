package Interfaz;

import Datos.Administrador;
import Datos.Cliente;
import Negocio.Verifica;

import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {



        Administrador Mati = new Administrador(1,"Matías","Bernal");
        Administrador Kei = new Administrador(2,"Keila","Degregorio");
        Administrador Maia = new Administrador(3,"Maia","Cohen");
        Administrador Toto = new Administrador(4,"Tomas","Tejada");
        Administrador Mili = new Administrador(5,"Milagros","Lobo");
        Menu();

    }

    public static void Menu() {
        JOptionPane.showMessageDialog(null, "  Bienvenido a LUBEE  ");
        JOptionPane.showMessageDialog(null, "  La empresa numero 1 en construcciones  ");
        int a = 0;
        do {

            int op = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la opcion correcta \n Numero 1: si es Administrador \n Numero 2: si es RRHH \n Numero 3: Si es Maestro Mayor de Obra"));
            switch (op) {
                case 1:
                    int idAdmin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de admin: "));
                    Administrador administradorEncontrado = null;

                    for (Administrador administrador : Administrador.getListaAdministradores()) {
                        if (idAdmin == administrador.getIdUsuario()) {
                            administradorEncontrado = administrador;
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"No se encontro ningún adminsitrador");
                        }
                    }

                    if (administradorEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "Bienvenido Administrador " + administradorEncontrado.getNombre() + " " + administradorEncontrado.getApellido());
                        Verifica verifica = new Verifica();
                        String[] opciones= { "Agregar un cliente","Ver lista de clientes", "Eliminar un cliente", "Editar datos de un cliente","Llamar a un cliente","Calcular el presupuesto", "Salir" };
                        String opAdm="";
                        do {
                            opAdm = (String)JOptionPane.showInputDialog(null, "Opciones de menu","",JOptionPane.DEFAULT_OPTION,null, opciones,opciones[0]);
                            switch(opAdm) {
                                case "Agregar un cliente":
                                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
                                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
                                    String dni = JOptionPane.showInputDialog("Ingrese el dni del cliente");
                                    String numeroDeCelular = JOptionPane.showInputDialog("Ingrese el número de telefono del cliente");
                                    if (verifica.verificarAñadirCliente(dni, nombre, apellido, numeroDeCelular)) {
                                        JOptionPane.showMessageDialog(null, "Cliente guardado correctamente en el sistema");
                                    }else {
                                        JOptionPane.showMessageDialog(null, "Error");
                                    }
                                    break;
                                case "Ver lista de clientes":
                                    if( verifica.verificaListaClientes().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay clientes en la empresa");
                                    }else {
                                        JOptionPane.showMessageDialog(null, verifica.verificaListaClientes());
                                    }
                                    break;
                                case "Eliminar un cliente":
                                    String [] opcionesEliminar = new String[verifica.verificaListaClientes().size()];
                                    for (int i=0; i < verifica.verificaListaClientes().size();i++) {
                                        opcionesEliminar[i] = verifica.verificaListaClientes().get(i).getApellido();
                                    }
                                    opAdm = (String)JOptionPane.showInputDialog(null, "Opciones del menu de eliminacion","",JOptionPane.DEFAULT_OPTION,null, opcionesEliminar,opcionesEliminar[0]);

                                    if( verifica.EliminarCliente(opAdm)) {
                                        JOptionPane.showMessageDialog(null, "Usted elimino al cliente con exito");
                                    }else {
                                        JOptionPane.showMessageDialog(null, "No se encontro ningun cliente o no se pudo eliminarlo");
                                    }
                                    break;
                                case "Editar datos de un cliente":
                                    String [] opcionesEditar = new String[verifica.verificaListaClientes().size()];
                                    for (int i=0; i < verifica.verificaListaClientes().size();i++) {
                                        opcionesEditar[i] = verifica.verificaListaClientes().get(i).getApellido();
                                    }
                                    opAdm = (String)JOptionPane.showInputDialog(null, "Opciones del menu de edición","",JOptionPane.DEFAULT_OPTION,null, opcionesEditar,opcionesEditar[0]);
                                    String[] opeditar = {"Cambiar nombre", "Cambiar apellido", "Cambiar DNI", "Cambiar telefono", "Cancelar"};
                                    String opEdit ="";
                                    do{
                                        opEdit =(String)JOptionPane.showInputDialog(null, "Opciones de edicion","Menu de edición",JOptionPane.DEFAULT_OPTION,null, opeditar,opeditar[0]);
                                        switch (opEdit){

                                            case "Cambiar nombre":
                                                String nombreNuevo= JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente");
                                                if (verifica.verificarEditarNombre(nombreNuevo)) {
                                                    JOptionPane.showMessageDialog(null, "Cliente guardado correctamente en el sistema");
                                                }else {
                                                    JOptionPane.showMessageDialog(null, "Error");
                                                }
                                                break;

                                            case "Cambiar apellido":
                                                String apellidoNuevo = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente");
                                                if (verifica.verificarEditarApellido(apellidoNuevo)) {
                                                    JOptionPane.showMessageDialog(null, "Cliente guardado correctamente en el sistema");
                                                }else {
                                                    JOptionPane.showMessageDialog(null, "Error");
                                                }
                                                break;

                                            case "Cambiar DNI":
                                                String dniNuevo = JOptionPane.showInputDialog("Ingrese el DNI nuevo del cliente");
                                                if (verifica.verificarEditarDni(dniNuevo)){
                                                    JOptionPane.showMessageDialog(null, "Cliente guardado correctamente en el sistema");
                                                }else {
                                                    JOptionPane.showMessageDialog(null, "Error");
                                                }
                                                break;

                                            case "Cambiar telefono":
                                                String numeroDeCelularNuevo = JOptionPane.showInputDialog("Ingrese el telefono nuevo del cliente");
                                                if (verifica.verificarEditarTelefono(numeroDeCelularNuevo)){
                                                    JOptionPane.showMessageDialog(null, "Cliente guardado correctamente en el sistema");
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "Error");
                                                }
                                                break;

                                            case "Cancelar":
                                                break;

                                            default:
                                                break;
                                        }
                                    }while(opEdit!="Cancelar");
                                    break;

                                case "Llamar a un cliente":
                                    LinkedList<Cliente> telofonoClientes = verifica.verificaListaClientes();
                                    String[] opcionesLlamado = new String[telofonoClientes.size()];

                                    for (int i = 0; i < telofonoClientes.size(); i++) {
                                        opcionesLlamado[i] = telofonoClientes.get(i).getApellido();
                                    }
                                    String apellidoSeleccionado = (String) JOptionPane.showInputDialog(null, "Opciones del menú de llamado", "", JOptionPane.DEFAULT_OPTION, null, opcionesLlamado, opcionesLlamado[0]);
                                    Cliente clienteSeleccionado = null;

                                    for (Cliente cliente : telofonoClientes) {
                                        if (cliente.getApellido().equals(apellidoSeleccionado)) {
                                            clienteSeleccionado = cliente;
                                            break;
                                        }
                                    }
                                    if (clienteSeleccionado != null && verifica.verificarCelular(clienteSeleccionado.getNumeroDeCelular())) {
                                        JOptionPane.showMessageDialog(null, "Llamando al cliente: " + clienteSeleccionado.getApellido() + "\n\n\n" + "Numero de celular: " + clienteSeleccionado.getNumeroDeCelular());
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Ese cliente no tiene un teléfono válido");
                                    }

                                    break;


                                case "Salir" :
                                    break;

                                default:
                                    break;
                            }


                        } while(!opAdm.equals("Salir" ));
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un administrador con el ID ingresado.");
                    }
                    break;

                case 2:
                    // (RRHH CODIGO)
                    break;

                case 3:
                    // if (Ingreso Maestro mayor de obra is true) {
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta. Por favor ingrese una opcion valida");
                    break;
            }


            a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea salir del sistema completo. Cualquier numero para continuar"));
        } while (a != 1);

        JOptionPane.showMessageDialog(null, "Usted ha salido del sistema. Gracias por visitarnos. \n EMPRESA LUBEE");


    }
}