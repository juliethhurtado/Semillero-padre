package com.hbt.semillero;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;




public class CreacionComicTest {
	/**
	 * Constante que contendra el log de la clase AritmeticaTest
	 */
	private final static Logger log = Logger.getLogger(CreacionComicTest.class);
	
	@BeforeTest
	public void inicializar() {
		BasicConfigurator.configure(); // Inicializa el logger con una configuracion basica
		log.info(":::::::::::::::::::::::::::: INICIAN PRUEBAS UNITARIAS :::::::::::::::::::::::::::: ");
	}
	
	LocalDate ahora = LocalDate.now();
	ArrayList<ComicDTO> comics = new ArrayList<ComicDTO>();
	
	
	public CreacionComicTest() {
		super();
		CrearComits();
	}

	public void CrearComits() {
		ComicDTO comic1= new ComicDTO(20L , "TRUELOVE", "WEBTOONS", TematicaEnum.AVENTURAS, "C1", 154, new BigDecimal(250000), "Maria Becerra", false , ahora, EstadoEnum.INACTIVO, 1000);
		comics.add(comic1);
		ComicDTO comic2= new ComicDTO(21L , "O2", "WEBTOONS", TematicaEnum.BELICO, "C2", 154, new BigDecimal(250000), "Frank Miller", true , ahora, EstadoEnum.ACTIVO, 1000);
		comics.add(comic2);
		ComicDTO comic3= new ComicDTO(22L , "BOYS AND FLOWER", "WEBTOONS", TematicaEnum.CIENCIA_FICCION, "C3", 154, new BigDecimal(250000), "Art Spigel", false , ahora, EstadoEnum.INACTIVO, 1000);
		comics.add(comic3);
		ComicDTO comic4= new ComicDTO(23L , "TIN TIN", "WEBTOONS", TematicaEnum.CIENCIA_FICCION, "C1", 154, new BigDecimal(250000), "Maria Becerra", false , ahora, EstadoEnum.INACTIVO, 1000);
		comics.add(comic4);
		ComicDTO comic5= new ComicDTO(24L , "ALAN MORE", "WEBTOONS", TematicaEnum.HISTORICO, "C3", 154, new BigDecimal(250000), "Alan More", true , ahora, EstadoEnum.ACTIVO, 1000);
		comics.add(comic5);
		ComicDTO comic6= new ComicDTO(25L , "MAUS", "WEBTOONS", TematicaEnum.AVENTURAS, "C1", 154, new BigDecimal(250000), "Scott Marchall", false , ahora, EstadoEnum.ACTIVO, 1000);
		comics.add(comic6);
		ComicDTO comic7= new ComicDTO(26L , "BATMAN", "MARBEL", TematicaEnum.HUMORISTICO, "C2", 154, new BigDecimal(250000), "Maria Becerra", true , ahora, EstadoEnum.INACTIVO, 1000);
		comics.add(comic7);
		ComicDTO comic8= new ComicDTO(27L , "FROM HELL", "WEBTOONS", TematicaEnum.HORROR, "C1", 154, new BigDecimal(250000), "Art Spigal", false , ahora, EstadoEnum.ACTIVO, 1000);
		comics.add(comic8);
		ComicDTO comic9= new ComicDTO(28L , "ANIMAL MAN", "WEBTOONS", TematicaEnum.AVENTURAS, "C1", 154, new BigDecimal(250000), "Alejando Joa", false , ahora, EstadoEnum.ACTIVO, 1000);
		comics.add(comic9);
		ComicDTO comic10= new ComicDTO(29L , "SPIDER MAN", "MARBEL", TematicaEnum.DEPORTIVO, "C1", 154, new BigDecimal(250000), "Maria Becerra", false , ahora, EstadoEnum.INACTIVO, 1000);
		comics.add(comic10);
	}

	private ArrayList<ComicDTO> ComicsActivos() {
		ArrayList<ComicDTO> comicsActivos = new ArrayList<ComicDTO>();
		for(int i = 0; i < comics.size(); i++) {
			if(comics.get(i).getEstado() == EstadoEnum.ACTIVO ) {
				comicsActivos.add(comics.get(i));
			}
		}
		return comicsActivos;
	}
	
	private ArrayList<ComicDTO> ComicsInactivos() throws Exception {
		int sizeL =  this.comics.size();
		int activos=0,inactivos=0;
		ArrayList<String> comicsInactivos = new ArrayList<String>();
		for (ComicDTO dto: comics) {
			if(dto.getEstado() == EstadoEnum.ACTIVO ) {
				activos++;
			}
			if(dto.getEstado() == EstadoEnum.INACTIVO ) {
				inactivos++;
				comicsInactivos.add(dto.getNombre());
			}
		}
		
		throw new Exception("Se ha detectado que de "+sizeL+" comics se encontraron que "+activos+" se encunetran activos y "+inactivos+" inactivos. Los comics inactivos son:"+Arrays.toString(comicsInactivos.toArray()));
	}
	
	
	@Test
	public void ValidarComicsActivos() {
		ArrayList<ComicDTO>  activos = ComicsActivos();
		log.info("Inicia ejecucion del HOLA metodo ValidarComicsActivos()");
		for(ComicDTO dto : activos) {
			System.out.println(dto);
			Assert.assertEquals(dto.getEstado(),EstadoEnum.ACTIVO);
		}
		log.info("Finaliza la ejecucion del metodo ValidarComicsActivos()");
	}
	
	@Test
	public void ValidarComicsInactivos() {
		log.info("Inicia ejecucion del HOLA metodo ValidarComicsInactivos()");
		try {
			ComicsInactivos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.assertNotNull(e.getMessage());
		}
		log.info("Finaliza la ejecucion del metodo ValidarComicsInactivos()");
	}
	
	
	
	
	@AfterTest
	public void finalizaPruebasUnitarias() {
		log.info(":::::::::::::::::::::::::::: FINALIZAN PRUEBAS UNITARIAS :::::::::::::::::::::::::::: ");
	}

}
