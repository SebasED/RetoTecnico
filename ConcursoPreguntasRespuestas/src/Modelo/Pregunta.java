package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pregunta {
	ArrayList<String> preguntas = new ArrayList<>();
	private int numPregunta;
		
	public Pregunta() {
		super();
		
	}
	
	public int getNumPregunta() {
		return numPregunta;
	}

	public void setNumPregunta(int numPregunta) {
		this.numPregunta = numPregunta;
	}

	private String identificarArchivo(int categoria) {
		String archivo="";
		
		switch(categoria) {
		case 1:
			archivo = "src\\banco_datos\\categoria_1.txt";
			break;
		case 2:
			archivo = "src\\banco_datos\\categoria_2.txt";
			break;
		case 3:
			archivo = "src\\banco_datos\\categoria_3.txt";
			break;
		case 4:
			archivo = "src\\banco_datos\\categoria_4.txt";
			break;
		default:
			archivo = "src\\banco_datos\\categoria_5.txt";
			break;
		}
		
		return archivo;
	}
	
	public String obtenerPregunta(int ronda) {
		String pregunta = "";
		String archivo = identificarArchivo(ronda);
		int num = (int) (Math.random()*4 + 1);
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(archivo));
			String texto = br.readLine();
			while(texto != null) {
				preguntas.add(texto);
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
		pregunta = preguntas.get(num);
		this.numPregunta = num;	
		
		return pregunta;
	}
}
