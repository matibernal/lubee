import javax.swing.JOptionPane;

import java.util.LinkedList;

public class Operario {
    int id;
    Materiales materiales;
    Maquinaria maquinaria;
    private LinkedList<Operario> listaInventario;


    public Operario(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = 1;
    }

    @Override
    public String toString() {
        return "Operario [id=" + id + "]";
    }


    public boolean IngresoOperario() {
        //id = 1 2022 contra = 1010
        String nombre;
        int id;
        int exitoso=0; // ingreso exitoso
        int ide;
        //String contrae;

        nombre= JOptionPane.showInputDialog("Ingrese su nombre y apellido");


        Operario operario = new Operario (1);

        do {

            ide=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su id"));


            if (ide== operario.getId() ){

                System.out.println("Usuario: " + nombre + " Ingreso correctamente ");
                exitoso = 0;
                return true;

            }else {
                System.out.println("Id Incorrecto, ingreseselo otra vez ");
                exitoso = 1;
                return false;
            }

        } while ( exitoso == 1);

    }


    public void RealizarInvenario() {
        // hacer en el main porque hay q combinar materiales con maquinaria

        int a;
        String fechainventario;

        a=Integer.parseInt(JOptionPane.showInputDialog("Usted va a realizar el inventario. Se le mostraran los materiales y las maquinarias disponibles. Numero 1: si acepta. Numero 2: si desea salir"));
        if (a==1) {
           JOptionPane.showMessageDialog(null, "Los materiales disponibles en el inventario son: " );
           JOptionPane.showMessageDialog(null, "Las maquinarias disponibles en el inventario son: ");
        } else {

        }


        // los materialesson estos y mostrar cantidad con for y contador
        //las maquinarias son estas mostrar cantidad con for y contador
        //agregar inventario a linked list de inventario



    }

    public void HistorialInventarios() {
        JOptionPane.showMessageDialog(null, listaInventario);
    }




}
