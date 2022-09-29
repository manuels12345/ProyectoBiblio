import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Libro } from '../models/Libro';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class LibrosService {

  public libros: Libro[] = [];

  private apiUrl = environment.apiUrl;
  private libreriaUrl = environment.libraryUrl;
  private librosUrl = environment.librosUrl;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private http: HttpClient) {}

  cargarLibros(): Observable<Libro[]> {
    return this.http.get<Libro[]>(this.apiUrl+this.libreriaUrl+this.librosUrl);
  }

}
