package ejjs;

import javax.swing.JOptionPane;

public class ej6c {

	public static void main(String[] args) {
		//calcular el mayor de 3 numeros.

		
		@SuppressWarnings("unused")
		int a = Integer.parseInt(JOptionPane.showInputDialog("dame un 1 numero"));
		@SuppressWarnings("unused")
		int b = Integer.parseInt(JOptionPane.showInputDialog("dame un 2 numero"));
		@SuppressWarnings("unused")
		int c = Integer.parseInt(JOptionPane.showInputDialog("dame un 3 numero"));
		
		
		
		if (a > b && a > c ){
			
			JOptionPane.showMessageDialog(null, "el mayor a que es " + a);
		}
		
	if (b > a && b > c ){
			
			JOptionPane.showMessageDialog(null, "el mayor b que es" + b);
		}
		
		
		
	if (c > b && c > a ){
		
		JOptionPane.showMessageDialog(null, "el mayor c que es " + c);
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
