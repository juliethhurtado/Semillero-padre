import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';
import { CompraComicDTO } from '../../dto/compra-comic-dto';
import { CompraComicService } from '../../servicios/compra-comic.service';



@Component({
    selector: 'compra-comic',
    templateUrl: './compra-comic.component.html'
})
export class CompraComicComponent implements OnInit {


    private idComic: number;

    public comprarComicForm: FormGroup;


    constructor(private route: ActivatedRoute, private fb: FormBuilder, private router: Router, private compraComicService: CompraComicService) {
        this.comprarComicForm = this.fb.group({
            nombreComic: [null, Validators.required],
            idComic: [null, Validators.required],
            cantidadComic: [null],
        });
    }

    ngOnInit(): void {
        this.f.nombreComic.setValue(this.route.snapshot.params.nombre);
        this.f.idComic.setValue(this.route.snapshot.params.id);
        this.idComic = this.route.snapshot.params.id;
    }


    public comicDTO: ComicDTO;

    public comprar() {
         const compraComicDTO = new CompraComicDTO();
        compraComicDTO.cantidadComic = this.f.cantidadComic.value;
        compraComicDTO.idComic =   this.idComic;
        this.compraComicService.comprarComic(compraComicDTO).subscribe(data=>{
            this.router.navigate(['gestionar-comic']);
        });
    }
    get f() {
        return this.comprarComicForm.controls;
    }

}
