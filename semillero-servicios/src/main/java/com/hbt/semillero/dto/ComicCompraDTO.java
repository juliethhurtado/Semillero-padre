package com.hbt.semillero.dto;

public class ComicCompraDTO {
	private Integer cantidadComic;
	private Long idComic;
	
	
	/**
	 * Constructor de la clase.
	 */
	public ComicCompraDTO() {
		super();
	}
	/**
	 * Constructor de la clase.
	 * @param cantidadComic
	 * @param idComic
	 */
	public ComicCompraDTO(Integer cantidadComic, Long idComic) {
		super();
		this.cantidadComic = cantidadComic;
		this.idComic = idComic;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo cantidadComic
	 * @return El cantidadComic asociado a la clase
	 */
	public Integer getCantidadComic() {
		return cantidadComic;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo cantidadComic
	 * @param cantidadComic El nuevo cantidadComic a modificar.
	 */
	public void setCantidadComic(Integer cantidadComic) {
		this.cantidadComic = cantidadComic;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo idComic
	 * @return El idComic asociado a la clase
	 */
	public Long getIdComic() {
		return idComic;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo idComic
	 * @param idComic El nuevo idComic a modificar.
	 */
	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}
	
	
}
