import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { environment } from '../../environments/environment';
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
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT'
    }),
  };

  constructor(private http: HttpClient) {}

  cargarLibros(): Observable<Libro[]> {
    return this.http.get<Libro[]>('http://localhost:8080/books/all', this.httpOptions);
  }

}
