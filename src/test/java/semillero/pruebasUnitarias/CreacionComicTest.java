package semillero.pruebasUnitarias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.hbt.semillero.enums.*;

import com.hbt.semillero.dto.ComicDTO;

public class CreacionComicTest {
	/**
	 * Constante que contendra el log de la clase AritmeticaTest
	 */
	private final static Logger log = Logger.getLogger(OperacionesAritmeticasTest.class);
	
	@BeforeTest
	public void inicializar() {
		BasicConfigurator.configure(); // Inicializa el logger con una configuracion basica
		log.info(":::::::::::::::::::::::::::: INICIAN PRUEBAS UNITARIAS :::::::::::::::::::::::::::: ");
	}
	
	LocalDate ahora = LocalDate.now();
	ArrayList<ComicDTO> comics = new ArrayList<ComicDTO>();
	
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
		CrearComits();
		ArrayList<ComicDTO> comicsActivos = new ArrayList<ComicDTO>();
		for(int i = 0; i <= comics.size(); i++) {
			if(comics.get(i).getEstado() == EstadoEnum.ACTIVO ) {
				comicsActivos.add(comics.get(i));
			}
		}
		return comicsActivos;
	}
	
	private ArrayList<ComicDTO> ComicsInactivos() {
		CrearComits();
		ArrayList<ComicDTO> comicsInactivos = new ArrayList<ComicDTO>();
		for(int i = 0; i <= comics.size(); i++) {
			if(comics.get(i).getEstado() == EstadoEnum.INACTIVO) {
				comicsInactivos.add(comics.get(i));
			}
		}
		return comicsInactivos;
	}
	
	
	@Test
	public void ValidarComicsActivos() {
		ComicsActivos();
		log.info("Inicia ejecucion del HOLA metodo ValidarComicsActivos()");
		
		/*for(int i = 0; i <= res.size(); i++) {
			System.out.println(res.get(i).getNombre());
		}*/
			
		System.out.println("puto");
		
		log.info("Finaliza la ejecucion del metodo ValidarComicsActivos()");
	}
	
	
	
	@AfterTest
	public void finalizaPruebasUnitarias() {
		log.info(":::::::::::::::::::::::::::: FINALIZAN PRUEBAS UNITARIAS :::::::::::::::::::::::::::: ");
	}

}
