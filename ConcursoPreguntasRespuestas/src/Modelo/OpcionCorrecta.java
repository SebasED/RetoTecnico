package Modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Esta clase contiene la opción correcta de una pregutna especifica 
public class OpcionCorrecta {
	private int categoria;
	private String respuesta;
	private int numRespuesta;
	ArrayList<String> respuestas = new ArrayList<>();
		
	public OpcionCorrecta(int categoria, int numRespuesta) {
		super();
		this.categoria = categoria;
		this.numRespuesta = numRespuesta;
		
		respuestasCorrecta(categoria);
		obtenerRespuesta(numRespuesta);
	}

	public String getRespuesta() {
		return respuesta;
	}
		
	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getNumRespuesta() {
		return numRespuesta;
	}

	public void setNumRespuesta(int numRespuesta) {
		this.numRespuesta = numRespuesta;
	}

	private void respuestasCorrecta(int categoria) {
		String archivo = identificarArchivo(categoria);
		BufferedReader br = null;
		
		try {
			//br = new BufferedReader(new FileReader(archivo));
			br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "utf-8"));
			String texto = br.readLine();
			while(texto != null) {
				respuestas.add(texto);
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
	
	private String identificarArchivo(int categoria) {
		String archivo="";
		
		switch(categoria) {
		case 1:
			archivo = "src\\banco_datos\\respuestas_correctas_cat_1.txt";
			break;
		case 2:
			archivo = "src\\banco_datos\\respuestas_correctas_cat_2.txt";
			break;
		case 3:
			archivo = "src\\banco_datos\\respuestas_correctas_cat_3.txt";
			break;
		case 4:
			archivo = "src\\banco_datos\\respuestas_correctas_cat_4.txt";
			break;
		default:
			archivo = "src\\banco_datos\\respuestas_correctas_cat_5.txt";
			break;
		}
		
		return archivo;
	}
	
	private void obtenerRespuesta(int numRespuesta) {
		this.respuesta = this.respuestas.get(numRespuesta-1);
	}
}