package Interfaz;

import Datos.*;
import Interfaces.*;
import Negocio.*;

import javax.swing.*;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {

        Administrador Mati = new Administrador(1,"Matías","Bernal");
        Cliente Gamaliel = new Cliente(0,12345678,"Gamaliel", "Quiroz", "2346132");
        Operario operario = new Operario(0, "", "");
        Obrero obrero = new Obrero(0,"","", true, 0);
        Maestro_obra maestro = new Maestro_obra("", 0, "", "", 0);
        Plano plano = new Plano(0, "", 0, 0);
        Recursoshumanos rrhh = new Recursoshumanos(1,"Juan","Lopez",0);
        proyecto_obra obra = new proyecto_obra(0, true, "", "");
        Materiales material = new Materiales("", 0, 0, 0, true);
        Maquinaria maquinaria = new Maquinaria("", true, "", 0);
        LinkedList<proyecto_obra> listaProyectos = new LinkedList<>();
        LinkedList<proyecto_obra> ObrerosEnObra = new LinkedList<>();
        LinkedList<Obrero> listaObreros = new LinkedList<>();
        LinkedList<Operario> listaOperarios = new LinkedList<>();
        Verifica verifica = new Verifica();

        Menu(Mati,  operario,  rrhh,  maestro,  material, maquinaria, obrero, plano, obra, listaProyectos, ObrerosEnObra, listaObreros, listaOperarios, verifica);


    }

    private static void Menu() {
    }

    public static void Menu(Administrador admin, Operario operario, Recursoshumanos rrhh, Maestro_obra maestro, Materiales material, Maquinaria maquinaria, Obrero obrero, Plano plano, proyecto_obra obra, LinkedList<proyecto_obra> listaProyectos, LinkedList<proyecto_obra> ObrerosenObra, LinkedList<Obrero> listaObreros, LinkedList<Operario> listaOperarios, Verifica verifica) {
        JOptionPane.showMessageDialog(null, "  Bienvenido a LUBEE La empresa numero 1 en construcciones  ");
        int a = 0;
        do {

            int op = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la opcion correcta " +
                    "\n Numero 1: si es Administrador " +
                    "\n Numero 2: si es RRHH " +
                    "\n Numero 3: Si es Maestro Mayor de Obra" +
                    "\n Numero 4: si es Operario "));
            switch (op) {
                case 1:
                    int idAdmin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su ID de admin: "));
                    Administrador administradorEncontrado = null;

                    for (Administrador administrador : Administrador.getListaAdministradores()) {
                        if (idAdmin == administrador.getIdUsuario()) {
                            administradorEncontrado = administrador;
                            break;
                        }
                    }

                    if (administradorEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "Bienvenido Datos.Administrador " + administradorEncontrado.getNombre() + " " + administradorEncontrado.getApellido());
                        int opAdmnv = 0;
                        do {
                            int opAdm = Integer.parseInt(JOptionPane.showInputDialog("Ingrese lo que quiere usar " +
                                    "\n 1- Llamar al cliente " +
                                    "\n 2- Calcular el presupuesto" +
                                    "\n 3- Crear un proyecto " ));
                            switch(opAdm) {
                                case 1:
                                    int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a llamar:"));
                                    administradorEncontrado.llamarCliente(idCliente);
                                    break;
                                case 2:
                                    administradorEncontrado.calcularPresupuesto();
                                    break;
                                case 3:
                                    idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente para asignarle el proyecto"));
                                    administradorEncontrado.crearProyecto(idCliente);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "La opción ingresada es incorrecta. Por favor ingrese una opción valida");
                            }
                            opAdmnv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea salir del perfil de Datos.Administrador. Cualquier número para continuar"));
                        } while (opAdmnv != 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un administrador con el ID ingresado.");
                    }
                    break;

                case 2:
                    int opRrhh = 0;

                    String[] opciones = new String[]{"Modificaciones en el area de RRHH", "Modificaciones en el area de Administracion", "Modificaciones en el area de Operario", "Salir"};
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
                        }

                            case "Modificaciones en el area de RRHH":
                                String[] op = new String[]{"Agregar trabajador", "Mostrar trabajador", "Eliminar trabajador", "Editar trabajador", "Salir"};
                                String op;

                                do {
                                    op = (String) JOptionPane.showInputDialog(null,
                                            "Bienvenido al Menu de RRHH, que desea realizar?",
                                            "",
                                            null,
                                            op,
                                            op[0]);

                                switch (op) {

                                    case "Agregar Trabajador":
                                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del trabajador a añadir");
                                        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del trabajador a añadir");

                                        if (verifica.VerificarAgregarT(nombre,apellido)){
                                            JOptionPane.showMessageDialog(null, "Trabajador guardado correctamente");
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error");
                                        }
                                        break;

                                    case "Mostrar Trabajador":
                                        if (verifica.verificaListaT().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "Lista vacia, todavia no hay usuarios");
                                        }else{
                                            JOptionPane.showMessageDialog(null, verifica.verificaListaT());
                                        }
                                        break;

                                    case "Eliminar Trabajador":
                                        String[] opcionesEliminar = new String[verifica.verificaListaT().size()];
                                        for (int i = 0; i <verifica.verificaListaT().size();i++){
                                            opcionesEliminar[i] = Integer.toString(verifica.verificaListaT().get(i).getIdTrabajador());
                                        }

                                        op = (String)JOptionPane.showInputDialog(null,
                                                "Opciones",
                                                "",
                                                JOptionPane.DEFAULT_OPTION,
                                                null,
                                                opcionesEliminar,
                                                opcionesEliminar[0]);
                                        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Trabajador que desea eliminar"));
                                        if (verifica.EliminarT(Integer.parseInt(op))){
                                            JOptionPane.showMessageDialog(null,"Se elimino exitosamente");
                                        }else{
                                            JOptionPane.showMessageDialog(null,"No se pudo eliminar");
                                        }
                                        break;

                                    case "Editar Trabajador":
                                        if (verifica.verificaListaT().isEmpty()){
                                            JOptionPane.showMessageDialog(null, "No hay elementos para editar");
                                        }else{
                                            String[] opcioness = new String[verifica.verificaListaT().size()];
                                            for (int i = 0; i <verifica.verificaListaT().size(); i++){
                                                opcioness[i] = Integer.toString(verifica.verificaListaT().get(i).getIdTrabajador());
                                            }

                                            id = Integer.parseInt((String)JOptionPane.showInputDialog(null,
                                                    "Ingrese el ID",
                                                    "",
                                                    JOptionPane.DEFAULT_OPTION,
                                                    null,
                                                    opcioness,
                                                    opcioness[0]));
                                            System.out.println(id);
                                            for (Recursoshumanos recursoshumanos: verifica.verificaListaT()) {
                                                if (recursoshumanos.getIdTrabajador()==id){
                                                    JOptionPane.showMessageDialog(null,recursoshumanos);
                                                }
                                            }
                                            if (verifica.EditarT(id)){
                                                JOptionPane.showMessageDialog(null, "Se edito exitosamente el Trabajador con ID" + id);
                                                for (Recursoshumanos recursoshumanos: verifica.verificaListaT()){
                                                    if (recursoshumanos.getIdTrabajador() == id) {
                                                        JOptionPane.showMessageDialog(null, recursoshumanos);
                                                    }

                                                }

                                            }else{
                                                JOptionPane.showMessageDialog(null, "No se pudo editar ID");
                                            }
                                        }
                                        break;

                                    case "Salir":
                                        break;
                                    default:
                                        break;

                        }
                        opRrhh= Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea salir del perfil de Recursos Humanos. Cualquier número para continuar"));
                    } while (opRrhh != 1);
                                break;

                case 3:
                    // if (Ingreso Maestro mayor de obra is true) {

                    int opcionmaestro=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al Menu de Maestro Mayor de Obra " +
                            "\n Asignar Obreros a una obra" +
                            "\n Seccion de planos" +
                            "\n Solicitar Datos.Materiales" +
                            "\n Solicitar Maquinarias"));
                    switch (opcionmaestro) {

                        case 1:
                            //obrero.AsignarObrero(obra, listaProyectos, ObrerosenObra);

                            break;
                        case 2:
                            int opcionplanos=Integer.parseInt(JOptionPane.showInputDialog("Seccion Planos " +
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


                    break;

                case 4:
                    listaOperarios=operario.Mostrar();
                    if (operario.Ingreso()==true) {
                        JOptionPane.showMessageDialog(null, "Ingreso concedido");
                        int opcionoperario=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al Menu de Datos.Operario " +
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

                                int idobrero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del  nuevo obrero"));
                                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nuevo obrero a añadir");
                                String apellido = JOptionPane.showInputDialog("Ingrese el apellido del nuevo obrero a añadir");
                                Boolean disponible = true;
                                int idobra=0;
                                if (verifica.verificarAgregar(idobrero, nombre , apellido, disponible, idobra)) {
                                    JOptionPane.showMessageDialog(null, "Usuario guardado correctamente");
                                }else {
                                    JOptionPane.showMessageDialog(null, "Error");
                                }
                                break;
                            case 6:
                                JOptionPane.showMessageDialog(null, obrero.Mostrar());


                                break;

                            case 7:

                                listaObreros=obrero.Mostrar();
                                if (listaObreros.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "No se pueden eliminar los usuarios porque no existen");

                                }else {

                                    idobrero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del obrero que quiere eliminar"));

                                    for (int i=0; i < listaObreros.size();i++) {
                                        if (idobrero==listaObreros.get(i).getiIdobrero()){
                                            if (verifica.verificarEliminar(idobrero)){
                                                JOptionPane.showMessageDialog(null, "Lo eliminó existosamente");
                                            }
                                        }
                                    }
                                }
                                break;
                            case 8:
                                //modificar obrero.
                                idobrero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del obrero que quiere modificar"));
                                listaObreros=obrero.Mostrar();
                                for (int i=0; i < listaObreros.size();i++) {
                                    if (idobrero==listaObreros.get(i).getiIdobrero()){ //ya tengo el obrero identificado
                                        JOptionPane.showMessageDialog(null,"El obrero a modificar es: " + listaObreros.get(i));
                                        int opc= Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de lo que desea modificar. 1-id 2-nombre 3-apellido 4-disponible 5-id obra asignada"));
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