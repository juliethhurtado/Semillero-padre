package com.hbt.semillero.ejb;

import javax.ejb.Local;


import com.hbt.semillero.dto.ResultadoDTO;

@Local
public interface IGestionarCompraComic {
	public ResultadoDTO comprarComic(Long idComic, Integer cantidad) throws Exception;
}
