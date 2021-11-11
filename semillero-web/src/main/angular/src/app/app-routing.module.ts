import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic.component';
import { MenuComponent } from './semillero/componentes/menu/menu-component';
import { CompraComicComponent } from './semillero/componentes/comprar-comic/compra-comic.component';
import { ComicDTO } from './semillero/dto/comic-dto';

const routes: Routes = [
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'menu', component: MenuComponent },
  { path: 'comprar', component: CompraComicComponent,data : ComicDTO },
  { path: '**', component: CompraComicComponent,data : ComicDTO }
  //{ path: 'modal', component: NgbdModalContent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
