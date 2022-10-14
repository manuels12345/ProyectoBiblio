import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

import { Libro } from 'src/app/models/Libro';
import { LibrosService } from 'src/app/servicios/libro.service';


@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.css']
})

export class LibrosComponent implements OnInit {

  idLibro!:number;
  libros: Libro[] = [];

  constructor(private app: AppComponent, private librosService: LibrosService, private router: Router) { }

  ngOnInit(): void {
    this.cargarLibros();
  }

  cargarLibros() {
    return this.librosService.cargarLibros().subscribe((data) => {
      data.forEach((dato) =>{
        this.libros.push(dato);
      });
      console.log(data);
      return data;
    });
  }
  
  mostrarLogs():void{
    console.log(this.app.jwt);
    console.log(this.app.authenticated);
  }
}
