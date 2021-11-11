import { HttpClient } from '@angular/common/http';
import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { CompraComicDTO } from '../dto/compra-comic-dto';
import { AbstractService } from './template.service';

@Injectable({
  providedIn: 'root'
})
export class CompraComicService extends AbstractService {

  constructor(private injector : Injector, private httpClient : HttpClient) { 
    super(injector);
  }

  public comprarComic(comicCompraDTO:CompraComicDTO) : Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/comprarComic/comprar',comicCompraDTO);
  }
}
