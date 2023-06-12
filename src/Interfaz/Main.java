package Interfaz;

import Datos.Administrador;
import Datos.Cliente;
import Negocio.Verifica;

import javax.swing.JOptionPane;

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
                        String[] opciones= { "Agregar un cliente","Ver lista de clientes", "Eliminar un cliente", "Llamar a un cliente","Calcular el presupuesto","Crear un proyecto", "Contactar proveedores", "Salir" };
                        String opAdm="";
                        do {
                            opAdm = (String)JOptionPane.showInputDialog(null, "Opciones de menu","",JOptionPane.DEFAULT_OPTION,null, opciones,opciones[0]);
                            switch(opAdm) {
                                case "Agregar un cliente":
                                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
                                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
                                    String dni = JOptionPane.showInputDialog("Ingrese el dni del cliente");
                                    if (verifica.verificarAñadirCliente(dni, nombre, apellido)) {
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
                                        opcionesEliminar[i] = verifica.verificaListaClientes().get(i).getNombre();
                                    }
                                    opAdm = (String)JOptionPane.showInputDialog(null, "Opciones del menu de eliminacion","",JOptionPane.DEFAULT_OPTION,null, opcionesEliminar,opcionesEliminar[0]);

                                    if( verifica.EliminarCliente(opAdm)) {
                                        JOptionPane.showMessageDialog(null, "Usted elimino al cliente con exito");
                                    }else {
                                        JOptionPane.showMessageDialog(null, "No se encontro ningun cliente o no se pudo eliminarlo");
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