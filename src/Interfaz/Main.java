package Interfaz;

import Datos.*;
import Interfaces.*;
import Negocio.*;

import javax.swing.*;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        Administrador Mati = new Administrador(1, "Matías", "Bernal");
        Operario operario = new Operario(0, "", "");
        Obrero obrero = new Obrero(0, "", "", true, 0);
        Maestro_obra maestro = new Maestro_obra("", 0, "", "", 0);
        Plano plano = new Plano(0, "", 0, 0);
        Recursoshumanos rrhh = new Recursoshumanos(1, "Juan", "Lopez", 0);
        proyecto_obra obra = new proyecto_obra(0, true, "", "");
        Materiales material = new Materiales("", 0, 0, 0, true);
        Maquinaria maquinaria = new Maquinaria("", true, "", 0);
        LinkedList<proyecto_obra> listaProyectos = new LinkedList<>();
        LinkedList<proyecto_obra> ObrerosEnObra = new LinkedList<>();
        LinkedList<Obrero> listaObreros = new LinkedList<>();
        LinkedList<Operario> listaOperarios = new LinkedList<>();
        LinkedList<Recursoshumanos> listaTrabajadores = new LinkedList<>();
        Verifica verifica = new Verifica();

        Menu(Mati, operario, rrhh, maestro, material, maquinaria, obrero, plano, obra, listaProyectos, ObrerosEnObra, listaObreros, listaOperarios, listaTrabajadores, verifica);


    }

    private static void Menu() {
    }

    public static void Menu(Administrador admin, Operario operario, Recursoshumanos rrhh, Maestro_obra maestro, Materiales material, Maquinaria maquinaria, Obrero obrero, Plano plano, proyecto_obra obra, LinkedList<proyecto_obra> listaProyectos, LinkedList<proyecto_obra> ObrerosenObra, LinkedList<Obrero> listaObreros, LinkedList<Operario> listaOperarios, LinkedList<Recursoshumanos> listaTrabajadores, Verifica verifica) {
        JOptionPane.showMessageDialog(null, "  Bienvenido a LUBEE La empresa numero 1 en construcciones", "LUBEE",JOptionPane.INFORMATION_MESSAGE);
        int a = 0;
        String[] usuarios = {"Administrador", "Recursos Humanos", "Maestro Mayor de Obra", "Operario"};
        String menuUsu= "";
        do {
            menuUsu = (String)JOptionPane.showInputDialog(null,"Ingreso de usuario", "LUBEE",JOptionPane.DEFAULT_OPTION, null, usuarios,usuarios);
            switch (menuUsu) {
                case "Administrador":
                    String contraAdmin = JOptionPane.showInputDialog("Ingrese la contraseña para acceder como administrador");
                    /*Administrador administradorEncontrado = null;

                    for (Administrador administrador : Administrador.getListaAdministradores()) {
                        if (idAdmin == administrador.getIdUsuario()) {
                            administradorEncontrado = administrador;
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"No se encontro ningún adminsitrador");
                        }
                    }*/

                    if (contraAdmin.equals(admin.getContrasena())) {
                        JOptionPane.showMessageDialog(null, "Bienvenido Administrador ");
                        String[] opciones= { "Agregar un cliente","Ver lista de clientes", "Eliminar un cliente", "Editar datos de un cliente","Llamar a un cliente", "Salir" };
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
                                        JOptionPane.showMessageDialog(null, "Cliente guardado correctamente en el sistema\n\nDatos guardados:\n\nNombre: " + nombre + "\nApellido: " + apellido + "\nDNI: " + dni + "\nTelefono: " + numeroDeCelular);
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
                                    if( verifica.verificaListaClientes().isEmpty()) {
                                        JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay clientes en la empresa");
                                    }else {
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
                                    }
                                    break;
                                case "Editar datos de un cliente":
                                    String [] opcionesEditar = new String[verifica.verificaListaClientes().size()];
                                    String[] opeditar = {"Cambiar nombre", "Cambiar apellido", "Cambiar DNI", "Cambiar telefono", "Cancelar"};
                                    String opEdit ="";
                                    do{
                                        opEdit =(String)JOptionPane.showInputDialog(null, "Opciones de edicion","Menu de edición",JOptionPane.DEFAULT_OPTION,null, opeditar,opeditar[0]);
                                        switch (opEdit){

                                            case "Cambiar nombre":
                                                if( verifica.verificaListaClientes().isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay clientes en la empresa");
                                                }else{
                                                    for (int i = 0; i < verifica.verificaListaClientes().size(); i++) {
                                                        opcionesEditar[i] = verifica.verificaListaClientes().get(i).getApellido();
                                                    }
                                                    String apellidoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el cliente a editar", "",
                                                            JOptionPane.DEFAULT_OPTION, null, opcionesEditar, opcionesEditar[0]);

                                                    if (apellidoSeleccionado != null) {
                                                        String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente");
                                                        if (verifica.verificarEditarNombre(apellidoSeleccionado, nombreNuevo)) {
                                                            JOptionPane.showMessageDialog(null, "Cambio guardado correctamente en el sistema, usted cambio el nombre a: " + nombreNuevo);
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Error: el cliente seleccionado no se encontró en la lista");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error: no se seleccionó ningún cliente");
                                                    }
                                                }

                                                break;

                                            case "Cambiar apellido":
                                                if( verifica.verificaListaClientes().isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay clientes en la empresa");
                                                }else{
                                                    for (int i = 0; i < verifica.verificaListaClientes().size(); i++) {
                                                        opcionesEditar[i] = verifica.verificaListaClientes().get(i).getApellido();
                                                    }
                                                    String apellidoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el cliente a editar", "",
                                                            JOptionPane.DEFAULT_OPTION, null, opcionesEditar, opcionesEditar[0]);

                                                    if (apellidoSeleccionado != null) {

                                                        String apellidoNuevo = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente");
                                                        if (verifica.verificarEditarApellido(apellidoSeleccionado, apellidoNuevo)) {
                                                            JOptionPane.showMessageDialog(null, "Cambio guardado correctamente en el sistema, usted cambio el apellido a: " + apellidoNuevo);
                                                        }else {
                                                            JOptionPane.showMessageDialog(null, "Error: el cliente seleccionado no se encontró en la lista");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error: no se seleccionó ningún cliente");
                                                    }
                                                }
                                                break;

                                            case "Cambiar DNI":
                                                if( verifica.verificaListaClientes().isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay clientes en la empresa");
                                                }else{
                                                    for (int i = 0; i < verifica.verificaListaClientes().size(); i++) {
                                                        opcionesEditar[i] = verifica.verificaListaClientes().get(i).getApellido();
                                                    }
                                                    String apellidoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el cliente a editar", "",
                                                            JOptionPane.DEFAULT_OPTION, null, opcionesEditar, opcionesEditar[0]);

                                                    if (apellidoSeleccionado != null) {

                                                        String dniNuevo = JOptionPane.showInputDialog("Ingrese el DNI nuevo del cliente");
                                                        if (verifica.verificarEditarDni(apellidoSeleccionado,dniNuevo)){
                                                            JOptionPane.showMessageDialog(null, "Cambio guardado correctamente en el sistema, usted cambio el DNI a : " + dniNuevo);
                                                        }else {
                                                            JOptionPane.showMessageDialog(null, "Error: el cliente seleccionado no se encontró en la lista");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error: no se seleccionó ningún cliente");
                                                    }
                                                }
                                                break;

                                            case "Cambiar telefono":
                                                if( verifica.verificaListaClientes().isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay clientes en la empresa");
                                                }else{
                                                    for (int i = 0; i < verifica.verificaListaClientes().size(); i++) {
                                                        opcionesEditar[i] = verifica.verificaListaClientes().get(i).getApellido();
                                                    }
                                                    String apellidoSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el cliente a editar", "",
                                                            JOptionPane.DEFAULT_OPTION, null, opcionesEditar, opcionesEditar[0]);

                                                    if (apellidoSeleccionado != null) {

                                                        String numeroDeCelularNuevo = JOptionPane.showInputDialog("Ingrese el nuevo telefono del cliente");
                                                        if (verifica.verificarEditarTelefono(apellidoSeleccionado, numeroDeCelularNuevo)) {
                                                            JOptionPane.showMessageDialog(null, "Cambio guardado correctamente en el sistema, usted cambio el telefono a: " + numeroDeCelularNuevo);
                                                        }else {
                                                            JOptionPane.showMessageDialog(null, "Error: el cliente seleccionado no se encontró en la lista");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Error: no se seleccionó ningún cliente");
                                                    }
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
                        JOptionPane.showMessageDialog(null, "La contraseña ingresada no es válida.");
                    }
                    break;

                case "Recursos Humanos":
                    listaTrabajadores = rrhh.Mostrar();

                    if (rrhh.Ingreso()) {
                        JOptionPane.showMessageDialog(null, "Ingreso concecido");


                        int opRrhh = 0;

                        String[] opciones = new String[]{"Modificaciones en el area de RRHH", "Modificaciones en el Area de Administracion", "Modificaciones en el Area de Operario"};
                        String opcion;

                        do {
                            opcion = (String) JOptionPane.showInputDialog(null,
                                    "Bienvenido! Que desea realizar?",
                                    "",
                                    JOptionPane.DEFAULT_OPTION,
                                    null,
                                    opciones,
                                    opciones[0]);

                            switch (opcion) {
                                case "Modificaciones en el area de RRHH": {
                                    String[] opci = new String[]{"Agregar trabajador", "Mostrar trabajador", "Eliminar trabajador", "Editar trabajador", "Salir"};
                                    String opcio;
                                    opcio = (String) JOptionPane.showInputDialog(null,
                                            "Bienvenido al Menu de RRHH, que desea realizar?",
                                            "",
                                            JOptionPane.DEFAULT_OPTION,
                                            null,
                                            opci,
                                            opci[0]);

                                    switch (opcio) {

                                        case "Agregar trabajador": {

                                            int idTrabajdor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del  nuevo trabaador"));
                                            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del trabajador a añadir");
                                            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del trabajador a añadir");
                                            int idSector = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del  sector del trabajador"));

                                            if (verifica.VerificarAgregarT(idTrabajdor, nombre, apellido, idSector)) {
                                                JOptionPane.showMessageDialog(null, "Trabajador guardado correctamente");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error");
                                            }
                                        }

                                        break;

                                        case "Mostrar trabajador": {
                                            if (verifica.verificaListaT().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay usuarios");
                                            } else {
                                                JOptionPane.showMessageDialog(null, verifica.verificaListaT());
                                            }

                                        }
                                        break;

                                        case "Eliminar Trabajador":

                                            if (verifica.verificaListaT().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "No se pueden eliminar los usuarios porque no existen");
                                            } else {

                                                String[] opcionesEliminar = new String[verifica.verificaListaT().size()];
                                                for (int i = 0; i < verifica.verificaListaT().size(); i++) {
                                                    opcionesEliminar[i] = Integer.toString(verifica.verificaListaT().get(i).getIdTrabajador());
                                                }

                                                opcio = (String) JOptionPane.showInputDialog(null,
                                                        "Opciones",
                                                        "",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        null,
                                                        opcionesEliminar,
                                                        opcionesEliminar[0]);
                                                int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Trabajador que desea eliminar"));
                                                if (verifica.EliminarT(Integer.parseInt(opcio))) {
                                                    JOptionPane.showMessageDialog(null, "Se elimino exitosamente");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                                                }

                                            }
                                            break;

                                        case "Editar Trabajador": {
                                            if (verifica.verificaListaT().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "No hay elementos para editar");
                                            } else {
                                                String[] opcioness = new String[verifica.verificaListaT().size()];
                                                for (int i = 0; i < verifica.verificaListaT().size(); i++) {
                                                    opcioness[i] = Integer.toString(verifica.verificaListaT().get(i).getIdTrabajador());
                                                }

                                                int id = Integer.parseInt((String) JOptionPane.showInputDialog(null,
                                                        "Ingrese el ID",
                                                        "",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        null,
                                                        opcioness,
                                                        opcioness[0]));
                                                System.out.println(id);
                                                for (Recursoshumanos recursoshumanos : verifica.verificaListaT()) {
                                                    if (recursoshumanos.getIdTrabajador() == id) {
                                                        JOptionPane.showMessageDialog(null, recursoshumanos);
                                                    }
                                                }
                                                if (verifica.EditarT(id)) {
                                                    JOptionPane.showMessageDialog(null, "Se edito exitosamente el Trabajador con ID" + id);
                                                    for (Recursoshumanos recursoshumanos : verifica.verificaListaT()) {
                                                        if (recursoshumanos.getIdTrabajador() == id) {
                                                            JOptionPane.showMessageDialog(null, recursoshumanos);
                                                        }

                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pudo editar ID");
                                                }
                                            }

                                        }
                                        break;

                                        default:
                                            break;
                                    }
                                }


                                case "Modificaciones en el Area de Administracion": {
                                    String[] opci = new String[]{"Agregar Usuario", "Mostrar Usuario", "Eliminar Usuario", "Editar Usuario", "Salir"};
                                    String opcio;
                                    opcio = (String) JOptionPane.showInputDialog(null,
                                            "Bienvenido al Menu de Administracion, que desea realizar?",
                                            "",
                                            JOptionPane.DEFAULT_OPTION,
                                            null,
                                            opci,
                                            opci[0]);

                                    switch (opcio) {

                                        case "Agregar Usuario": {

                                            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del  nuevo usuario"));
                                            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario a añadir");
                                            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del usuario a añadir");


                                            if (verifica.VerificarAgregarA(idUsuario, nombre, apellido)) {
                                                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error");
                                            }
                                        }

                                        break;

                                        case "Mostrar Usuario": {
                                            if (verifica.verificaListaA().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay usuarios");
                                            } else {
                                                JOptionPane.showMessageDialog(null, verifica.verificaListaA());
                                            }

                                        }
                                        break;

                                        case "Eliminar Usuario": {

                                            if (verifica.verificaListaA().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "No se pueden eliminar los usuarios porque no existen");
                                            } else {

                                                String[] opcionesEliminar = new String[verifica.verificaListaA().size()];
                                                for (int i = 0; i < verifica.verificaListaA().size(); i++) {
                                                    opcionesEliminar[i] = Integer.toString(verifica.verificaListaA().get(i).getIdUsuario());
                                                }

                                                opcio = (String) JOptionPane.showInputDialog(null,
                                                        "Opciones",
                                                        "",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        null,
                                                        opcionesEliminar,
                                                        opcionesEliminar[0]);
                                                int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Usuario que desea eliminar"));
                                                if (verifica.EliminarA(Integer.parseInt(opcio))) {
                                                    JOptionPane.showMessageDialog(null, "Se elimino exitosamente");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                                                }

                                            }
                                        }
                                        break;

                                        case "Editar Usuario": {
                                            if (verifica.verificaListaA().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "No hay elementos para editar");
                                            } else {
                                                String[] opcioness = new String[verifica.verificaListaA().size()];
                                                for (int i = 0; i < verifica.verificaListaA().size(); i++) {
                                                    opcioness[i] = Integer.toString(verifica.verificaListaA().get(i).getIdUsuario());
                                                }

                                                int id = Integer.parseInt((String) JOptionPane.showInputDialog(null,
                                                        "Ingrese el ID",
                                                        "",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        null,
                                                        opcioness,
                                                        opcioness[0]));
                                                System.out.println(id);
                                                for (Administrador administrador : verifica.verificaListaA()) {
                                                    if (administrador.getIdUsuario() == id) {
                                                        JOptionPane.showMessageDialog(null, administrador);
                                                    }
                                                }
                                                if (verifica.EditarA(id)) {
                                                    JOptionPane.showMessageDialog(null, "Se edito exitosamente el Usuario con ID" + id);
                                                    for (Administrador administrador : verifica.verificaListaA()) {
                                                        if (administrador.getIdUsuario() == id) {
                                                            JOptionPane.showMessageDialog(null, administrador);
                                                        }

                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pudo editar ID");
                                                }
                                            }
                                        }
                                        break;
                                        default:
                                            break;
                                    }
                                }
                                case "Modificaciones en el Area de Operario": {
                                    String[] opci = new String[]{"Agregar Operario", "Mostrar Operario", "Eliminar Operario", "Editar Operario", "Salir"};
                                    String opcio;
                                    opcio = (String) JOptionPane.showInputDialog(null,
                                            "Bienvenido al Menu de Operario, que desea realizar?",
                                            "",
                                            JOptionPane.DEFAULT_OPTION,
                                            null,
                                            opci,
                                            opci[0]);

                                    switch (opcio) {

                                        case "Agregar Operario": {

                                            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del nuevo Opeario"));
                                            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Operario a añadir");
                                            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del Operario a añadir");


                                            if (verifica.VerificarAgregarO(id, nombre, apellido)) {
                                                JOptionPane.showMessageDialog(null, "Operario guardado correctamente");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Error");
                                            }
                                        }

                                        break;

                                        case "Mostrar Operario": {
                                            if (verifica.verificaListaO().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay operarios");
                                            } else {
                                                JOptionPane.showMessageDialog(null, verifica.verificaListaO());
                                            }

                                        }
                                        break;

                                        case "Eliminar Operario": {

                                            if (verifica.verificaListaO().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "No se pueden eliminar los operarios porque no existen");
                                            } else {

                                                String[] opcionesEliminar = new String[verifica.verificaListaO().size()];
                                                for (int i = 0; i < verifica.verificaListaO().size(); i++) {
                                                    opcionesEliminar[i] = Integer.toString(verifica.verificaListaO().get(i).getId());
                                                }

                                                opcio = (String) JOptionPane.showInputDialog(null,
                                                        "Opciones",
                                                        "",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        null,
                                                        opcionesEliminar,
                                                        opcionesEliminar[0]);
                                                int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Operario que desea eliminar"));
                                                if (verifica.EliminarO(Integer.parseInt(opcio))) {
                                                    JOptionPane.showMessageDialog(null, "Se elimino exitosamente");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                                                }

                                            }
                                        }
                                        break;

                                        case "Editar Operario": {
                                            if (verifica.verificaListaO().isEmpty()) {
                                                JOptionPane.showMessageDialog(null, "No hay elementos para editar");
                                            } else {
                                                String[] opcioness = new String[verifica.verificaListaO().size()];
                                                for (int i = 0; i < verifica.verificaListaO().size(); i++) {
                                                    opcioness[i] = Integer.toString(verifica.verificaListaO().get(i).getId());
                                                }

                                                int id = Integer.parseInt((String) JOptionPane.showInputDialog(null,
                                                        "Ingrese el ID",
                                                        "",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        null,
                                                        opcioness,
                                                        opcioness[0]));
                                                System.out.println(id);
                                                for (Operario ope : verifica.verificaListaO()) {
                                                    if (ope.getId() == id) {
                                                        JOptionPane.showMessageDialog(null, ope);
                                                    }
                                                }
                                                if (verifica.EditarO(id)) {
                                                    JOptionPane.showMessageDialog(null, "Se edito exitosamente el Operario con ID" + id);
                                                    for (Operario ope : verifica.verificaListaO()) {
                                                        if (ope.getId() == id) {
                                                            JOptionPane.showMessageDialog(null, ope);
                                                        }

                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "No se pudo editar ID");
                                                }
                                            }
                                        }
                                        break;

                                        default:
                                            break;

                                    }
                                    opRrhh = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea salir del perfil de Recursos Humanos. Cualquier número para continuar"));
                                }


                            }
                            break;
                        } while (opRrhh != 1);
                    }


                case "Maestro Mayor de Obra":
                    // if (Ingreso Maestro mayor de obra is true) {

                    int opcionmaestro = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al Menu de Maestro Mayor de Obra " +
                            "\n Asignar Obreros a una obra" +
                            "\n Seccion de planos" +
                            "\n Solicitar Datos.Materiales" +
                            "\n Solicitar Maquinarias"));
                    switch (opcionmaestro) {

                        case 1:
                            //obrero.AsignarObrero(obra, listaProyectos, ObrerosenObra);

                            break;
                        case 2:
                            int opcionplanos = Integer.parseInt(JOptionPane.showInputDialog("Seccion Planos " +
                                    "\n Ver Plano" +
                                    "\n Relizar Plano" +
                                    "\n Modificar Plano" +
                                    "\n Eliminar plano"));
                            switch (opcionplanos) {
                                case 1:
                                    plano.Agregar();

                                    break;
                                case 2:
                                    // ver plano

                                    break;
                                case 3:
                                    // modificar plano

                                    break;
                                case 4:
                                    // eliminar plano

                                    break;


                            }

                            break;

                        case 3:
                            material.SolicitarMateriales();

                            break;
                        case 4:
                            maquinaria.solicitarMaquinarias();

                            break;


                    }

                case "Operario":
                    listaOperarios = operario.MostrarO();
                    if (operario.IngresoO() == true) {
                        JOptionPane.showMessageDialog(null, "Ingreso concedido");
                        int opcionoperario = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al Menu de Datos.Operario " +
                                "\n 1- Realizar Inventario" +
                                "\n 2- Agregar Maquinarias" +
                                "\n 3- Agregar Datos.Materiales" +
                                "\n 4- Ver historial de inventarios" +
                                "\n 5- Agregar Obreros" +
                                "\n 6- Ver Obreros" +
                                "\n 7- Eliminar Obreros"));
                        switch (opcionoperario) {

                            case 1:
                                operario.RealizarInvenario();

                                break;
                            case 2:
                                maquinaria.AgregarMaquinaria();

                                break;

                            case 3:
                                material.AgregarMateriales();

                                break;
                            case 4:
                                operario.HistorialInventarios();

                                break;
                            case 5:

                                int idobrero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del  nuevo obrero"));
                                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo obrero a añadir");
                                String apellido = JOptionPane.showInputDialog("Ingrese el apellido del nuevo obrero a añadir");
                                Boolean disponible = true;
                                int idobra = 0;
                                if (verifica.verificarAgregar(idobrero, nombre, apellido, disponible, idobra)) {
                                    JOptionPane.showMessageDialog(null, "Usuario guardado correctamente");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Error");
                                }
                                break;
                            case 6:
                                JOptionPane.showMessageDialog(null, obrero.Mostrar());


                                break;

                            case 7:

                                listaObreros = obrero.Mostrar();
                                if (listaObreros.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "No se pueden eliminar los usuarios porque no existen");

                                } else {

                                    idobrero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del obrero que quiere eliminar"));

                                    for (int i = 0; i < listaObreros.size(); i++) {
                                        if (idobrero == listaObreros.get(i).getiIdobrero()) {
                                            if (verifica.verificarEliminar(idobrero)) {
                                                JOptionPane.showMessageDialog(null, "Lo eliminó existosamente");
                                            }
                                        }
                                    }
                                }
                                break;
                            case 8:
                                //modificar obrero.
                                idobrero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del obrero que quiere modificar"));
                                listaObreros = obrero.Mostrar();
                                for (int i = 0; i < listaObreros.size(); i++) {
                                    if (idobrero == listaObreros.get(i).getiIdobrero()) { //ya tengo el obrero identificado
                                        JOptionPane.showMessageDialog(null, "El obrero a modificar es: " + listaObreros.get(i));
                                        int opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de lo que desea modificar. 1-id 2-nombre 3-apellido 4-disponible 5-id obra asignada"));
                                        switch (opc) {
                                            case 1:


                                                break;

                                            case 2:


                                                break;


                                            case 3:


                                                break;


                                            case 4:

                                                break;


                                            case 5:


                                                break;


                                            default:

                                                break;

                                        }
                                        /*
                                        if (verifica.verificarModificar(idobrero)){
                                            JOptionPane.showMessageDialog(null, "Lo eliminó existosamente");
                                        }
                                         */
                                    }
                                }

                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Validacion incorrecta main");
                    }

                default:
                    JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta. Por favor ingrese una opcion valida");
                    break;
            }
        }while (a != 1) ;
        a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea salir del sistema completo. Cualquier numero para continuar"));
        JOptionPane.showMessageDialog(null, "Usted ha salido del sistema. Gracias por visitarnos. \n EMPRESA LUBEE");
    }
}
