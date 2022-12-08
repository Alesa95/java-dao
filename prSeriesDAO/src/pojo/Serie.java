package pojo;

import java.util.ArrayList;

public class Serie {

	private int id;
	private String titulo;
	private int edad;
	private String plataforma;
	private ArrayList<Temporada> temporadas;
	
	/**
	 * Crea una nueva serie. Se recomienda emplear este metodo para instanciar
	 * una serie ya existente obtenida de la base de datos. No se recomienda 
	 * emplear este metodo al crear una nueva serie localmente para luego 
	 * insertarla en la base de datos
	 * 
	 * @param id
	 * @param titulo
	 * @param edad
	 * @param plataforma
	 */
	public Serie(int id, String titulo, int edad, String plataforma) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.edad = edad;
		this.plataforma = plataforma;
	}
	
	/**
	 * Crea una nueva serie. Se recomienda emplear este metodo al crear una 
	 * nueva serie localmente para luego insertarla en la base de datos
	 * 
	 * @param titulo
	 * @param edad
	 * @param plataforma
	 */
	public Serie(String titulo, int edad, String plataforma) {
		super();
		this.edad = edad;
		this.titulo = titulo;
		this.plataforma = plataforma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public ArrayList<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(ArrayList<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	@Override
	public String toString() {
		return "Serie [id=" + id + ", titulo=" + titulo + ", plataforma=" + plataforma + "]";
	}
}
