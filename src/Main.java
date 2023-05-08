import javax.swing.JOptionPane;

public class Main {


    public static void main(String[] args) {



        Administrador Mati = new Administrador(1,"Matías","Bernal");
        Administrador Kei = new Administrador(2,"Keila","Degregorio");
        Administrador Maia = new Administrador(3,"Maia","Cohen");
        Administrador Toto = new Administrador(4,"Tomas","Tejada");
        Administrador Mili = new Administrador(5,"Milagros","Lobo");
        Cliente Gamaliel = new Cliente(1,12345678,"Gamaliel", "Quiroz", "2346132");
        Menu();

        Recursoshumanos Juan = new Recursoshumanos(1,"Juan","Lopez","Obrero");
        Recursoshumanos Pablo = new Recursoshumanos(2,"Pablo","Rodriguez","Obrero");
        Recursoshumanos Lucio = new Recursoshumanos(3,"Lucio","Perez","Maestro Mayor");
        Recursoshumanos Marcos = new Recursoshumanos(4,"Marcos","Suarez", "Operario");


    }

    public static void Menu() {
        JOptionPane.showMessageDialog(null, "  Bienvenido a LUBEE  ");
        JOptionPane.showMessageDialog(null, "  La empresa numero 1 en construcciones  ");
        int a = 0;
        do {

            int op = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la opcion correcta " +
                    "\n Numero 1: si es Administrador " +
                    "\n Numero 2: si es RRHH " +
                    "\n Numero 3: Si es Maestro Mayor de Obra"));
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
                                    "\n 3- Crear un proyecto " +
                                    "\n 4- Contactar proveedores"));
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