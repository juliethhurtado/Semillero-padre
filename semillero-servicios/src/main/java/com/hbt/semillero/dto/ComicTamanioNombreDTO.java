package com.hbt.semillero.dto;

import java.util.List;

public class ComicTamanioNombreDTO extends ResultadoDTO {
	private List<String> comicsNoSuperanTamanio;
	private List<String> comicsSuperanTamanio;
	/**
	 * Constructor de la clase.
	 */
	public ComicTamanioNombreDTO() {
		super();
	}
	/**
	 * Constructor de la clase.
	 * @param comicsNoSuperanTamanio
	 * @param comicsSuperanTamanio
	 */
	public ComicTamanioNombreDTO(List <String> comicsNoSuperanTamanio, List <String> comicsSuperanTamanio) {
		super();
		this.comicsNoSuperanTamanio = comicsNoSuperanTamanio;
		this.comicsSuperanTamanio = comicsSuperanTamanio;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo comicsNoSuperanTamanio
	 * @return El comicsNoSuperanTamanio asociado a la clase
	 */
	public List <String> getComicsNoSuperanTamanio() {
		return comicsNoSuperanTamanio;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo comicsNoSuperanTamanio
	 * @param comicsNoSuperanTamanio El nuevo comicsNoSuperanTamanio a modificar.
	 */
	public void setComicsNoSuperanTamanio(List <String> comicsNoSuperanTamanio) {
		this.comicsNoSuperanTamanio = comicsNoSuperanTamanio;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo comicsSuperanTamanio
	 * @return El comicsSuperanTamanio asociado a la clase
	 */
	public List <String> getComicsSuperanTamanio() {
		return comicsSuperanTamanio;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo comicsSuperanTamanio
	 * @param comicsSuperanTamanio El nuevo comicsSuperanTamanio a modificar.
	 */
	public void setComicsSuperanTamanio(List <String> comicsSuperanTamanio) {
		this.comicsSuperanTamanio = comicsSuperanTamanio;
	}
	
	
}
