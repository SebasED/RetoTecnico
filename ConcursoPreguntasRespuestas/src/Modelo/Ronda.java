package Modelo;

import javax.swing.JOptionPane;

public class Ronda {
	int numRonda = 1;
	String respuesta = "";
	String nomJugador;
	Jugador jugador;
	Premio premio;
	Pregunta pregunta;
	Opciones opciones;
	OpcionCorrecta opcionCorrecta;
	Juego juego = new Juego();
	
	public Ronda(String jugador) {
		super();
		this.nomJugador = jugador;
		
		vienbenidaJugador();
	}
	
	public void vienbenidaJugador() {
		jugador = new Jugador(this.nomJugador);
		try {
			JOptionPane.showMessageDialog(null, "Bienvenid@ " + jugador.getNombre() + " ¿List@ para inicar?", "JUEGO DE PREGUNTAS", 1);
		}catch(Exception e) {
			juego.inicio();
		}
		
		iniciarRonda();
	}
	
	public void iniciarRonda() {
		pregunta = new Pregunta();
		int respuestaElegida = 0;
		String laPregunta = pregunta.obtenerPregunta(numRonda);
		opciones = new Opciones(pregunta.getNumPregunta(), numRonda);
		opcionCorrecta = new OpcionCorrecta(numRonda,pregunta.getNumPregunta());
		boolean control = true;
		
		while(control) {
			control = false;
			try {
				respuesta = JOptionPane.showInputDialog(null,  laPregunta  +
		                "\n 1. " + opciones.getOpciones()[0]+
		                "\n 2. " + opciones.getOpciones()[1]+
		                "\n 3. " + opciones.getOpciones()[2]+         
		                "\n 4. " + opciones.getOpciones()[3]+
		                "\n 5. " + "Elija esta opción si desea retirarse"+
		                "\n Debe escribir una sola respuesta (1, 2, 3, 4 o 5) ",
		                "JUEGO DE PREGUNTAS. Ronda: " + numRonda, JOptionPane.INFORMATION_MESSAGE);
				
				respuestaElegida = Integer.parseInt(respuesta);
				if(respuestaElegida < 1 || respuestaElegida > 5) {
					control = true;
					JOptionPane.showMessageDialog(null, "Debe elegir una respuesta entre 1 y 5", "JUEGO DE PREGUNTAS", 1);
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				control = true;	
				JOptionPane.showMessageDialog(null, "Debe elegir una respuesta entre 1 y 5", "JUEGO DE PREGUNTAS", 1);
				
			}catch(NumberFormatException e) {
				control = true;
				JOptionPane.showMessageDialog(null, "Debe elegir una respuesta entre 1 y 5", "JUEGO DE PREGUNTAS", 1);
			}
		}
				
		if(respuestaElegida == 5) {
			retirarse();
		}
		if(opciones.getOpciones()[respuestaElegida - 1].equals(opcionCorrecta.getRespuesta())) {
			avanzarRonda();
		}else {
			JOptionPane.showMessageDialog(null, "Respuesta incorrecta, acabas de perder ", "JUEGO DE PREGUNTAS", 1);
			jugador.setPremio(0);
			jugador.setRonda(numRonda);
			jugador.setResultado("Perdio");
			jugador.guardarJugador();
			juego.salir();
		}
		
	}
	
	private void avanzarRonda() {
		this.numRonda++;
		
		if(numRonda > 5) {
			jugador.setResultado("Ganador");
			premio = new Premio(numRonda);
			jugador.aumentarDinero(premio.getDinero());
			jugador.guardarJugador();
			JOptionPane.showMessageDialog(null, "Felicidades "+ jugador.getNombre() + ", acabas de ganar el juego y un monto de " + jugador.getPremio() + " pesos", "JUEGO DE PREGUNTAS", 1);
			juego.salir();
		} else {
			premio = new Premio(numRonda);
			jugador.aumentarDinero(premio.getDinero());
			jugador.setRonda(numRonda);			
			JOptionPane.showMessageDialog(null, "Felicidades "+ jugador.getNombre() + ", acabas de ganar " + premio.getDinero() + " pesos", "JUEGO DE PREGUNTAS", 1);
			
			iniciarRonda();
		} 
	
	}
	
	private void retirarse() {
		jugador.setResultado("Jugador retirad@");
		jugador.guardarJugador();
		JOptionPane.showMessageDialog(null, "Felicitaciones, te llevas un total de: " + jugador.getPremio() + " pesos", "JUEGO DE PREGUNTAS", 1);
		juego.salir();
	}
}
