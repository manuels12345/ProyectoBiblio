import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable, Output } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Usuario } from '../models/Usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class UsuarioService {


  private apiUrl = environment.apiUrl;
  private usuariosUrl = environment.usuariosUrl;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Methods': 'GET, PUT, POST, DELETE, HEAD, OPTIONS'
    }),
  };

  constructor(private http: HttpClient) {}

  agregarUsuario(nombre:string, apellido:string, direccion:string, tel:string, username:string,pw:string): Observable<Usuario> {

    const formData = new FormData();
    formData.append('name', nombre);
    formData.append('last_name', apellido);
    formData.append('address', direccion);
    formData.append('tel', tel);
    formData.append('username', username);
    formData.append('password', pw);

    return this.http.post<Usuario>(this.apiUrl+this.usuariosUrl, formData);
  }

}
