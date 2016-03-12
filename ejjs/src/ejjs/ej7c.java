package ejjs;

import javax.swing.JOptionPane;

public class ej7c {
	public static void main(String[] args) {
		
		
		
		@SuppressWarnings("unused")
		int h = Integer.parseInt(JOptionPane.showInputDialog("dame una hora, (entre 0 y 24)"));
		@SuppressWarnings("unused")
		int m = Integer.parseInt(JOptionPane.showInputDialog("dame unos minutos, (entre 0 y 60)"));
		@SuppressWarnings("unused")
		int s = Integer.parseInt(JOptionPane.showInputDialog("dame unos segundos, (entre 0 y 60)"));
		
		
		
		if (h > 24 || h < 0 ){
			
			JOptionPane.showMessageDialog(null, "las horas estan mal,  ¡corrigelas!");
		}
		
	if (m > 60 || m < 0 ){
			
			JOptionPane.showMessageDialog(null, "los minutos estan mal,  ¡corrigelos!");
		}
		
		
		
	if (s > 60 || s < 0 ){
		
		JOptionPane.showMessageDialog(null, "los segundos estan mal,  ¡corrigelos!");
	}
	
		
	if (s < 60 && s > 0 && m < 60 && m > 0 && h < 24 && h > 0 ) {
		JOptionPane.showMessageDialog(null, "Gracias por su tiempo, le hemos hecho un test y lo ha superado, eso significa que sabe poner las horas.");
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
