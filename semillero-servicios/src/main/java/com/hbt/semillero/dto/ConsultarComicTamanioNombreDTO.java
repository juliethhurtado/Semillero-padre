package com.hbt.semillero.dto;

import java.math.BigDecimal;

public class ConsultarComicTamanioNombreDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short lengthComic ;
	
	public ConsultarComicTamanioNombreDTO() {
		//Constructor vacio
	}
	
	public ConsultarComicTamanioNombreDTO(Short lengthComic) {
		this.lengthComic = lengthComic;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo lengthComic
	 * @return El lengthComic asociado a la clase
	 */
	public Short getLengthComic() {
		return lengthComic;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo lengthComic
	 * @param lengthComic El nuevo lengthComic a modificar.
	 */
	public void setLengthComic(Short lengthComic) {
		this.lengthComic = lengthComic;
	}
	
	

}
