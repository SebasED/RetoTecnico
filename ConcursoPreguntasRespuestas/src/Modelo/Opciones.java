package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Opciones {
	private ArrayList<String> opcionesCategoria = new ArrayList<>();
	private String[] opciones;
	private int numPregunta;
	private int categoria;
	
	
	public Opciones(int numPregunta, int categoria) {
		super();
		this.numPregunta = numPregunta;
		this.categoria = categoria;
		
		obtenerOpcionesCategoria(categoria);
		obtenerOpciones(numPregunta);
	}
	
	public ArrayList<String> getOpcionesCategoria() {
		return opcionesCategoria;
	}

	public String[] getOpciones() {
		return opciones;
	}

	public int getNumPregunta() {
		return numPregunta;
	}

	public void setNumPregunta(int numPregunta) {
		this.numPregunta = numPregunta;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	private String identificarArchivo(int categoria) {
		String archivo="";
		
		switch(categoria) {
		case 1:
			archivo = "src\\banco_datos\\respuestas_cat_1.txt";
			break;
		case 2:
			archivo = "src\\banco_datos\\respuestas_cat_2.txt";
			break;
		case 3:
			archivo = "src\\banco_datos\\respuestas_cat_3.txt";
			break;
		case 4:
			archivo = "src\\banco_datos\\respuestas_cat_4.txt";
			break;
		default:
			archivo = "src\\banco_datos\\respuestas_cat_5.txt";
			break;
		}
		
		return archivo;
	}
	
	private void obtenerOpcionesCategoria(int a) {
		String archivo = identificarArchivo(a);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(archivo));
			String texto = br.readLine();
			while(texto != null) {
				this.opcionesCategoria.add(texto);
				texto = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
		}finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} 
		
	}
	
	private void obtenerOpciones(int numPreg){
		String listaOpciones = this.opcionesCategoria.get(numPreg);
		this.opciones = listaOpciones.split(",");	
	}
}
