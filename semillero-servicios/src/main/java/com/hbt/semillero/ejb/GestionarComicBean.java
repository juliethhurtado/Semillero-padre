package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.rest.GestionComicRest;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarComicBean implements IGestionarComicLocal {
	private final static Logger log = Logger.getLogger(GestionarComicBean.class);
	@PersistenceContext
	public EntityManager em;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	@Override
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(Long idComic) {
		String consulta = "SELECT new com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO(c.nombre, c.precio)  "
						+ " FROM Comic c WHERE c.id = :idComic";
		ConsultaNombrePrecioComicDTO consultaNombrePrecioDTO = new ConsultaNombrePrecioComicDTO();
		try {
			Query consultaNativa = em.createQuery(consulta);
			consultaNativa.setParameter("idComic", idComic);
			consultaNombrePrecioDTO = (ConsultaNombrePrecioComicDTO) consultaNativa.getSingleResult();
			consultaNombrePrecioDTO.setExitoso(true);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");	
		} catch (Exception e) {
			consultaNombrePrecioDTO.setExitoso(false);
			consultaNombrePrecioDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
		}

		return consultaNombrePrecioDTO;
	}
	
	

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO crearComic(ComicDTO comicDTO) throws Exception {
		
		if(comicDTO.getNombre() == null) {
			throw new Exception("El campo nombre es requerido");
		}
		
		ComicDTO comicDTOResult = null;
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		comicDTOResult = this.convertirComicToComicDTO(comic);
		comicDTOResult.setExitoso(true);
		comicDTOResult.setMensajeEjecucion("El comic ha sido creado exitosamente");
		return comicDTOResult;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ComicDTO editarComic(ComicDTO comicDTO) throws Exception {
		
		if(comicDTO.getId() == null) {
			throw new Exception("El comic no se encuentra");
		}
		
		ComicDTO comicDTOResult = null;
		Comic comic = this.convertirComicDTOToComic(comicDTO);
		em.persist(comic);
		comicDTOResult = this.convertirComicToComicDTO(comic);
		comicDTOResult.setExitoso(true);
		comicDTOResult.setMensajeEjecucion("El comic ha sido creado exitosamente");
		return comicDTOResult;
	}
	
	@Override
	public ResultadoDTO actualizarComic(ComicDTO comic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoDTO eliminarComic(Long idComic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComicDTO> consultarComics(ComicDTO criterio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un comic a un comicDTO
	 * 
	 * @param comic
	 * @return
	 */
	public ComicDTO convertirComicToComicDTO(Comic comic) {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId(comic.getId());
		comicDTO.setNombre(comic.getNombre());
		comicDTO.setEditorial(comic.getEditorial());
		comicDTO.setTematicaEnum(comic.getTematicaEnum());
		comicDTO.setColeccion(comic.getColeccion());
		comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
		comicDTO.setPrecio(comic.getPrecio());
		comicDTO.setAutores(comic.getAutores());
		comicDTO.setColor(comic.getColor());
		comicDTO.setFechaVenta(comic.getFechaVenta());
		comicDTO.setEstadoEnum(comic.getEstadoEnum());
		comicDTO.setCantidad(comic.getCantidad());
		return comicDTO;
	}
				
	/**
	 * 
	 * Metodo encargado de transformar un comicDTO a un comic
	 * 
	 * @param comic
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		comic.setNombre(comicDTO.getNombre());
		comic.setEditorial(comicDTO.getEditorial());
		comic.setTematicaEnum(comicDTO.getTematicaEnum());
		comic.setColeccion(comicDTO.getColeccion());
		comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
		comic.setPrecio(comicDTO.getPrecio());
		comic.setAutores(comicDTO.getAutores());
		comic.setColor(comicDTO.getColor());
		comic.setFechaVenta(comicDTO.getFechaVenta());
		comic.setEstadoEnum(comicDTO.getEstadoEnum());
		comic.setCantidad(comicDTO.getCantidad());
		return comic;
	}

	@Override
	public ComicTamanioNombreDTO consultarComicTamanioNombre(Short lengthComic) {
		String consultaMayores = "SELECT c.nombre "
				+ " FROM Comic c WHERE LENGTH(c.nombre)> :lengthComic";
		String consultaMenores = "SELECT c.nombre "
				+ " FROM Comic c WHERE LENGTH(c.nombre)< :lengthComic";
		List<String> listaMayores = new ArrayList<String>() ;
		List<String> listaMenores= new ArrayList<String>() ;
		
		List<String> listaStringMenores= new ArrayList<String>() ;
		List<String> listaStringMayores= new ArrayList<String>() ;
		
		ComicTamanioNombreDTO consultarComicTamanioNombreDTO = new ComicTamanioNombreDTO();
		try {
			Query consultaNativa = em.createQuery(consultaMayores);
			consultaNativa.setParameter("lengthComic", lengthComic.intValue());
			listaMayores = consultaNativa.getResultList();
			for(String data :  listaMayores) {
				listaStringMayores.add(data);
			}
			
			Query consultaNativa2 = em.createQuery(consultaMenores);
			consultaNativa2.setParameter("lengthComic", lengthComic.intValue());
			listaMenores = consultaNativa2.getResultList();
			for(String data :  listaMenores) {
				listaStringMenores.add(data);
			}
				
			consultarComicTamanioNombreDTO.setExitoso(true);
			consultarComicTamanioNombreDTO.setMensajeEjecucion("Se ejecuto exitosamente la consulta");	
		} catch (Exception e) {
			e.printStackTrace();
			consultarComicTamanioNombreDTO.setExitoso(false);
			consultarComicTamanioNombreDTO.setMensajeEjecucion("Se ha presentado un error tecnico al consultar el comic");
		}
		consultarComicTamanioNombreDTO.setComicsSuperanTamanio(listaStringMayores);
		consultarComicTamanioNombreDTO.setComicsNoSuperanTamanio(listaStringMenores);
		return consultarComicTamanioNombreDTO;
		
		}



	@Override
	public List<ComicDTO> listarComics() throws Exception {
		List <Comic> comicResultList = new ArrayList<Comic>();
		List <ComicDTO> comicDTOResultList  = null ;
		try {
			String listarLosComics = "SELECT * FROM comic ";
			Query queryComics = em.createNativeQuery(listarLosComics, Comic.class);
			comicResultList = (List<Comic>) queryComics.getResultList();
			comicDTOResultList = comicResultList.stream()
					.map(this::convertirComicToComicDTO)
					.collect(Collectors.toList());
		}  catch (Exception e) {
			
			log.info("SE HA PRESENTADO UN ERROR TECNICO" +  e.getMessage());
		}
		return comicDTOResultList;
	}
}
	
