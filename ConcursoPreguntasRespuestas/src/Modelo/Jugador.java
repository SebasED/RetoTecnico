package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Jugador {

	private String nombre;
	private String resultado;
	private int premio = 0;
	private int ronda = 0;
	
	public Jugador(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}
	
	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public void aumentarDinero(int dinero) {
		this.premio = this.premio + dinero;
	}

	public void guardarJugador() {
		try {
			String ruta = "src\\banco_datos\\Jugadores.txt";
	        File file = new File(ruta);
	        // Si el archivo no existe es creado
	        if (!file.exists()) {
	        	file.createNewFile();
	        }
	        FileWriter fw = new FileWriter(file, true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(toString());
	        bw.close();
		} catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", premio=" + premio + ", ronda=" + ronda
				+ ", resultado=" + resultado + "]" + "\n";
	}
	
}

