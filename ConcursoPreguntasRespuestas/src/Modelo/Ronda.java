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
		int respuestaElegida;
		String laPregunta = pregunta.obtenerPregunta(numRonda);
		System.out.println("Hasta acá llego");
		opciones = new Opciones(pregunta.getNumPregunta(), numRonda);
		opcionCorrecta = new OpcionCorrecta(numRonda,pregunta.getNumPregunta());
		try {
			respuesta = JOptionPane.showInputDialog(null,  laPregunta  +
	                "\n 1. " + opciones.getOpciones()[0]+
	                "\n 2. " + opciones.getOpciones()[1]+
	                "\n 3. " + opciones.getOpciones()[2]+         
	                "\n 4. " + opciones.getOpciones()[3]+
	                "\n Debe escribir una sola respuesta (1, 2, 3 o 4) ",
	                "JUEGO DE PREGUNTAS", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Debe elegir una respuesta entre 1 y 4", "JUEGO DE PREGUNTAS", 1);
			iniciarRonda();
		}
		
		respuestaElegida = Integer.parseInt(respuesta);
		
		if(opciones.getOpciones()[respuestaElegida - 1] == opcionCorrecta.getRespuesta()) {
			avanzarRonda();
		}else {
			JOptionPane.showMessageDialog(null, "Respuesta incorrecta, acabas de perder ", "JUEGO DE PREGUNTAS", 1);
			jugador.setPremio(0);
			jugador.setRonda(numRonda);
			jugador.guardarJugador();
			juego.salir();
		}
		
	}
	
	private void avanzarRonda() {
		//Falta definir esta parte
		this.numRonda++;
		
	}
}
