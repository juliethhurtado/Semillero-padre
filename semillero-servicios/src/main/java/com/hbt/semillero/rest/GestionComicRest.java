package com.hbt.semillero.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ComicTamanioNombreDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;
import com.hbt.semillero.entidad.Comic;


/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Julieta Hurtado
 * @version
 */
@Path("/gestionarComic")
public class GestionComicRest {
	/**
	 * Constante que contendra el log de la clase AritmeticaTest
	 */
	private final static Logger log = Logger.getLogger(GestionComicRest.class);
	
	@EJB
	private IGestionarComicLocal gestionarComicLocal;
	
	//abre y cierra conexion
	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("/consultarNombrePrecioComic")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public ConsultaNombrePrecioComicDTO consultarNombrePrecioComic(@QueryParam("idComic") Long idComic) {
		return gestionarComicLocal.consultarNombrePrecioComic(idComic);
	}

	
	@GET
	@Path("/consultarComicTamanioNombre")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public  ComicTamanioNombreDTO  consultarComicTamanioNombre(@QueryParam("lengthComic") Short lengthComic) {
		return gestionarComicLocal.consultarComicTamanioNombre(lengthComic);
	}

	
	
	@POST
	@Path("/crearComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ComicDTO crearComic(ComicDTO comicDTO) {
		ComicDTO comicDTOResult = new ComicDTO();
		try {
			comicDTOResult = this.gestionarComicLocal.crearComic(comicDTO);
		}  catch (Exception e) {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico, causa: " + e.getMessage());
		}
		return comicDTOResult;
	} 

	
	
	@GET
	@Path("/prueba")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public String Prueba() {
		return "";
	}
	
	
	@GET
	@Path("/listarComics")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List <ComicDTO> listarComics() throws Exception  {
			return this.gestionarComicLocal.listarComics();
	}

	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unchecked")
	public String obtenerUnComic() {
		BasicConfigurator.configure();
		Comic comic = null;
		try {
			//Obtencion de un registro de la tabla comic haciendo uso de la clase EntityManager
			//SELECT * FROM COMIC WHERE ID = 24;
			//comic = em.find(Comic.class, 24L);
			
			//Consulta en JPQL para obtener un comic en el ide 24pero quemado, haciendo uso del metodo getsingleresult
			String consultaUnComic = " SELCT c FROM Comic c WHERE c.id = 24 ";
			Query queryUnComic = em.createQuery(consultaUnComic);
			comic = (Comic) queryUnComic.getSingleResult();
			
			//Consulta en JPQL para obtener un comic en el ide 24, haciendo uso del metodo getsingleresult y set parameter
			String consultaUnComicConParametro = " SELCT c FROM Comic c WHERE c.id = :idComic ";
			Query queryUnComicConParametro = em.createQuery(consultaUnComicConParametro);
			queryUnComicConParametro.setParameter("idComic", 24L);
			comic = (Comic) queryUnComicConParametro.getSingleResult();
			
			String findAllComic = " SELCT cm FROM Comic c  ";
			Query queryFindAllComic = em.createQuery(findAllComic);

			List<Comic> listaComics = queryFindAllComic.getResultList();
			
		} catch (Exception e) {
			log.info("SE HA PRESENTADO UN ERROR TECNICO" +  e.getMessage());
			return e.getMessage();
		}

		return comic.toString();
	}

}
