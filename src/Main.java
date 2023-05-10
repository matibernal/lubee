import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        Administrador admin = new Administrador(1,"Franco","Diaz");

        Administrador Mati = new Administrador(1,"Matías","Bernal");
        Administrador Kei = new Administrador(2,"Keila","Degregorio");
        Administrador Maia = new Administrador(3,"Maia","Cohen");
        Administrador Toto = new Administrador(4,"Tomas","Tejada");
        Administrador Mili = new Administrador(5,"Milagros","Lobo");
        Cliente Gamaliel = new Cliente(1,12345678,"Gamaliel", "Quiroz", "2346132");
        Operario operario = new Operario (0);
        Obrero obrero = new Obrero("","", true);
        Maestro_obra maestro = new Maestro_obra("", 0, "", "", 0);
        Plano plano = new Plano (0, "");
        Recursoshumanos rrhh = new Recursoshumanos(1,"Juan","Lopez","Obrero");
        Recursoshumanos Pablo = new Recursoshumanos(2,"Pablo","Rodriguez","Obrero");
        Recursoshumanos Lucio = new Recursoshumanos(3,"Lucio","Perez","Maestro Mayor");
        Recursoshumanos Marcos = new Recursoshumanos(4,"Marcos","Suarez", "Operario");
        proyecto_obra obra = new proyecto_obra(0, true, "", "");
        Materiales material = new Materiales("", 0, 0, 0, true);
        Maquinaria maquinaria = new Maquinaria("", true, "", 0);
        LinkedList<proyecto_obra> listaProyectos = new LinkedList<>();
        LinkedList<proyecto_obra> ObrerosEnObra = new LinkedList<>();


        Menu(admin,  operario,  rrhh,  maestro,  material, maquinaria, obrero, plano, obra, listaProyectos, ObrerosEnObra);
    }

    private static void Menu() {
    }

    public static void Menu(Administrador admin, Operario operario, Recursoshumanos rrhh, Maestro_obra maestro, Materiales material, Maquinaria maquinaria, Obrero obrero, Plano plano, proyecto_obra obra, LinkedList<proyecto_obra> listaProyectos, LinkedList<proyecto_obra> ObrerosenObra) {
        JOptionPane.showMessageDialog(null, "  Bienvenido a LUBEE  ");
        JOptionPane.showMessageDialog(null, "  La empresa numero 1 en construcciones  ");
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
                        JOptionPane.showMessageDialog(null, "Bienvenido Administrador " + administradorEncontrado.getNombre() + " " + administradorEncontrado.getApellido());
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
                            opAdmnv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea salir del perfil de Administrador. Cualquier número para continuar"));
                        } while (opAdmnv != 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró un administrador con el ID ingresado.");
                    }
                    break;

                case 2:
                    int opRrhhnv = 0;
                    do {
                        int opRrhh = Integer.parseInt(JOptionPane.showInputDialog("Ingrese lo que quiere realizar" +
                                "\n 1-Agregar Trabajador" +
                                "\n 2-Quitar Trabajador"));

                    } while (opRrhhnv !=1);
                    break;

                case 3:
                    // if (Ingreso Maestro mayor de obra is true) {

                    int opcionmaestro=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al Menu de Maestro Mayor de Obra " +
                            "\n Asignar Obreros a una obra" +
                            "\n Seccion de planos" +
                            "\n Solicitar Materiales" +
                            "\n Solicitar Maquinarias"));
                    switch (opcionmaestro) {

                        case 1:
                            obrero.AsignarObrero(obra, listaProyectos, ObrerosenObra);

                            break;
                        case 2:
                            int opcionplanos=Integer.parseInt(JOptionPane.showInputDialog("Seccion Planos " +
                                    "\n Ver Plano" +
                                    "\n Relizar Plano" +
                                    "\n Modificar Plano" +
                                    "\n Eliminar plano"));
                                switch (opcionplanos) {
                                case 1:
                                    plano.realizarPlano();

                                    break;
                                case 2:
                                // ver plano

                                    break;
                                case 3:
                                // modificar plano

                                    break;
                                case 4:
                                    plano.eliminarPlano();

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
                    if (operario.IngresoOperario()) {
                        int opcionoperario=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido al Menu de Operario " +
                                "\n Realizar Inventario" +
                                "\n Agregar Maquinarias" +
                                "\n Agregar Materiales" +
                                "\n Ver historial de inventarios"));
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


                        }



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