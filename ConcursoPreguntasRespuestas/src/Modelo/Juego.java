package Modelo;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Juego {
	
	Ronda ronda;
	OpcionCorrecta opcionCorrecta;
	int contador;
	
	public Juego() {
		super();
	}

	public void inicio() {
		String opcion;
		int opcionSeleccionada;
		
		try {
			opcion = JOptionPane.showInputDialog(null, "Bienvenid@" +
	                "\n 1. Iniciar juego" +
	                "\n 2. Instrucciones" +
	                "\n 3. Salir" +         
	                "\n Elige una opción ?",
	                "Juego de preguntas", JOptionPane.INFORMATION_MESSAGE);
			
			opcionSeleccionada = Integer.parseInt(opcion);
			
			switch(opcionSeleccionada) {
			case 1:
				iniciarJuego();
				break;
			case 2:
				abrirInstrucciones();
				break;
			case 3:
				salir();
				break;
			default:
				ningunaOpcion();
				break;
			}
		}catch(Exception e){
			System.out.println("El error es " + e);
			JOptionPane.showMessageDialog(null, "Debe elegir una opción correcta", "JUEGO DE PREGUNTAS", JOptionPane.ERROR_MESSAGE);
			inicio();
		}		
	}
	
	public void iniciarJuego() {
		String nombre = "";
		try {
			nombre = JOptionPane.showInputDialog(null, " Ingrese su nombre",
	                "JUEGO DE PREGUNTAS", JOptionPane.INFORMATION_MESSAGE);
			if(nombre.equals("")) {
				JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para poder jugar", "JUEGO DE PREGUNTAS", 1);
				iniciarJuego();
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para poder jugar", "JUEGO DE PREGUNTAS", JOptionPane.QUESTION_MESSAGE);
			inicio();
		}
		ronda = new Ronda(nombre);
	}
	
	
	public void abrirInstrucciones() {
		try {

            File file = new File ("src\\banco_datos\\Instrucciones.txt");
            Runtime.getRuntime().exec("cmd /c start "+file);
            inicio();
		}catch (IOException ex) {

            System.out.println(ex);
		}
	}
	
	public void salir(){
        System.exit(0);
    }
	
	public void ningunaOpcion() {
		JOptionPane.showMessageDialog(null, " Elija una opciones correcta",
                "JUEGO DE PREGUNTAS", JOptionPane.ERROR_MESSAGE);
		inicio();
	} 
}

