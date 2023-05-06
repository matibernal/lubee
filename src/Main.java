import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		
	Menu();

	}


public static void Menu() {
	JOptionPane.showMessageDialog(null, "  Bienvenido a LUBEE  ");
	JOptionPane.showMessageDialog(null, "  La empresa numero 1 en construcciones  ");
	int a=0;
	do {
		
	int op = Integer.parseInt(JOptionPane.showInputDialog(" Ingrese la opcion correcta /n Numero 1: si es Cliente /n Numero 2: si es Administrador /n Numero 3: Si es Maestro Mayor de Obra"));
	switch (op) {
	case 1:
		// if (Ingreso cliente is true) {
			
		// }
		
		break;
	case 2:
		// if (Ingreso administrador is true) {
		
				// }

			
			break;
	case 3:
		// if (Ingreso Maestro mayor de obra is true) {
		
		// }
		
		
		break;

	default:
		JOptionPane.showMessageDialog(null, "La opcion ingresada es incorrecta. Por favor ingrese una opcion valida");
		break;
	}
	
	
	a= Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea salir. Cualquier numero para continuar"));
	} while (a == 0 );
	
	JOptionPane.showMessageDialog(null, "Usted ha salido del sistema. Gracias por visitarnos. /n EMPRESA LUBEE");
	
	
}

}


