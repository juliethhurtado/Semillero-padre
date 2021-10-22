package com.hbt.semillero.enums;

/**
 * 
 * <b>Descripción:<b> Clase que determina la enumeración para representar los tipos de tematicas aceptados por un comic
 * <b>Caso de Uso:<b> SEMILLERO 2021
 * @author Julieta Hurtado
 * @version
 */
public enum TematicaEnum {
	
	AVENTURAS("enum.tematica.aventuras"),
	BELICO("enum.tematica.belico"),
	DEPORTIVO("enum.tematica.deportivo"),
	FANTASTICO("enum.tematica.fantastico"),
	CIENCIA_FICCION("enum.tematica.cienciaFiccion"),
	HISTORICO("enum.tematica.aventuras.historico"),
	HORROR("enum.tematica.horror"),
	HUMORISTICO("enum.tematica.aventuras.humoristico"),
	;
	
	/**
	 * Atributo que contiene la clave del mensaje para la internacionalizacion
	 */
	private String codigoMensaje;

	/**
	 * Constructor que recibe como parametro el codigo del mensaje
	 * 
	 * @param codigoMensaje, Clave del mensaje para para internacionalizacion
	 */
	TematicaEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo que retorna el valor del atributo
	 * 
	 * @return cadena con el codigo del mensaje
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo que establece el valor del atributo
	 *
	 * @param codigoMensaje
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
	
}
