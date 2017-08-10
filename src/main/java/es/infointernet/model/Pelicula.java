package es.infointernet.model;

import java.util.List;

public class Pelicula {
	
	private String titulo;
	
	private List<Actor> actoresList;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Actor> getActoresList() {
		return actoresList;
	}

	public void setActoresList(List<Actor> actoresList) {
		this.actoresList = actoresList;
	}

}
