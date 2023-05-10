import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                    Maestro_obra Mario = new Maestro_obra("Mario", 25,"1234","maestro mayor de obra",20,""); //Milagros codigo
                    Maestro_obra Carlos = new Maestro_obra("Carlos", 26,"2222","maestro mayor de obra",20,"");
                    Maestro_obra Roberto = new Maestro_obra("Roberto", 27,"7777","maestro mayor de obra",20,"");
                    int i=0;
                    boolean ingreso = true;
                    boolean verifica = true;
                    int intentos=0;
                    do {
                        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");
                        String contraseña= JOptionPane.showInputDialog(null, "Ingrese su contraseña:");

                        if(Mario.Login(nombre,contraseña)) {
                            JOptionPane.showMessageDialog(null, "Clave correcta");
                            int opcionEntrada;
                            do {
                                opcionEntrada=Integer.parseInt(JOptionPane.showInputDialog("Has Entrado con Exito!!" + "\nBienvenido" +"_"+ Mario.getNombre()+ "\nQue deseas realizar:"+"\nOpciones:"
                                        +  "\n 1- Realizar un Plano "
                                        + "\n 2- Buscar Planos "
                                        + "\n 3- Llevar adelante un proyecto"
                                        + "\n 4- Realizar pedido de materiales"
                                        + "\n 5- Solicitar Obreros"
                                        + "\n 6- Solicitar Maquinarias"
                                        +"\n 0- Salir"));

                                switch (opcionEntrada) {
                                    case 1: // realizar plano
                                        Plano plano2 = new Plano();
                                        List<Plano> listaPlanos2 = plano2.realizarPlano();

                                        StringBuilder sb = new StringBuilder();
                                        for (Plano p : listaPlanos2) {
                                            sb.append(p.toString()).append("\n\n");
                                        }
                                        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Planos", JOptionPane.INFORMATION_MESSAGE);
                                        JOptionPane.showConfirmDialog(null, "¿Desea Realizar un plano?");

                                        String nombre1 = JOptionPane.showInputDialog(null, "Introduzca el nombre del plano:");
                                        String descripcion = JOptionPane.showInputDialog(null, "Introduzca la estacion para realizar la obra:");
                                        double ancho = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca el ancho del plano:"));
                                        double alto = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca el alto del plano:"));

                                        Plano nuevoPlano = new Plano(nombre1, descripcion, ancho, alto);

                                        try {
                                            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("plano.dat"));
                                            salida.writeObject(nuevoPlano);
                                            salida.close();
                                            JOptionPane.showMessageDialog(null, "Plano guardado con éxito en plano.dat");
                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, "Error al guardar el plano: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                        }

                                        break;
                                    case 2: // buscar plano

                                        List<Plano> listaPlanos = new ArrayList<>();
                                        listaPlanos.add(new Plano("Plano 1", "Primavera", "Palermo Soho", 1000.0, 2000.0));
                                        listaPlanos.add(new Plano("Plano 2", "Otoño", "Quilmes", 1500.0, 2500.0));
                                        listaPlanos.add(new Plano("Plano 3", "Verano", "Avenida Corrientes", 2000.0, 3000.0));
                                        listaPlanos.add(new Plano("Plano 4", "Primavera", "Rivadavia", 2000.0, 3000.0));
                                        listaPlanos.add(new Plano("Plano 5", "Verano", "Alcorta", 2000.0, 3000.0));

                                        String nombreBuscado = JOptionPane.showInputDialog("¿Que plano deseas buscar?");
                                        String descripcionBuscada = JOptionPane.showInputDialog("¿Cual es la estacion donde se realizara la obra de este plano?");
                                        Plano planoEncontrado = null;
                                        for (Plano plano : listaPlanos) {
                                            if (plano.getNombre().equals(nombreBuscado) && plano.getDescripcion().equals(descripcionBuscada)) {
                                                planoEncontrado = plano;
                                                break;
                                            }
                                        }

                                        if (planoEncontrado != null) {
                                            JOptionPane.showMessageDialog(null,"Plano encontrado:\nID: " + planoEncontrado.getId() + "\nNombre: " + planoEncontrado.getNombre() + "\nDescripcion: " + planoEncontrado.getDescripcion() + "\nUbicacion: " + planoEncontrado.getUbicacion() + "\nAncho: " + planoEncontrado.getAncho() + "\nAlto: " + planoEncontrado.getAlto());
                                        } else {
                                            JOptionPane.showMessageDialog(null,"Plano no encontrado");
                                        }

                                        String[] opciones = {"Editar plano", "Eliminar plano"};
                                        int opcionSeleccionada2 = JOptionPane.showOptionDialog(null, "¿Qué acción desea realizar?", "Opciones",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

                                        if (opcionSeleccionada2 == 0) {

                                            String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del plano:", planoEncontrado.getNombre());
                                            planoEncontrado.setNombre(nuevoNombre);
                                            JOptionPane.showMessageDialog(null, "Plano editado correctamente.");
                                        } else if (opcionSeleccionada2 == 1) {

                                            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el plano?",
                                                    "Confirmación", JOptionPane.YES_NO_OPTION);
                                            if (confirmacion == JOptionPane.YES_OPTION) {
                                                planoEncontrado.eliminarPlano();
                                                JOptionPane.showMessageDialog(null, "Plano eliminado correctamente.");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Opción no es válida.");
                                        }


                                        break;

                                    case 3: // llevar adelante un proyecto
                                        JOptionPane.showMessageDialog(null, "¿Has elegido la opcion llevar adelante un proyecto?" + "Los proyectos hasta la fecha son:");
                                        Plano plano3 = new Plano();
                                        List<Plano> listaPlanos3 = plano3.realizarPlano();

                                        StringBuilder sbsb = new StringBuilder();
                                        for (Plano p : listaPlanos3) {
                                            sbsb.append(p.toString()).append("\n\n");
                                        }
                                        JOptionPane.showMessageDialog(null, sbsb.toString(), "Lista de Planos", JOptionPane.INFORMATION_MESSAGE);
                                        int opcion_modi = JOptionPane.showOptionDialog(
                                                null,
                                                "Elija una opción",
                                                "Opciones",
                                                JOptionPane.DEFAULT_OPTION,
                                                JOptionPane.QUESTION_MESSAGE,
                                                null,
                                                new Object[]{"Posponer el proyecto", "Solicitar modificaciones"},
                                                "Posponer el proyecto"
                                        );
                                        if (opcion_modi == 0) {
                                            int respuesta = JOptionPane.showConfirmDialog(
                                                    null,
                                                    "¿Desea cambiar la fecha del proyecto?",
                                                    "Posponer el proyecto",
                                                    JOptionPane.YES_NO_OPTION
                                            );
                                            if (respuesta == JOptionPane.YES_OPTION) {
                                                JOptionPane.showMessageDialog(null, "Ha elegido cambiar la fecha del proyecto.");
                                                JOptionPane.showInputDialog("¿Que fecha deseas elegir?");
                                                JOptionPane.showMessageDialog(null, "Se agendo la fecha");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Ha pospuesto el proyecto sin cambiar la fecha.");
                                            }
                                        } else {
                                            int respuesta = JOptionPane.showConfirmDialog(
                                                    null,
                                                    "¿Desea  solicitadas  modificaciones en la obra?",
                                                    "Solicitar modificaciones",
                                                    JOptionPane.YES_NO_OPTION
                                            );
                                            if (respuesta == JOptionPane.YES_OPTION) {
                                                JOptionPane.showMessageDialog(null, "Ha solicitado modificaciones, en el trancurso del dia se le informara si se acepta la solicitud.");
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Ha rechazado el  pedido de modificaciones .");
                                            }
                                        }
                                        break;
                                    case 4: // realizar pedido de materiales
                                        JOptionPane.showMessageDialog(null, "A seleccionado la opcion realizar pedido de Materiales");
                                        Maestro_obra maestroObra = new Maestro_obra();
                                        maestroObra.solicitarMateriales();

                                        break;
                                    case 5: // solicitar obreros
                                        int cantidad_obreros = 5;
                                        JOptionPane.showMessageDialog(null, "A seleccionado la opcion realizar pedido de Obreros");
                                        JOptionPane.showInputDialog("ingrese la cantidad de obreros que nesesita");
                                        if (cantidad_obreros>=5) {
                                            JOptionPane.showMessageDialog(null, "los obreros han sido asignados" + "\n Juan\nCarlos\nEnrique\nRoman\nMartin");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No hay suficientes obreros disponibles");
                                        }

                                        break;
                                    case 6: // solicitar maquinarias
                                        JOptionPane.showMessageDialog(null, "A seleccionado la opcion realizar pedido de Herramientas y Maquinas");
                                        Maestro_obra MaestroObra = new Maestro_obra();
                                        MaestroObra.solicitarMateriales();

                                        break;
                                }
                            } while (!verifica && intentos<3);

                        } else {
                            JOptionPane.showMessageDialog(null, "vuelve a intentar mas tarde");
                        }


                    } while (!ingreso && i<=5);  // Salida del Maestro mayor de Obra.


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