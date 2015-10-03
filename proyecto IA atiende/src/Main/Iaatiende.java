package Main;

import javax.swing.JFrame;

public class Iaatiende {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          atiende();
		hola ();
		//creamos una ventana
		Ventana v = new Ventana ();
		v.setVisible(true);
	    v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		
		
		
	}
	public static void atiende () {
		System.out.println ("Ia esta atendiendo y lo sabes");
	}
	
	public static void hola () {
		System.out.println ("ya no atiende");
	}
}
