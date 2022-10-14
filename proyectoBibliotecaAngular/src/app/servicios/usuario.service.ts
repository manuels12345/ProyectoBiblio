import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../models/Usuario';
import { Observable } from 'rxjs';
import { AuthenticationRequest } from '../models/AuthenticationRequest';
import { AuthenticationResponse } from '../models/AuthenticationResponse';
import { User } from '@auth0/auth0-angular';

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
    return this.http.post<Usuario>('http://localhost:8080/auth/register', usuario, this.httpOptions);
  }

  loginUsuario(usuario: AuthenticationRequest): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>('http://localhost:8080/auth/login', usuario, this.httpOptions);
  }

}
