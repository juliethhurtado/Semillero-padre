package com.hbt.semillero.enums;

/**
 * 
 * <b>Descripción:<b> Clase que determina la enumeración para representar si el estado del comic tiene existencia para la venta
 * <b>Caso de Uso:<b> SEMILLERO 2021
 * @author Julieta Hurtado
 * @version
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo"),
	;
	
	private String descripcion;
	
	EstadoEnum(String descripcion){
		this.descripcion = descripcion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo descripcion
	 * @return El descripcion asociado a la clase
	 */
	public String getDescripcion() {
		return descripcion;
	}
}
