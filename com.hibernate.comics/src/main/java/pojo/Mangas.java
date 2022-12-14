package com.hibernate.comics.pojo;
// Generated 17 nov 2022 20:49:01 by Hibernate Tools 5.5.7.Final

import java.util.Date;

/**
 * Mangas generated by hbm2java
 */
public class Mangas implements java.io.Serializable {

	private Long id;
	private String titulo;
	private String autor;
	private String editorial;
	private Date createdAt;
	private Date updatedAt;

	public Mangas() {
	}

	public Mangas(String titulo, String autor, String editorial) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
	}

	public Mangas(String titulo, String autor, String editorial, Date createdAt, Date updatedAt) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
