import { Component, OnInit } from '@angular/core';

import { Libro } from 'src/app/models/Libro';
import { LibrosService } from 'src/app/servicios/libro.service';


@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.css']
})
export class LibrosComponent implements OnInit {

  libros: Libro[] = [];

  constructor(private librosService: LibrosService) { }

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

}
