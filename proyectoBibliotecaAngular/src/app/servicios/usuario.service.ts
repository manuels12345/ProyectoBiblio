import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Usuario } from '../models/Usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class UsuarioService {

  nombreUsuario: string = '';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT'
    }),
  };

  constructor(private http: HttpClient) {}

  agregarUsuario(usuario : Usuario): Observable<Usuario> {
    return this.http.post<Usuario>('http://localhost:8080/users/register', usuario, this.httpOptions);
  }
  cargarUsuario(username: string): Observable<Usuario> {
    return this.http.get<Usuario>('http://localhost:8080/users/email=' + username, this.httpOptions);
  }

}
