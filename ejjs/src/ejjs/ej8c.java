package ejjs;

import javax.swing.JOptionPane;

public class ej8c {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int m = Integer.parseInt(JOptionPane.showInputDialog("dame un mes del año solo el numero del mes"));
		
		
		if (m == 1){
			JOptionPane.showInputDialog("es Enero y tiene 31 dias");
		}
		if (m == 2){
			JOptionPane.showInputDialog("es febrero y tiene 28 dias");
		}
		if (m == 3){
			JOptionPane.showInputDialog("es marzo y tiene 31 dias");
		}
		if (m == 4){
			JOptionPane.showInputDialog("es abril y tiene 30 dias");
		}
		if (m == 5){
			JOptionPane.showInputDialog("es mayo y tiene 31 dias");
		}
		if (m == 6){
			JOptionPane.showInputDialog("es junio y tiene 30 dias");
		}
		if (m == 7){
			JOptionPane.showInputDialog("es julio y tiene 31 dias");
		}
		if (m == 8){
			JOptionPane.showInputDialog("es agosto y tiene 31 dias");
		}
		if (m == 9){
			JOptionPane.showInputDialog("es septiembre y tiene 30 dias");
		}
		if (m == 10){
			JOptionPane.showInputDialog("es octubre y tiene 31 dias");
		}
		if (m == 11){
			JOptionPane.showInputDialog("es noviembre y tiene 30 dias");
		}
		if (m == 12){
			JOptionPane.showInputDialog("es diciembre y tiene 31 dias");
		}
		
		if (m > 12 || m < 1){
			JOptionPane.showInputDialog("no hay ningun mes que sea el numero " + m);
		}
		
		
		
		
		
		

	}

}
