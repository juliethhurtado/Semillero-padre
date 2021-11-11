package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicCompraDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.GestionarCompraComicBean;
import com.hbt.semillero.ejb.IGestionarCompraComic;

@Path("/comprarComic")
public class GestionarCompraComicRest {
	
	@EJB
	private IGestionarCompraComic gestionarCompraComicBean; 
	
	@POST
	@Path("/comprar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO comprar(ComicCompraDTO comicCompraDto)  {
		try {
			return this.gestionarCompraComicBean.comprarComic(comicCompraDto.getIdComic(), comicCompraDto.getCantidadComic());
		} catch (Exception e) {
			return new ResultadoDTO(false,e.getMessage());
		}
	} 
}
