package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic {
	
	@PersistenceContext
	public EntityManager em;

	@Override
	public ResultadoDTO comprarComic(Long idComic, Integer cantidad)  throws Exception {
		
		String consutarByIdQuery = "SELECT * FROM comic WHERE SCID = :idComic ";
		Query consultaNativa = em.createNativeQuery(consutarByIdQuery,Comic.class);
		consultaNativa.setParameter("idComic", idComic);
		Comic c = (Comic) consultaNativa.getSingleResult();
		if(cantidad<=0) {
			throw new Exception("cantidad no valida!");
		}
		if(c.getEstadoEnum()==EstadoEnum.INACTIVO || c.getCantidad()==0) {
			throw new Exception("El comic seleccionado no cuenta con stock en bodega");
		}
		
		if(cantidad > c.getCantidad()) {
			throw new Exception("La cantidad existente del comic es:"+c.getCantidad()+", y es menor a la ingresada");
		}
		
	    c.setCantidad(c.getCantidad()-cantidad);
	    if(c.getCantidad()==0) {
	    	c.setEstadoEnum(EstadoEnum.INACTIVO);
	    }
	    em.persist(c);
	    return new ResultadoDTO(true,"La compra del comic "+c.getNombre()+" fue exitosa");
	}

}
